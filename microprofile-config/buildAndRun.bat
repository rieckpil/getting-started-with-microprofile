@echo off
call mvn clean package
call docker build -t de.rieckpil.blog/microprofile-config .
call docker rm -f microprofile-config
call docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-config de.rieckpil.blog/microprofile-config