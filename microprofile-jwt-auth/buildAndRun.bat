@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/microprofile-jwt-auth .
call docker rm -f microprofile-jwt-auth
call docker run -d -p 8080:8080 -p 4848:4848 --name microprofile-jwt-auth de.rieckpil.udemy/microprofile-jwt-auth