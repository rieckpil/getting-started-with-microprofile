@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/json-b .
call docker rm -f json-b
call docker run -d -p 9080:9080 -p 9443:9443 --name json-b de.rieckpil.udemy/json-b