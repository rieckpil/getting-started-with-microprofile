#!/bin/sh
mvn clean package && docker build -t de.rieckpil.blog/jax-rs .
docker rm -f jax-rs || true && docker run -d -p 9080:9080 -p 9443:9443 --name jax-rs de.rieckpil.blog/jax-rs