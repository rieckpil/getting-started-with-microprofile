@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/microprofile-fault-tolernace .
call docker rm -f microprofile-fault-tolernace
call docker run -d -p 8080:8080 -p 4848:4848 --name microprofile-fault-tolernace de.rieckpil.udemy/microprofile-fault-tolernace