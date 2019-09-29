@echo off
call mvn clean package
call docker build -t de.rieckpil.blog/jax-rs .
call docker rm -f jax-rs
call docker run -d -p 9080:9080 -p 9443:9443 --name jax-rs de.rieckpil.blog/jax-rs