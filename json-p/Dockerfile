FROM openliberty/open-liberty:20.0.0.5-kernel-java11-openj9-ubi

COPY --chown=1001:0  target/json-p.war /config/dropins/
COPY --chown=1001:0  target/server.xml /config

RUN configure.sh
