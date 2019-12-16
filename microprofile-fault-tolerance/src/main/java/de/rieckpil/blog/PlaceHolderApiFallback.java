package de.rieckpil.blog;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import javax.json.Json;
import javax.json.JsonObject;

public class PlaceHolderApiFallback implements FallbackHandler<JsonObject> {

  @Override
  public JsonObject handle(ExecutionContext context) {
    return Json.createObjectBuilder()
      .add("comment", "Lorem ipsum")
      .add("postId", Long.valueOf(context.getParameters()[0].toString()))
      .build();
  }
}
