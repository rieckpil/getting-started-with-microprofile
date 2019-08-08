#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/microprofile-fault-tolernace .
docker rm -f microprofile-fault-tolernace || true && docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-fault-tolernace de.rieckpil.udemy/microprofile-fault-tolernace