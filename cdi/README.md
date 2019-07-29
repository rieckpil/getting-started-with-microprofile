# CDI (Context and Dependency Injection)

* [GitHub](https://github.com/eclipse-ee4j/cdi)
* [Spec homepage](http://www.cdi-spec.org/)

Show the following:

# Basic dependecy injection: 

* @RequestScope, @SessionScope, @ApplicationScope, @ConversationScope
* With @Produces more dynmaic approach for creating beans -> logging example

# Using qualifiers to specify the injected bean

* Every Java Bean has the @Dependent pseudo scope (created and destroyed when requested) and the @Default qualifier
* With @Qualifier or @Any you can specify a concrete bean

#Interceptors

* Interceptors are a powerful way to capture and separate concerns which are orthogonal to the application (and type system). Any interceptor is able to intercept invocations of any Java type. This makes them perfect for solving technical concerns such as transaction management, security and call logging. However, by nature, interceptors are unaware of the actual semantics of the events they intercept. Thus, interceptors aren’t an appropriate tool for separating business-related concerns.
* three kind of interception points: business method interception, lifecycle callback interception (constructor, postconstruct...), timout method interception (only EJB)

# Decorators

* The reverse is true of decorators. A decorator intercepts invocations only for a certain Java interface, and is therefore aware of all the semantics attached to that interface. Since decorators directly implement operations with business semantics, it makes them the perfect tool for modeling some kinds of business concerns. It also means that a decorator doesn’t have the generality of an interceptor.

# Events

* Events go one step further, allowing beans to interact with no compile time dependency at all. Event producers raise events that are delivered to event observers by the container.
* An event may be assigned qualifiers, which allows observers to distinguish it from other events of the same type. The qualifiers function like topic selectors, allowing an observer to narrow the set of events it observes.
