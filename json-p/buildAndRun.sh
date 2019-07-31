#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/json-p .
docker rm -f json-p || true && docker run -d -p 8080:8080 -p 4848:4848 --name json-p de.rieckpil.udemy/json-p