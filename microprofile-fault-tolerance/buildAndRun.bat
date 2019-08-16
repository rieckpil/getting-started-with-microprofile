@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/microprofile-fault-tolernace .
call docker rm -f microprofile-fault-tolernace
call docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-fault-tolernace de.rieckpil.udemy/microprofile-fault-tolernace