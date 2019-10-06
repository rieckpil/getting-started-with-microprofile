package de.rieckpil.blog;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PostService {

    @Inject
    @RestClient
    JSONPlaceholderClient jsonPlaceholderClient;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) throws URISyntaxException {
        restClientBuilderExample();
        // getAllPosts();
        // getSinglePost();
        // createNewPost();
        // updateExistingPost();
        // deletePost();
    }

    private void restClientBuilderExample() throws URISyntaxException {
        System.out.println("------ Rest Client builder example ------");

        JSONPlaceholderClient jsonApiClient = RestClientBuilder.newBuilder()
                .baseUri(new URI("https://jsonplaceholder.typicode.com"))
                .register(ResponseLoggingFilter.class)
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build(JSONPlaceholderClient.class);

        jsonApiClient.getPostById("1").thenAccept(System.out::println);
    }

    private void deletePost() {
        System.out.println("------ delete a post ------");

        Response postDeletionResult = jsonPlaceholderClient.deletePostById("42");

        System.out.println(postDeletionResult.readEntity(JsonObject.class));
    }

    private void updateExistingPost() {
        System.out.println("------ update a post ------");

        JsonObject postUpdate = Json.createObjectBuilder()
                .add("id", 42)
                .add("title", "Jakarta EE 8")
                .add("body", "Work with Jakarta EE 8")
                .add("userId", 1)
                .build();

        Response postUpdateResult = jsonPlaceholderClient.updatePostById("42", postUpdate, UUID.randomUUID().toString());

        System.out.println(postUpdateResult.readEntity(JsonObject.class));
    }

    private void createNewPost() {
        System.out.println("------ create new post ------");

        JsonObject post = Json.createObjectBuilder()
                .add("id", 42)
                .add("title", "MicroProfile")
                .add("body", "Work with MicroProfile")
                .add("userId", 1)
                .build();

        Response postCreationResult = jsonPlaceholderClient.createPost(post);

        System.out.println(postCreationResult.readEntity(JsonObject.class));
    }

    private void getSinglePost() {
        System.out.println("------ single post ASYNC ------");
        jsonPlaceholderClient.getPostById("1").thenAccept(System.out::println);
    }

    private void getAllPosts() {
        System.out.println("------ all posts ------");

        jsonPlaceholderClient.getAllPosts("ASC")
                .stream()
                .limit(5)
                .forEach(System.out::println);
    }

}
