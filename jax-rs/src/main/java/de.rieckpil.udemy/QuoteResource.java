package de.rieckpil.udemy;

import javax.annotation.PostConstruct;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;

@Path("quotes")
public class QuoteResource {

    private WebTarget quotesApiTarget;

    @PostConstruct
    public void initClient() {

        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        clientBuilder.connectTimeout(5, TimeUnit.SECONDS);
        clientBuilder.readTimeout(5, TimeUnit.SECONDS);
        clientBuilder.register(UserAgentClientFilter.class);
        clientBuilder.register(ClientLoggingResponseFilter.class);
        Client client = clientBuilder.build();

        this.quotesApiTarget = client.target("https://quotes.rest").path("qod");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getQuote() {

        JsonObject quoteApiResult = this.quotesApiTarget
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(JsonObject.class);

        String quote = quoteApiResult
                .get("contents").asJsonObject()
                .get("quotes").asJsonArray().get(0).asJsonObject()
                .get("quote").toString();

        return Response.ok(quote).build();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response createQuote(String text) {
        System.out.println(text);
        return Response.created(null).build();
    }
}
