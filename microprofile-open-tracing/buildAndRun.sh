#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/microprofile-config .
docker rm -f microprofile-config || true && docker run -d -p 8080:8080 -p 4848:4848 --name microprofile-config de.rieckpil.udemy/microprofile-config