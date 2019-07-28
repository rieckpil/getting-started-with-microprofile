@echo off
call mvn clean package
call docker build -t de.rieckpil.udemymicroprofile-rest-client .
call docker rm -f microprofile-rest-client
call docker run -d -p 8080:8080 -p 4848:4848 --name mmicroprofile-rest-client de.rieckpil.udemy/microprofile-rest-client