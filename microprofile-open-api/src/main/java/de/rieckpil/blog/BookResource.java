package de.rieckpil.blog;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("books")
public class BookResource {

    @GET
    @Operation(summary = "Get all books", description = "Returns all available books of the book store XYZ")
    @APIResponse(responseCode = "404", description = "No books found")
    @APIResponse(responseCode = "418", description = "I'm a teapot")
    @APIResponse(responseCode = "500", description = "Server unavailable")
    @Tag(name = "BETA", description = "This API is currently in beta state")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        System.out.println("Get all books...");
        return Response.ok(new Book("MicroProfile", "Duke", 1L)).build();
    }

    @GET
    @APIResponse(description = "Book",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class)))
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getBookById(@PathParam("id") Long id) {
        System.out.println("Get book by id...");
        return Response.ok(new Book("MicroProfile", "Duke", 1L)).build();
    }

    @POST
    public Response createNewBook(JsonObject jsonObject, @Context UriInfo uriInfo) {
        System.out.println("Creating new book...");
        return Response.created(uriInfo.getAbsolutePathBuilder().build()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBookById(@PathParam("id") Long id) {
        System.out.println("Deleting book...");
        return Response.noContent().build();
    }
}
