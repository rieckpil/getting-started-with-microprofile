@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/microprofile-metrics .
call docker rm -f microprofile-metrics
call docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-metrics de.rieckpil.udemy/microprofile-metrics
call docker logs -f  microprofile-metrics