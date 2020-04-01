package de.rieckpil.blog;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

@ApplicationScoped
public class GlobalClientHeaders implements ClientHeadersFactory {

  @Inject
  @ConfigProperty(name = "secrets.value")
  private String secretValue;

  @Override
  public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {

    System.out.println("--- Incoming headers of the JAX-RS environment");
    incomingHeaders.forEach((k, v) -> System.out.println(k + ":" + v));

    System.out.println("--- Specified outgoing headers of the Rest Client");
    clientOutgoingHeaders.forEach((k, v) -> System.out.println(k + ":" + v));

    MultivaluedMap<String, String> resultHeader = new MultivaluedHashMap();
    resultHeader.putAll(incomingHeaders);
    resultHeader.putAll(clientOutgoingHeaders);

    resultHeader.add("X-Secret-Header", secretValue);
    resultHeader.add("X-Global-Header", "duke");
    resultHeader.add("X-Special-Header", "MicroProfile");

    System.out.println("--- Header of the Rest Client after merging");
    resultHeader.forEach((k, v) -> System.out.println(k + ":" + v));

    return resultHeader;
  }
}
