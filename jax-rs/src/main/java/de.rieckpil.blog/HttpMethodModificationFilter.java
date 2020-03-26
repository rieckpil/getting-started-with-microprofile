package de.rieckpil.blog;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

// uncomment to activate this evil filter ;)
// @Provider
public class HttpMethodModificationFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {

    if (requestContext.getMethod().equalsIgnoreCase("DELETE")) {
      requestContext.setMethod("GET");
    }

  }
}
