package de.rieckpil.udemy;

import org.eclipse.microprofile.opentracing.Traced;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("books")
public class BookResource {

    @Inject
    private BookManager bookManager;

    @GET
    @Traced
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBook() throws InterruptedException {
        return Response.ok(bookManager.getBook()).build();
    }

}
