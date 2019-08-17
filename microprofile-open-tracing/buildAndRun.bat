@echo off
call mvn clean package
call docker build -t de.rieckpil.blog/microprofile-open-tracing .
call docker rm -f microprofile-open-tracing
call docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-open-tracing de.rieckpil.blog/microprofile-open-tracing
call docker logs -f microprofile-open-tracing