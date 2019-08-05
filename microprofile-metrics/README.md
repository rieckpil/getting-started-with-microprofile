# MicroProfile Metrics

* [GitHub](https://github.com/eclipse/microprofile-metrics)
* [Spec](https://github.com/eclipse/microprofile-metrics/releases/download/2.0/microprofile-metrics-spec-2.0.pdf)
* Current version: **2.0** in MicroProfile **3.0**

# Types of metrics

- base: metrics that all MicroProfile vendors have to provide `/metrics/base`
- vendor: vendor specific metrics (optional)
- application: application-specific metrics (optional)

- @Timer, @Counted, @Gauge/@ConcurrentGauge, @Metered

The only exception from this are gauges (not concurrent gauges), which don’t support multiple
instances of the underlying bean to be created, because in that case it would not be clear which
instance should be used for obtaining the gauge value. For this reason, gauges should only be used
with beans that create only one instance, in CDI terms this means @ApplicationScoped and
@Singleton beans. The implementation may employ validation checks that throw an error eagerly
when it is detected that there is a @Gauge on a bean that will probably have multiple instances