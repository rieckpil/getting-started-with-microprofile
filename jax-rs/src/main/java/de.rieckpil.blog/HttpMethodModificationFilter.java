package de.rieckpil.blog;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class HttpMethodModificationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        if(requestContext.getMethod().equalsIgnoreCase("DELETE")) {
            requestContext.setMethod("GET");
        }

    }
}
