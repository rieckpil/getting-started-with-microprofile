package de.rieckpil.udemy;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.RequestScoped;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RequestScoped
public class DataProvider {

    @Counted
    public DataProvider() {
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
