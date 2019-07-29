package de.rieckpil.udemy;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class ClientLoggingResponseFilter implements ClientResponseFilter {

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        System.out.println("Response filter for JAX-RS Client");
        responseContext.getHeaders().forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
