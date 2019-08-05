package de.rieckpil.udemy;

import org.eclipse.microprofile.metrics.*;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("metrics")
public class MetricResource {

    @Inject
    private DataProvider dataProvider;

    @Inject
    private DataStream dataStream;

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    private MetricRegistry metricRegistry;

    private Counter dynamicCounter;

    @PostConstruct
    public void setUp() {
        Metadata metadata = Metadata.builder()
                .withName("dynamicCounter")
                .withDescription("Dynamic Counter")
                .withType(MetricType.COUNTER)
                .build();

        this.dynamicCounter = this.metricRegistry.counter(metadata, new Tag("foo", "bar"));
    }

    @GET
    @Metered(name = "getTextDuration", tags = {"spec=JAX-RS", "level=REST"})
    @Produces(MediaType.TEXT_PLAIN)
    public Response getText() {
        this.dynamicCounter.inc(5);
        dataProvider.sleepRandom();
        return Response.ok(dataProvider.getRandomString() + " " + dataStream.getTwitterFeed()).build();
    }
}
