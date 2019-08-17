package de.rieckpil.blog;

import org.eclipse.microprofile.faulttolerance.*;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.annotation.PostConstruct;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

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

    public JsonArray getAllPosts() {
        return this.webTarget
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(JsonArray.class);
    }

    public JsonObject getPostById(Long id) {
        return this.webTarget
                .path(String.valueOf(id))
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(JsonObject.class);
    }

    @CircuitBreaker(successThreshold = 10, requestVolumeThreshold = 5, failureRatio = 0.5, delay = 500)
    @Fallback(fallbackMethod = "getFallbackData")
    public String getRandomData() {
        if (ThreadLocalRandom.current().nextLong(1000) < 300) {
            return "random duke";
        } else {
            throw new RuntimeException("Flaky service not accessible");
        }
    }

    @Timeout(4000)
    @Fallback(fallbackMethod = "getFallbackData")
    public String getDataFromLongRunningTask() {
        try {
            Thread.sleep(4500);
            return "duke";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " is accessing the concurrent service");
        return CompletableFuture.completedFuture("concurrent duke");
    }

    public String getFallbackData() {
        return "fallback duke";
    }
}
