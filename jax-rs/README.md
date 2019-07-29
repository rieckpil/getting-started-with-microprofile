# JAX-RS: Java API for RESTful Web Services (JAX-RS) 

* [GitHub](https://github.com/eclipse-ee4j/jaxrs-api)
* [Spec homepage](https://projects.eclipse.org/projects/ee4j.jaxrs)

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