package de.rieckpil.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WritingJson {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) throws IOException {
        JsonObject json = Json.createObjectBuilder()
                .add("name", "Duke")
                .add("age", 42)
                .add("skills",
                        Json.createArrayBuilder()
                                .add("Java SE")
                                .add("Java EE").
                                build())
                .add("address",
                        Json.createObjectBuilder()
                                .add("street", "Mainstreet")
                                .add("city", "Jakarta")
                                .build())
                .build();

        JsonArray jsonArray = Json.createArrayBuilder()
                .add("foo")
                .add("bar")
                .add("duke")
                .build();

        System.out.println(json);
        prettyPrintJsonToConsole(json);
        prettyPrintJsonToFile(json);
    }

    private void prettyPrintJsonToConsole(JsonObject json) throws IOException {
        Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory writerFactory = Json.createWriterFactory(config);
        try (Writer stringWriter = new StringWriter();
             JsonWriter jsonWriter = writerFactory.createWriter(stringWriter)) {
            jsonWriter.write(json);
            System.out.println(stringWriter);
        }
    }

    private void prettyPrintJsonToFile(JsonObject json) throws IOException {
        Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory writerFactory = Json.createWriterFactory(config);
        try (OutputStream outputStream = new FileOutputStream(new File("/tmp/output.json"));
             JsonWriter jsonWriter = writerFactory.createWriter(outputStream)) {
            jsonWriter.write(json);
        }
    }
}
