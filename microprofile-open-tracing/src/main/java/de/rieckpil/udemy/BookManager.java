package de.rieckpil.udemy;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

@RequestScoped
public class BookManager {

    @Inject
    private PriceManager priceManager;

    @Traced
    public JsonObject getBook() throws InterruptedException {
        Thread.sleep(1000);
        return Json
                .createObjectBuilder()
                .add("title", "Java11")
                .add("author", "Duke")
                .add("price", priceManager.providePriceForBook())
                .build();
    }
}
