package de.rieckpil.udemy;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Provider;
import java.util.List;
import java.util.Optional;

public class BasicConfigurationInjection {

    @Inject
    private Config config;

    @Inject
    @ConfigProperty(name = "message", defaultValue = "Hello World")
    private String message;

    @Inject
    @ConfigProperty(name = "my.app.password")
    private Optional<String> password;

    @Inject
    @ConfigProperty(name = "my.app.timeout")
    private Provider<Long> timeout;

    @Inject
    @ConfigProperty(name = "my.app.users")
    private List<String> usersList;

    @Inject
    @ConfigProperty(name = "my.app.users")
    private String[] usersArray;

    @Inject
    @ConfigProperty(name = "my.app.token")
    private Token token;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        System.out.println(config.getValue("message", String.class));
        System.out.println(message);
        System.out.println(password.orElseGet(() -> "DefaultPassword"));
        System.out.println(timeout.get());
        usersList.forEach(u -> System.out.println(u));
        System.out.println(usersArray);
        System.out.println(token);
    }

}
