package de.rieckpil.blog;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Principal;

@Path("books")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    private Principal principal;

    @Inject
    private JsonWebToken jsonWebToken;

    @Inject
    @Claim("administrator_id")
    private JsonNumber administrator_id;

    @GET
    @RolesAllowed("admin")
    public Response getBook() {

        System.out.println("Secret book for " + principal.getName() + " with roles " + jsonWebToken.getGroups());
        System.out.println("Administrator level: " + jsonWebToken.getClaim("administrator_level").toString());
        System.out.println("Administrator id: " + administrator_id);

        JsonObject secretBook = Json.createObjectBuilder()
                .add("title", "secret")
                .add("author", "duke")
                .build();

        return Response.ok(secretBook).build();
    }

}
