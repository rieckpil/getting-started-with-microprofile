#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/microprofile-jwt-auth .
docker rm -f microprofile-jwt-auth || true && docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-jwt-auth de.rieckpil.blog/microprofile-jwt-auth