package de.rieckpil.udemy;

import javax.annotation.PostConstruct;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
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
                .target("https://reqres.in/api/users");
    }


    public JsonArray getAllPosts() {
        return this.webTarget
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(JsonArray.class);
    }

    public JsonObject getPostById(Long id) {
        return this.webTarget
                .path("1")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(JsonObject.class);
    }
}
