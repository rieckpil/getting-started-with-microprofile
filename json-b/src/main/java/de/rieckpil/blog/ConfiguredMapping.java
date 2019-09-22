package de.rieckpil.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.json.bind.config.PropertyOrderStrategy;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

@ApplicationScoped
public class ConfiguredMapping {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

        Book book = new Book("Java 11", LocalDate.now(), 1, false, null, new BigDecimal(50.50));

        JsonbConfig config = new JsonbConfig()
                .withNullValues(false)
                .withFormatting(true)
                .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL)
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_UNDERSCORES)
                .withDateFormat("dd-MM-YYYY", Locale.GERMAN);

        Jsonb jsonb = JsonbBuilder.create(config);

        String jsonString = jsonb.toJson(book);
        System.out.println(jsonString);
    }
}
