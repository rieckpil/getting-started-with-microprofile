# MicroProfile Health Check

* [GitHub](https://github.com/eclipse/microprofile-health)
* [Spec](https://github.com/eclipse/microprofile-health/releases/download/2.0.1/microprofile-health-spec.pdf)
* Current version: **2.0.1** in **MicroProfile 3.0**

Show the following:

- In an application, there can be zero or more procedures bound to a given health endpoint. The
  overall application health for a given endpoint is the logical AND of all of the procedures bound to
  it.
- @Liveness and @Readiness on the same check