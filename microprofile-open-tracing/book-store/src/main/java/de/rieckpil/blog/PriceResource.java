package de.rieckpil.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ThreadLocalRandom;

@Path("prices")
@ApplicationScoped
public class PriceResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getPriceForBook(@PathParam("id") Integer bookId) {
        System.out.println("Retrieving price for book with id: " + bookId);
        sleepRandom();
        return Response.ok(ThreadLocalRandom.current().nextDouble(20.0, 42.0)).build();
    }

    private void sleepRandom() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(100, 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
