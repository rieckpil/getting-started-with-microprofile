package de.rieckpil.blog;

import javax.annotation.security.PermitAll;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResources {

    @GET
    @PermitAll
    public Response getOrder() {
        JsonObject order = Json.createObjectBuilder()
                .add("amount", 42)
                .add("product", "bike")
                .build();

        return Response.ok(order).build();
    }
}
