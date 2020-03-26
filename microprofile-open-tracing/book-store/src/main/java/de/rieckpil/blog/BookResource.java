package de.rieckpil.blog;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("books")
@ApplicationScoped
public class BookResource {

  private JsonArray books;

  @PostConstruct
  public void setup() {

    JsonObject bookOne = Json.createObjectBuilder()
      .add("id", 1)
      .add("title", "MicroProfile 3.0")
      .build();

    JsonObject bookTwo = Json.createObjectBuilder()
      .add("id", 2)
      .add("title", "Jakarta EE 8")
      .build();

    JsonObject bookThree = Json.createObjectBuilder()
      .add("id", 3)
      .add("title", "Java 13")
      .build();

    this.books = Json.createArrayBuilder()
      .add(bookOne)
      .add(bookTwo)
      .add(bookThree)
      .build();

  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAvailableBooks() {
    return Response.ok(this.books).build();
  }

}
