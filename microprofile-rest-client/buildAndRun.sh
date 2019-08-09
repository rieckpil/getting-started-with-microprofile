#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/microprofile-rest-client .
docker rm -f microprofile-rest-client || true && docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-rest-client de.rieckpil.udemy/microprofile-rest-client