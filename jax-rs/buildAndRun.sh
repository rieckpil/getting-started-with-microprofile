#!/bin/sh
mvn clean package && docker build -t de.rieckpil.udemy/jax-rs .
docker rm -f jax-rs || true && docker run -d -p 8080:8080 -p 4848:4848 --name jax-rs de.rieckpil.udemy/jax-rs