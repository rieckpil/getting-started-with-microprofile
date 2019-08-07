#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/microprofile-metrics .
docker rm -f microprofile-metrics || true && docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-metrics de.rieckpil.udemy/microprofile-metrics