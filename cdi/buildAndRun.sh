#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/cdi .
docker rm -f cdi || true && docker run -d -p 9080:9080 -p 9443:9443 --name cdi de.rieckpil.blog/cdi