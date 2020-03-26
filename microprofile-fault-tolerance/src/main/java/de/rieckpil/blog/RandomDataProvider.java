package de.rieckpil.blog;

import org.eclipse.microprofile.faulttolerance.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class RandomDataProvider {

  private WebTarget webTarget;

  @PostConstruct
  public void setUp() {
    Client client = ClientBuilder.newBuilder()
      .connectTimeout(5, TimeUnit.SECONDS)
      .readTimeout(5, TimeUnit.SECONDS)
      .build();

    this.webTarget = client
      .target("https://jsonplaceholder.typicode.com/posts");
  }

  @Fallback(PlaceHolderApiFallback.class)
//  @Fallback(fallbackMethod = "getDefaultPost")
  public JsonObject getPostById(Long id) {
    return this.webTarget
      .path(String.valueOf(id))
      .request()
      .accept(MediaType.APPLICATION_JSON)
      .get(JsonObject.class);
  }

  public JsonObject getDefaultPost(Long id) {
    return Json.createObjectBuilder()
      .add("comment", "Lorem ipsum")
      .add("postId", id)
      .build();
  }

  @CircuitBreaker(successThreshold = 10, requestVolumeThreshold = 5, failureRatio = 0.5, delay = 500)
  @Fallback(fallbackMethod = "getFallbackData")
  public String getRandomData() {
    if (ThreadLocalRandom.current().nextLong(1000) < 300) {
      return "random duke";
    } else {
      throw new RuntimeException("Random data not available");
    }
  }

  @Timeout(value = 4, unit = ChronoUnit.SECONDS)
  @Fallback(fallbackMethod = "getFallbackData")
  public String getDataFromLongRunningTask() throws InterruptedException {
    Thread.sleep(4500);
    return "duke";
  }

  @Retry(maxDuration = 5000, maxRetries = 3, delay = 500, jitter = 200)
  @Fallback(fallbackMethod = "getFallbackData")
  public String accessFlakyService() {

    System.out.println("Trying to access flaky service at " + LocalTime.now());

    if (ThreadLocalRandom.current().nextLong(1000) < 50) {
      return "flaky duke";
    } else {
      throw new RuntimeException("Flaky service not accessible");
    }
  }

  @Bulkhead(5)
  @Asynchronous
  public Future<String> getConcurrentServiceData(String name) {
    try {
      System.out.println(name + " is accessing the concurrent service");
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      return CompletableFuture.completedFuture("concurrent duke");
    }
  }

  public String getFallbackData() {
    return "fallback duke";
  }
}
