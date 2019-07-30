@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/json-b .
call docker rm -f json-b
call docker run -d -p 8080:8080 -p 4848:4848 --name json-b de.rieckpil.udemy/json-b