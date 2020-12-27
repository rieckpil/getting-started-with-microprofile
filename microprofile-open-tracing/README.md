# MicroProfile OpenTracing

* [GitHub](https://github.com/eclipse/microprofile-opentracing)
* [Spec](https://download.eclipse.org/microprofile/microprofile-opentracing-2.0/microprofile-opentracing-spec-2.0.html#_release_2_0)
* Current version: **2.0** in **MicroProfile 4.0**
* Detailed blog post about this specification: [#WHATIS?: MicroProfile OpenTracing](https://rieckpil.de/whatis-eclipse-microprofile-opentracing/)
* YouTube video about this specification: [Getting started with Eclipse MicroProfile 3.0 - MicroProfile OpenTracing 1.3](https://www.youtube.com/watch?v=b43XgElBxEo)

## Steps to run this example

1. Ensure your Docker daemon is running (required Docker engine: 18.02.0+)
2. Execute either `buildAndRun.bat` (Windows) or `./buildAndRun.sh` (Linux & Mac) to build both projects and start the everything with `docker-compose`
3. Wait until everything is up and running
4. Visit http://localhost:9080/resources/books in your browser (response takes up to 1 - 3 seconds)
5. Visit http://localhost:9411/zipkin/ in your browser and search for available traces
