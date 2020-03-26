package de.rieckpil.blog;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

@Path("quotes")
public class QuoteResource {

  private WebTarget quotesApiTarget;
  private Client client;

  @PostConstruct
  public void initClient() {

    ClientBuilder clientBuilder = ClientBuilder.newBuilder()
      .connectTimeout(5, TimeUnit.SECONDS)
      .readTimeout(5, TimeUnit.SECONDS)
      .register(UserAgentClientFilter.class)
      .register(ClientLoggingResponseFilter.class);

    this.client = clientBuilder.build();
    this.quotesApiTarget = client.target("https://quotes.rest").path("qod");
  }

  @PreDestroy
  public void tearDown() {
    this.client.close();
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response getQuote() {

    JsonObject quoteApiResult = this.quotesApiTarget
      .request()
      .header("X-Foo", "bar")
      .accept(MediaType.APPLICATION_JSON)
      .get()
      .readEntity(JsonObject.class);

    CompletionStage<JsonObject> rxQuoteApiResult = this.quotesApiTarget
      .request()
      .header("X-Foo", "bar")
      .accept(MediaType.APPLICATION_JSON)
      .rx()
      .get(JsonObject.class);

    String quote = quoteApiResult
      .get("contents").asJsonObject()
      .get("quotes").asJsonArray().get(0).asJsonObject()
      .get("quote").toString();

    return Response.ok(quote).build();
  }

  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  public Response createQuote(String text) {
    System.out.println(text);
    return Response.created(null).build();
  }
}
