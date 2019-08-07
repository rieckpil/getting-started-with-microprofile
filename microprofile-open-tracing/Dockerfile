FROM open-liberty:kernel-java11
COPY --chown=1001:0  target/microprofile-open-tracing.war /config/dropins/
COPY --chown=1001:0  server.xml /config/
COPY --chown=1001:0  extension /opt/ol/wlp/usr/extension
