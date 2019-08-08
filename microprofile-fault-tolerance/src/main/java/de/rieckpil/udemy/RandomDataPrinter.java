package de.rieckpil.udemy;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class RandomDataPrinter {

    @Inject
    private RandomDataProvider randomDataProvider;

    public void initialize(@Observes @Initialized(ApplicationScoped.class) Object init) throws InterruptedException {

        randomDataProvider
                .getAllPosts()
                .stream()
                .limit(5)
                .forEach(jsonValue -> System.out.println(jsonValue.toString()));

//         System.out.println("--- single post");
//
//         System.out.println(randomDataProvider.getPostById(1L));

//        System.out.println(randomDataProvider.accessFlakyService());

//         System.out.println(randomDataProvider.getDataFromLongRunningTask());

//        for (int i = 0; i < 20; i++) {
//            System.out.println(randomDataProvider.getRandomData());
//            Thread.sleep(500);
//        }

//        for (int i = 0; i < 10; i++) {
//            final String threadName = "Thread" + i;
//            new Thread(() -> randomDataProvider.getConcurrentServiceData(threadName)).start();
//            System.out.println(threadName + " started");
//        }
    }
}
