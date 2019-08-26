package de.rieckpil.blog;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.TimeUnit;

@RequestScoped
public class PriceCalculator {

    private WebTarget bookStorePriceTarget;
    private Double discount = 1.5;

    @PostConstruct
    public void setUp() {
        Client client = ClientBuilder
                .newBuilder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();

        this.bookStorePriceTarget = client.target("http://book-store:9080/resources/prices");
    }

    public Double getPriceForBook(int id) {
        Double bookPrice = this.bookStorePriceTarget.path(String.valueOf(id)).request().get().readEntity(Double.class);
        return Math.round((bookPrice - discount) * 100.0) / 100.0;
    }

}
