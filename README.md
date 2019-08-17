# Getting started with Eclipse MicroProfile 3.0 

Repository for the YouTube series *Getting started with Eclipse MicroProfile 3.0*

![](https://rieckpil.de/wp-content/uploads/2019/08/eclipseMicroProfileGettingStartedYouTubeSeriesLogo.png "Series Logo")

## Specifications:

* **CDI**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/cdi)
* **JAX-RS**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/jax-rs)
* **JSON-B**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/json-b)
* **JSON-P**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/json-p)
* **MicroProfile Config**: [YouTube Video]() - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-config/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-config)
* **MicroProfile Fault Tolerance**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-fault-tolerance)
* **MicroProfile Metrics**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-metrics)
* **MicroProfile JWT Auth**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-jwt-auth)
* **MicroProfile Rest Client**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-rest-client)
* **MicroProfile OpenAPI**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-open-api)
* **MicroProfile OpenTracing**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-open-tracing)
* **MicroProfile Health Check**: [YouTube Video]() - [Blog post]() - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-health)

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

The following `server.xml` configuration is used:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<server description="new server">

    <featureManager>
        <feature>microProfile-3.0</feature>
    </featureManager>
    
    <mpMetrics authentication="false"/>

    <quickStartSecurity userName="admin" userPassword="admin" />

    <httpEndpoint id="defaultHttpEndpoint" httpPort="9080" httpsPort="9443" />

    <applicationManager autoExpand="true" />
    <applicationMonitor updateTrigger="mbean" />
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
		<maven.compiler.source>11</maven.compiler.source>
		<maven.compiler.target>11</maven.compiler.target>
		<failOnMissingWebXml>false</failOnMissingWebXml>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
	</properties>
</project>
```
