# JAX-RS: Jakarta RESTful Web Services

* [GitHub](https://github.com/eclipse-ee4j/jaxrs-api)
* [Spec homepage](https://projects.eclipse.org/projects/ee4j.jaxrs)
* Current version: **2.1** in MicroProfile **3.0**
* Detailed blog post about this specification: [#WHATIS?: Jakarta RESTful Web Services (JAX-RS)](https://rieckpil.de/whatis-jakarta-restful-web-services-jax-rs/)
* YouTube video about this specification: [Getting started with Eclipse MicroProfile 3.0 - JAX-RS 2.1]()

## Request & response flow

```
                                CLIENT                                                                              SERVER
       +----------------------------------------------------------------+      +-----------------------------------------------------------------------------------+
       |                                                                |      |                                                                                   |  
       |  ClientRequestFilter -> WriterInterceptor ->  MessageBodyWriter ---------->  PreMatchingRequestFilter ->  ContainerRequestFilter ---> ReaderInterceptor   |
       |                                                                |      |                                                                      |            |
       |                                                                |      |                                                                      v            |
       |                                                                |      |                                                                MessageBodyReader  |
       |                                                                |      |                                                                      |            |
       |                                                                |      |                                                                      v            |
       |                                                                |      |                                                                 ResourceMethod    |
       |                                                                |      |                                                                      |            |
       |                                                                |      |                                                                      v            |
       |  MessageBodyReader <- ReaderInterceptor <- ClientResponseFilter <-----------  MessageBodyWriter   <---   WriterInterceptor <--- ContainerResponseFilter   |
       |                                                                |      |                                                                                   | 
       +----------------------------------------------------------------+      +-----------------------------------------------------------------------------------+
```

Show the following:

# Endpoints

- GET, PUT, POST
- PathVariable, QueryParam, RequestBody
- Accessing HttpRequestServlet, Headers
- Async Endpoints

# Content Negotiation

- Produces, Consumes
- MessageBodyReader, MessageBodyWriter (Cryo)

# Client and WebTarget

- Access external endpoints
- Reactive 

# Provider

- ContainerRequestFilter, ContainerResponseFilter
- @PreMatching
- ClientRequestFilter, ClientResponseFilter
- WriterInterceptor, ReaderInterceptor
- @NameBinding, @Priority