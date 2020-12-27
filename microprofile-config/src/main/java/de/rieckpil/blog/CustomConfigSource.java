package de.rieckpil.blog;

import java.util.Set;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;

//config sources per default: System properties (ordinal=400)
//config sources per default: Environment variables (ordinal=300)
//config source to search in META-INF/microprofile-config.properties (ordinal=100)
public class CustomConfigSource implements ConfigSource {

  public static final String CUSTOM_PASSWORD = "CUSTOM_PASSWORD";
  public static final String MESSAGE = "Hello from custom ConfigSource";

  @Override
  public int getOrdinal() {
    return 500;
  }

  @Override
  public Map<String, String> getProperties() {
    Map<String, String> properties = new HashMap<>();
    properties.put("my.app.password", CUSTOM_PASSWORD);
    properties.put("message", MESSAGE);
    return properties;
  }

  @Override
  public Set<String> getPropertyNames() {
    return getProperties().keySet();
  }

  @Override
  public String getValue(String key) {
    if (key.equalsIgnoreCase("my.app.password")) {
      return CUSTOM_PASSWORD;
    } else if (key.equalsIgnoreCase("message")) {
      return MESSAGE;
    }
    return null;
  }

  @Override
  public String getName() {
    return "randomConfigSource";
  }
}
