#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/json-p .
docker rm -f json-p || true && docker run -d -p 9080:9080 -p 9443:9443 --name json-p de.rieckpil.blog/json-p