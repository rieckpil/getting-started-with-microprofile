#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/microprofile-open-api .
docker rm -f microprofile-open-api || true && docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-open-api de.rieckpil.blog/microprofile-open-api && docker logs -f microprofile-open-api