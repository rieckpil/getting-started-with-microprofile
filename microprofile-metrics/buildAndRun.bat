@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/microprofile-metrics .
call docker rm -f microprofile-metrics
call docker run -d -p 8080:8080 -p 4848:4848 --name microprofile-metrics de.rieckpil.udemy/microprofile-metrics