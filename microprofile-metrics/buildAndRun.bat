@echo off
call mvn clean package
call docker build -t de.rieckpil.blog/microprofile-metrics .
call docker rm -f microprofile-metrics
call docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-metrics de.rieckpil.blog/microprofile-metrics
call docker logs -f  microprofile-metrics