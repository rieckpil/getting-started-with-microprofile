package de.rieckpil.blog;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("books")
public class BookResource {

  @Inject
  private BookProvider bookProvider;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBooks() {
    return Response.ok(bookProvider.getBooksFromBookStore()).build();
  }

}
