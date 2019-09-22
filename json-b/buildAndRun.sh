#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/json-b .
docker rm -f json-b || true && docker run -d -p 9080:9080 -p 9443:9443 --name json-b de.rieckpil.blog/json-b