package de.rieckpil.udemy;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.*;
import java.io.StringReader;

public class ModifyJson {

    private String jsonString = "{\"name\":\"duke\",\"age\":42,\"skills\":[\"Java SE\", \"Java EE\"]}";

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        jsonPatch();
        jsonMergePatch();
        jsonPointer();
    }

    // read the official spec here: https://tools.ietf.org/html/rfc6901
    private void jsonPointer() {
        JsonObject jsonObject = Json.createReader(new StringReader(jsonString)).readObject();

        JsonPointer arrayElementPointer = Json.createPointer("/skills/1");
        JsonPointer agePointer = Json.createPointer("/age");
        JsonPointer namePointer = Json.createPointer("/name");
        JsonPointer addressPointer = Json.createPointer("/address");

        System.out.println("Array pointer: " + arrayElementPointer.getValue(jsonObject).toString());
        System.out.println("Age pointer: " + agePointer.getValue(jsonObject).toString());
        System.out.println("Name pointer: " + namePointer.getValue(jsonObject).toString());
        System.out.println("Has address: " + addressPointer.containsValue(jsonObject));
    }

    // read the official spec here: https://tools.ietf.org/html/rfc7386
    private void jsonMergePatch() {
        JsonObject jsonObject = Json.createReader(new StringReader(jsonString)).readObject();

        JsonObject merge = Json.createObjectBuilder()
                .add("name", "duke2")
                .add("isEmployee", true)
                .add("skills", Json.createArrayBuilder()
                        .add("CSS")
                        .add("HTML")
                        .add("JavaScript")
                        .build())
                .build();

        JsonMergePatch mergePatch = Json.createMergePatch(merge);
        JsonValue mergedJson = mergePatch.apply(jsonObject);
        System.out.println("Merged JSON: " + mergedJson);
    }

    // read the official spec here: https://tools.ietf.org/html/rfc6902
    private void jsonPatch() {
        JsonObject jsonObject = Json.createReader(new StringReader(jsonString)).readObject();

        JsonPatch patch = Json.createPatchBuilder()
                .add("/isRetired", false)
                .add("/skills/2", "Jakarta EE")
                .remove("/age")
                .replace("/name", "duke two")
                .build();

        JsonObject patchedJson = patch.apply(jsonObject);
        System.out.println("Patched JSON: " + patchedJson);
    }
}
