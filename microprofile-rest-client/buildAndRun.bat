@echo off
call mvn clean package
call docker build -t de.rieckpil.udemymicroprofile-rest-client .
call docker rm -f microprofile-rest-client
call docker run -d -p 9080:9080 -p 9443:9443 --name mmicroprofile-rest-client de.rieckpil.udemy/microprofile-rest-client