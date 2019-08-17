package de.rieckpil.blog;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class BookCommentClient {

    @Counted
    public BookCommentClient() {
    }

    @Counted(name = "randomStringInvocation", tags = {"spec=CDI"})
    public String getRandomString() {
        return UUID.randomUUID().toString();
    }

    @Timed
    public void sleepRandom() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
