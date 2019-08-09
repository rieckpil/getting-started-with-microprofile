package de.rieckpil.udemy;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import java.util.UUID;

@ApplicationScoped
public class PostService {

    @Inject
    @RestClient
    JSONPlaceholderClient jsonPlaceholderClient;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        getAllPosts();
        getSinglePost();
        createNewPost();
        updateExistingPost();
        deletePost();
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

        jsonPlaceholderClient.getAllPosts()
                .stream()
                .limit(5)
                .forEach(System.out::println);
    }

}
