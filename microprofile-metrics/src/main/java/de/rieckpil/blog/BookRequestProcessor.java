package de.rieckpil.blog;

import org.eclipse.microprofile.metrics.annotation.Gauge;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class DataStream {

    @Gauge(unit = "Remaining book requests to process")
    public Long remainingBookRequestsToProcess() {
        return ThreadLocalRandom.current().nextLong(0, 1_000_000);
    }

    public String getTwitterFeed() {
        return "Hello Duke";
    }
}
