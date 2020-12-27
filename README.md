# Getting started with MicroProfile

[![](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/workflows/Build%20Java/badge.svg)](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/actions)

<p align="center">
  <a href="https://rieckpil.de/p/eclipse-microprofile-course-bundle">
    <img src="https://rieckpil.de/wp-content/uploads/2019/11/gettingStartedWithEclipseMicroProfileBundle-e1573245583433.png" alt=" Bundle Logo"/>
  </a>
</p>

» Repository for the Getting Started with MicroProfile [Course Bundle](https://rieckpil.de/p/eclipse-microprofile-course-bundle).

## Specifications:

* **CDI**: [YouTube Video](https://youtu.be/Q8jHRDu9Fbo) - [Blog post](https://rieckpil.de/whatis-contexts-and-dependency-injection-cdi/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/cdi)
* **JAX-RS**: [YouTube Video](https://youtu.be/-TmKXm0k7UI) - [Blog post](https://rieckpil.de/whatis-jakarta-restful-web-services-jax-rs/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/jax-rs)
* **JSON-B**: [YouTube Video](https://youtu.be/3TbbivV2Epk) - [Blog post](https://rieckpil.de/whatis-json-binding-json-b/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/json-b)
* **JSON-P**: [YouTube Video](https://youtu.be/2H7z_MbWwDQ) - [Blog post](https://rieckpil.de/whatis-json-processing-json-p/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/json-p)
* **MicroProfile Config**: [YouTube Video](https://youtu.be/0h3QceSBBiY) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-config/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-config)
* **MicroProfile Fault Tolerance**: [YouTube Video](https://www.youtube.com/watch?v=_O4EjWHF0TQ) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-fault-tolerance/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-fault-tolerance)
* **MicroProfile Metrics**: [YouTube Video](https://www.youtube.com/watch?v=jI6DoNYVd-U) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-metrics/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-metrics)
* **MicroProfile JWT Auth**: [YouTube Video](https://youtu.be/8O3D2tNx1uM) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-jwt-auth/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-jwt-auth)
* **MicroProfile Rest Client**: [YouTube Video](https://youtu.be/HJWxI_T3FKo) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-rest-client/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-rest-client)
* **MicroProfile OpenAPI**: [YouTube Video](https://www.youtube.com/watch?v=Rn7T26UW_H8) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-openapi/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-open-api)
* **MicroProfile OpenTracing**: [YouTube Video](https://www.youtube.com/watch?v=b43XgElBxEo) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-opentracing/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-open-tracing)
* **MicroProfile Health**: [YouTube Video](https://www.youtube.com/watch?v=nq_gdPUTx5c) - [Blog post](https://rieckpil.de/whatis-eclipse-microprofile-health/) - [Source code](https://github.com/rieckpil/getting-started-with-eclipse-microprofile/tree/master/microprofile-health)

## Technologies used for this series:

* **MicroProfile 4.0**
* **OpenLiberty 21.0.0.1-beta**
* **Java 11**
* **Maven 3.6**
* **WAD** (Watch and Deploy) from [Adam Bien](https://wad.sh/) ([setup](https://rieckpil.de/review-improved-java-jakarta-ee-productivity-with-adam-biens-wad-watch-and-deploy/))
* **JWTENIZR** from [Adam Bien](http://jwtenizr.sh/)

## Start the example applications

Each subfolder contains a `buildAndRun.sh` (Linux/Mac) and `buildAndRun.bat` (Windows) file to build and start the application on your machine using **Docker**. You just need **Java 11** and **Maven** installed and a running Docker daemon to start everything. Once the application is up- and running, you can visit http://localhost:9080 to access it (if any JAX-RS endpoint is available in the project).

## Open Liberty configuration

All projects use the following base `server.xml` configuration:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<server description="new server">

    <featureManager>
        <feature>microProfile-4.0</feature>
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
