package de.rieckpil.blog;

import org.eclipse.microprofile.metrics.annotation.Gauge;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class BookRequestProcessor {

    @Gauge(unit = "Remaining book requests to process")
    public Long remainingBookRequestsToProcess() {
        // monitor e.g. current size of a JMS queue
        return ThreadLocalRandom.current().nextLong(0, 1_000_000);
    }

    public String getLatestBookRequestId() {
        return String.valueOf(ThreadLocalRandom.current().nextLong(10));
    }
}
