package de.rieckpil.blog;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
@LoginConfig(authMethod = "MP-JWT")
public class JAXRSConfiguration extends Application {
}
