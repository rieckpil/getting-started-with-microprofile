#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/microprofile-metrics .
docker rm -f microprofile-metrics || true && docker run -d -p 8080:8080 -p 4848:4848 --name microprofile-metrics de.rieckpil.udemy/microprofile-metrics