@echo off
call mvn clean package
call docker build -t de.rieckpil.blog/microprofile-open-api .
call docker rm -f microprofile-open-api
call docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-open-api de.rieckpil.blog/microprofile-open-api
call docker logs -f microprofile-open-api