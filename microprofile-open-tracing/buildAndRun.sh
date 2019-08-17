#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/microprofile-open-tracing .
docker rm -f microprofile-open-tracing || true && docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-open-tracing de.rieckpil.blog/microprofile-open-tracing && docker logs -f microprofile-open-tracing