package de.rieckpil.blog;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;

public class ResponseLoggingFilter implements ClientResponseFilter {

  @Override
  public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) throws IOException {
    System.out.println("Status code is: " + clientResponseContext.getStatus());
  }
}
