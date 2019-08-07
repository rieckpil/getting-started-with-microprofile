package de.rieckpil.udemy;

import org.eclipse.microprofile.opentracing.Traced;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.TimeUnit;

@RequestScoped
public class PriceManager {

    private WebTarget webTarget;

    @PostConstruct
    public void setUp() {
        Client client = ClientBuilder
                .newBuilder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();
        this.webTarget = client.target("http://localhost:9080/resources/prices");
    }

    @Traced
    public Long providePriceForBook() {
        return this.webTarget.request().get(Long.class);
    }
}
