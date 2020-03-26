package de.rieckpil.blog;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestScoped
public class BookProvider {

  @Inject
  private PriceCalculator priceCalculator;

  private WebTarget bookStoreTarget;
  private Client client;

  @PostConstruct
  public void setup() {
    this.client = ClientBuilder
      .newBuilder()
      .connectTimeout(2, TimeUnit.SECONDS)
      .readTimeout(2, TimeUnit.SECONDS)
      .build();

    this.bookStoreTarget = client.target("http://book-store:9080/resources/books");
  }

  public JsonArray getBooksFromBookStore() {

    JsonArray books = this.bookStoreTarget
      .request()
      .accept(MediaType.APPLICATION_JSON)
      .get()
      .readEntity(JsonArray.class);

    List<JsonObject> result = new ArrayList();

    for (JsonObject book : books.getValuesAs(JsonValue::asJsonObject)) {
      result.add(Json.createObjectBuilder()
        .add("title", book.getString("title"))
        .add("price", priceCalculator.getPriceForBook(book.getInt("id")))
        .build());
    }

    return result
      .stream()
      .collect(JsonCollectors.toJsonArray());
  }

  @PreDestroy
  public void tearDown() {
    this.client.close();
  }
}
