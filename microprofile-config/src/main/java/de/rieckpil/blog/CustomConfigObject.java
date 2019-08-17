package de.rieckpil.blog;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

public class CustomConfigObject {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        Config config = ConfigProviderResolver
                .instance()
                .getBuilder()
                .addDefaultSources()
                .withSources(new CustomConfigSource())
                .addDiscoveredConverters()
                .build();

        System.out.println("Customized config: " + config.getValue("message", String.class));
    }
}
