@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/json-p .
call docker rm -f json-p
call docker run -d -p 8080:8080 -p 4848:4848 --name json-p de.rieckpil.udemy/json-p