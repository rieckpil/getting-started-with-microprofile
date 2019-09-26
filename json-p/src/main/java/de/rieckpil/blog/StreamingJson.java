package de.rieckpil.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.io.StringReader;
import java.io.StringWriter;

import static javax.json.stream.JsonParser.Event;

public class StreamingJson {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        parseJson();
        generateJson();
    }

    private void parseJson() {
        String jsonString = "{\"name\":\"duke\",\"isRetired\":false,\"age\":42,\"skills\":[\"Java SE\", \"Java EE\"]}";
        try (JsonParser parser = Json.createParser(new StringReader(jsonString))) {
            while (parser.hasNext()) {
                final Event event = parser.next();
                switch (event) {
                    case START_ARRAY:
                        System.out.println("Start of array");
                        break;
                    case END_ARRAY:
                        System.out.println("End of array");
                        break;
                    case KEY_NAME:
                        System.out.println("Key found " + parser.getString());
                        break;
                    case VALUE_STRING:
                        System.out.println("Value found " + parser.getString());
                        break;
                    case VALUE_NUMBER:
                        System.out.println("Number found " + parser.getLong());
                        break;
                    case VALUE_TRUE:
                        System.out.println(true);
                        break;
                    case VALUE_FALSE:
                        System.out.println(false);
                        break;
                }
            }
        }
    }

    private void generateJson() {
        StringWriter stringWriter = new StringWriter();

        try (JsonGenerator jsonGenerator = Json.createGenerator(stringWriter)) {
            jsonGenerator.writeStartArray()
                    .writeStartObject()
                    .write("name", "duke")
                    .writeEnd()
                    .writeStartObject()
                    .write("name", "jakarta")
                    .writeEnd()
                    .writeEnd();
            jsonGenerator.flush();
        }

        System.out.println(stringWriter.toString());
    }
}
