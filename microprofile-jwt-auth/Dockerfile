FROM openliberty/open-liberty:20.0.0.5-kernel-java11-openj9-ubi

COPY --chown=1001:0  target/microprofile-jwt-auth.war /config/dropins/
COPY --chown=1001:0  target/server.xml /config

RUN configure.sh
