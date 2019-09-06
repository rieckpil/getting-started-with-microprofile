#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/microprofile-fault-tolerance .
docker rm -f microprofile-fault-tolerance || true && docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-fault-tolerance de.rieckpil.blog/microprofile-fault-tolerance