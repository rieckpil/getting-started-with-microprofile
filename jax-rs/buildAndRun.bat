@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/jax-rs .
call docker rm -f jax-rs
call docker run -d -p 8080:8080 -p 4848:4848 --name jax-rs de.rieckpil.udemy/jax-rs