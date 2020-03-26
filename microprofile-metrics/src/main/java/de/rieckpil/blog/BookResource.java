package de.rieckpil.blog;

import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ThreadLocalRandom;

@RequestScoped
@Path("books")
public class BookResource {

  @Inject
  private BookCommentClient bookCommentClient;

  @Inject
  private BookRequestProcessor bookRequestProcessor;

  @GET
  @Metered(name = "getBookCommentForLatestBookRequest", tags = {"spec=JAX-RS", "level=REST"})
  @Produces(MediaType.TEXT_PLAIN)
  public Response getBookCommentForLatestBookRequest() {
    String latestBookRequestId = bookRequestProcessor.getLatestBookRequestId();
    return Response.ok(this.bookCommentClient.getBookCommentByBookId(latestBookRequestId)).build();
  }

  @GET
  @SimplyTimed
  @Path("/microprofile")
  @Produces(MediaType.TEXT_PLAIN)
  public Response getMicroProfileBook() throws InterruptedException {
    Thread.sleep(ThreadLocalRandom.current().nextLong(100, 1000));
    return Response.ok("Getting Started With Eclipse MicroProfile").build();
  }
}
