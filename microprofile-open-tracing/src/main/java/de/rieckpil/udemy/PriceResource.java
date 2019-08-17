package de.rieckpil.blog;

import org.eclipse.microprofile.opentracing.Traced;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ThreadLocalRandom;

@Path("prices")
public class PriceResource {

    @GET
    @Traced
    @Produces(MediaType.TEXT_PLAIN)
    public Response getPriceForBook() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
        return Response.ok(42).build();
    }
}
