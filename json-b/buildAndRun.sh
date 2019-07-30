#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/json-b .
docker rm -f json-b || true && docker run -d -p 8080:8080 -p 4848:4848 --name json-b de.rieckpil.udemy/json-b