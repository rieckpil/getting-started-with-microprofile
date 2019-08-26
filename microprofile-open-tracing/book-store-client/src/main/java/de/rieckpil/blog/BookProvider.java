package de.rieckpil.blog;

import org.eclipse.microprofile.opentracing.Traced;

import javax.annotation.PostConstruct;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestScoped
public class BookProvider {

    @Inject
    private PriceCalculator priceCalculator;

    private WebTarget bookStoreTarget;

    @PostConstruct
    public void setup() {
        Client client = ClientBuilder
                .newBuilder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();

        this.bookStoreTarget = client.target("http://book-store:9080/resources/books");
    }

    @Traced
    public JsonArray getBooksFromBookStore() {

        JsonArray books = this.bookStoreTarget
                .request()
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
}
