@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/microprofile-jwt-auth .
call docker rm -f microprofile-jwt-auth
call docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-jwt-auth de.rieckpil.udemy/microprofile-jwt-auth