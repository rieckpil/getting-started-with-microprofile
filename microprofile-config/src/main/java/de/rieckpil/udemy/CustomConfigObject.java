package de.rieckpil.udemy;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class CustomConfigObject {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        Config config = ConfigProviderResolver
                .instance()
                .getBuilder()
                .addDefaultSources()
                .addDiscoveredConverters()
                .build();

        System.out.println("Customized config: " + config.getValue("message", String.class));
    }
}
