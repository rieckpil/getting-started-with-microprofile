FROM openliberty/open-liberty:20.0.0.5-kernel-java11-openj9-ubi

COPY --chown=1001:0  target/microprofile-open-tracing-server.war /config/dropins/
COPY --chown=1001:0  server.xml /config/
COPY --chown=1001:0  extension /opt/ol/wlp/usr/extension

RUN configure.sh
