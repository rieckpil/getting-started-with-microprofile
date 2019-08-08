# MicroProfile Fault Tolerance

* [GitHub](https://github.com/eclipse/microprofile-fault-tolerance)
* [Spec](https://github.com/eclipse/microprofile-fault-tolerance/releases/download/2.0/microprofile-fault-tolerance-spec-2.0.pdf)
* Current version: **2.0** in MicroProfile **3.0** 

Show the following:

- Timeout: Define a duration for timeout
- Retry: Define a criteria on when to retry
- Fallback: provide an alternative solution for a failed execution.
- CircuitBreaker: offer a way of fail fast by automatically failing execution to prevent the system
overloading and indefinite wait or timeout by the clients.
- Bulkhead: isolate failures in part of the system while the rest part of the system can still function
- Because of this requirement, when Microprofile Fault Tolerance and Microprofile Metrics are used
  together, metrics are automatically added for each of the methods annotated with a @Retry,
  @Timeout, @CircuitBreaker, @Bulkhead or @Fallback annotation.
  
  
  https://openliberty.io/guides/bulkhead.html
  https://openliberty.io/guides/circuit-breaker.html