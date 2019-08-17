package de.rieckpil.blog;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class UserAgentClientFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("User-Agent", "MP-Service-XYZ");
    }
}
