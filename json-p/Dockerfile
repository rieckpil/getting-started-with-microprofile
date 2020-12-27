FROM open-liberty:beta-java11

COPY --chown=1001:0  target/json-p.war /config/dropins/
COPY --chown=1001:0  target/server.xml /config

RUN configure.sh
