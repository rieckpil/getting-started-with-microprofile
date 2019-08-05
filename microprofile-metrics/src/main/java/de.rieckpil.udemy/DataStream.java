package de.rieckpil.udemy;

import org.eclipse.microprofile.metrics.annotation.Gauge;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class DataStream {

    @Gauge(unit = "Twitter feeds per second")
    public Long getTwitterFeedsPerSecond() {
        return ThreadLocalRandom.current().nextLong(0, 1_000_000);
    }

    public String getTwitterFeed() {
        return "Hello Duke";
    }
}
