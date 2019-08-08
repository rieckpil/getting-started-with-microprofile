package de.rieckpil.udemy;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class RandomDataPrinter {

    @Inject
    private RandomDataProvider randomDataProvider;

    public void initialize(@Observes @Initialized(ApplicationScoped.class) Object init) {

        randomDataProvider
                .getAllPosts()
                .stream()
                .limit(10)
                .forEach(jsonValue -> System.out.println(jsonValue.toString()));

        System.out.println("Hello world");
        System.out.println("Hello world");

        randomDataProvider.getPostById(1L);
    }

}
