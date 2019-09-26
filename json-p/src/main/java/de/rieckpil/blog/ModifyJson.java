package de.rieckpil.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.json.*;
import java.io.StringReader;

public class ModifyJson {

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        jsonPatch();
        jsonMergePatch();
        jsonPointer();
    }

    // read the official spec here: https://tools.ietf.org/html/rfc6901
    private void jsonPointer() {
        String jsonString = "{\"name\":\"duke\",\"age\":42,\"skills\":[\"Java SE\", \"Java EE\"]}";

        JsonObject jsonObject = Json.createReader(new StringReader(jsonString)).readObject();

        JsonPointer arrayElementPointer = Json.createPointer("/skills/1");
        JsonPointer agePointer = Json.createPointer("/age");
        JsonPointer namePointer = Json.createPointer("/name");
        JsonPointer addressPointer = Json.createPointer("/address");
        JsonPointer tagsPointer = Json.createPointer("/tags");

        System.out.println("Get array element with pointer: " + arrayElementPointer.getValue(jsonObject).toString());
        System.out.println("Remove age with pointer: " + agePointer.remove(jsonObject));
        System.out.println("Replace name with pointer: " + namePointer.replace(jsonObject, Json.createValue("john")));
        System.out.println("Check address with pointer: " + addressPointer.containsValue(jsonObject));
        System.out.println("Add tags with pointer: " + tagsPointer.add(jsonObject, Json.createArrayBuilder().add("nice").build()));
    }

    // read the official spec here: https://tools.ietf.org/html/rfc7386
    private void jsonMergePatch() {
        String jsonString = "{\"name\":\"duke\",\"age\":42,\"skills\":[\"Java SE\", \"Java EE\"]}";

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
        String jsonString = "{\"name\":\"duke\",\"age\":42,\"skills\":[\"Java SE\", \"Java EE\"]}";

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
