#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/microprofile-rest-client .
docker rm -f microprofile-rest-client || true && docker run -d -p 8080:8080 -p 4848:4848 --name microprofile-rest-client de.rieckpil.udemy/microprofile-rest-client