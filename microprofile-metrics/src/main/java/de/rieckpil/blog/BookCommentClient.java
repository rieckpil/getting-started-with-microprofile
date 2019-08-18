package de.rieckpil.blog;

import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.RegistryType;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class BookCommentClient {

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    private MetricRegistry metricRegistry;

    private WebTarget bookCommentsWebTarget;

    @Counted(name = "bookCommentClientInvocations", description = "Counting the invocations of the constructor")
    public BookCommentClient() {
    }

    @PostConstruct
    public void setUp() {
        Client client = ClientBuilder
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        this.bookCommentsWebTarget = client.target("https://jsonplaceholder.typicode.com/comments");
    }

    @Timed(name = "getBookCommentByBookIdDuration")
    public String getBookCommentByBookId(String bookId) {
        this.sleepRandom();

        Response response = this.bookCommentsWebTarget.path(bookId).request().get();

        this.metricRegistry.counter("bookCommentApiResponseCode" + response.getStatus()).inc();

        return response.readEntity(JsonObject.class).getString("body");
    }

    private void sleepRandom() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
