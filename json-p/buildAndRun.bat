@echo off
call mvn clean package
call docker build -t de.rieckpil.blog/json-p .
call docker rm -f json-p
call docker run -d -p 9080:9080 -p 9443:9443 --name json-p de.rieckpil.blog/json-p