package de.rieckpil.udemy;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class ReadingJson {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        readFromString();
        readFromFile();
    }

    private void readFromString() {
        JsonReader jsonReader = Json.createReader(
                new StringReader("{\"name\":\"duke\",\"age\":42,\"skills\":[\"Java SE\", \"Java EE\"]}"));
        JsonObject jsonObject = jsonReader.readObject();
        System.out.println(jsonObject);
    }

    private void readFromFile() {
        JsonReader jsonReader = Json.createReader(this.getClass().getClassLoader()
                .getResourceAsStream("books.json"));
        JsonArray jsonArray = jsonReader.readArray();
        System.out.println(jsonArray);
    }
}
