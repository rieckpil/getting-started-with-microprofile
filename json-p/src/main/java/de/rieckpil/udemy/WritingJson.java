package de.rieckpil.udemy;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriterFactory;
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

        System.out.println(json);
        prettyPrintJsonToConsole(json);
        prettyPrintJsonToFile(json);
    }

    private void prettyPrintJsonToConsole(JsonObject json) throws IOException {
        Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory writerFactory = Json.createWriterFactory(config);
        try(Writer writer = new StringWriter()) {
            writerFactory.createWriter(writer).write(json);
            System.out.println(writer.toString());
        }
    }

    private void prettyPrintJsonToFile(JsonObject json){
        Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory writerFactory = Json.createWriterFactory(config);
        try(Writer writer = new FileWriter("C:\\Development\\outputJson.json")) {
            writerFactory.createWriter(writer).write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
