@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/microprofile-config .
call docker rm -f microprofile-config
call docker run -d -p 8080:8080 -p 4848:4848 --name microprofile-config de.rieckpil.udemy/microprofile-config