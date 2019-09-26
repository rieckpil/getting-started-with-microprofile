# Getting started with Eclipse MicroProfile 3.0 

[![Build Status](https://travis-ci.org/rieckpil/getting-started-with-eclipse-microprofile.svg?branch=master)](https://travis-ci.org/rieckpil/getting-started-with-eclipse-microprofile)

Repository for the [YouTube series](https://www.youtube.com/watch?v=0h3QceSBBiY&list=PLFjB4VDnlT_3vXkrLkSBW7j6ygQRXBypA) *Getting started with Eclipse MicroProfile 3.0*

[![Series logo](https://rieckpil.de/wp-content/uploads/2019/08/eclipseMicroProfileGettingStartedYouTubeSeriesLogo.png "Series Logo")](https://www.youtube.com/watch?v=0h3QceSBBiY&list=PLFjB4VDnlT_3vXkrLkSBW7j6ygQRXBypA)

## Specifications:

* **CDI**: [YouTube Video] - [Blog post] - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/cdi)
* **JAX-RS**: [YouTube Video] - [Blog post] - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/jax-rs)
* **JSON-B**: [YouTube Video] - [Blog post](https://rieckpil.de/whatis-json-processing-json-b/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/json-b)
* **JSON-P**: [YouTube Video] - [Blog post](https://rieckpil.de/whatis-json-processing-json-p/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/json-p)
* **MicroProfile Config**: [YouTube Video](https://youtu.be/0h3QceSBBiY) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-config/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-config)
* **MicroProfile Fault Tolerance**: [YouTube Video] - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-fault-tolerance/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-fault-tolerance)
* **MicroProfile Metrics**: [YouTube Video](https://www.youtube.com/watch?v=jI6DoNYVd-U) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-metrics/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-metrics)
* **MicroProfile JWT Auth**: [YouTube Video] - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-jwt-auth/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-jwt-auth)
* **MicroProfile Rest Client**: [YouTube Video] - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-rest-client/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-rest-client)
* **MicroProfile OpenAPI**: [YouTube Video](https://www.youtube.com/watch?v=Rn7T26UW_H8) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-openapi/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-open-api)
* **MicroProfile OpenTracing**: [YouTube Video] - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-opentracing/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-open-tracing)
* **MicroProfile Health**: [YouTube Video](https://www.youtube.com/watch?v=nq_gdPUTx5c) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-health/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-health)

## Technologies used for this series:

* **MicroProfile 3.0**
* **OpenLiberty 19.0.0.7**
* **Java 11**
* **Maven 3.6**
* **WAD** (Watch and Deploy) from [Adam Bien](https://wad.sh/) ([setup](https://rieckpil.de/review-improved-java-jakarta-ee-productivity-with-adam-biens-wad-watch-and-deploy/))
* **JWTENIZR** from [Adam Bien](http://jwtenizr.sh/)

## Start the example applications 

Each subfolder contains a `buildAndRun.sh` (Linux/Mac) and `buildAndRun.bat` (Windows) file to build and start the application on your machine using **Docker**. You just need **Java 11** and **Maven** installed and a running Docker daemon to start everything. Once the application is up- and running, you can visit http://localhost:9080 to access it (if any JAX-RS endpoint is available in the project).

## Open Liberty configuration

The following base `server.xml` configuration is used:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<server description="new server">

    <featureManager>
        <feature>microProfile-3.0</feature>
    </featureManager>

    <mpMetrics authentication="false"/>

    <ssl id="defaultSSLConfig" keyStoreRef="defaultKeyStore" trustStoreRef="jdkTrustStore" />
    <keyStore id="jdkTrustStore" location="${java.home}/lib/security/cacerts" password="changeit" />

    <httpEndpoint id="defaultHttpEndpoint" httpPort="9080" httpsPort="9443"/>
</server>
```

The following `ibm-web-ext.xml` is used within the project to deploy the application to the root path `/`:

```xml
<web-ext
        xmlns="http://websphere.ibm.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://websphere.ibm.com/xml/ns/javaee http://websphere.ibm.com/xml/ns/javaee/ibm-web-ext_1_0.xsd"
        version="1.0">
    <context-root uri="/"/>
</web-ext>
```

## Parent Maven project

All MicroProfile example projects use the following parent `pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>de.rieckpil.blog</groupId>
    <artifactId>microprofile-course-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <dependencies>
        <dependency>
            <groupId>org.eclipse.microprofile</groupId>
            <artifactId>microprofile</artifactId>
            <version>3.0</version>
            <type>pom</type>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <properties>
        <java.version>11</java.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.2.3</version>
		<configuration>
			<failOnMissingWebXml>false</failOnMissingWebXml>
		</configuration>
            </plugin>
        </plugins>
    </build>

</project>
```
