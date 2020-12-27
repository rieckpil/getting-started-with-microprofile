FROM open-liberty:beta-java11

COPY --chown=1001:0  target/microprofile-fault-tolerance.war /config/dropins/
COPY --chown=1001:0  target/server.xml /config

RUN configure.sh
