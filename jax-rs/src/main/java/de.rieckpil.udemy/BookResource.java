package de.rieckpil.udemy;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    private List<Book> bookStore;

    @PostConstruct
    public void init() {
        this.bookStore =  new ArrayList<>();
        this.bookStore.add(new Book(1L, "Java 11", "Duke"));
        this.bookStore.add(new Book(2L, "Java 12", "Duke"));
        this.bookStore.add(new Book(3L, "Java 13", "Duke"));
    }

    @GET
    @Logged
    public Response getBooks(@HeaderParam("User-Agent") String userAgent) {
        System.out.println(userAgent);
        return Response.ok(this.bookStore).build();
    }

    @GET
    @Path("async")
    public void getBooksAsync(@Suspended final AsyncResponse asyncResponse) {
        // do long running task
        asyncResponse.resume(this.bookStore);
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id, @QueryParam("title") @DefaultValue("") String title) {
        Book requestedBook = this.bookStore
                .stream()
                .filter(b -> b.getId() == id)
                .filter(b -> b.getTitle().contains(title))
                .findFirst().orElse(null);

        if(requestedBook == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(requestedBook).build();
    }

    @POST
    public Response getBookById(Book bookToStore, @Context UriInfo uriInfo) {
        this.bookStore.add(bookToStore);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(bookToStore.getId().toString());
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        this.bookStore.remove(id);
        return Response.noContent().build();
    }

}

