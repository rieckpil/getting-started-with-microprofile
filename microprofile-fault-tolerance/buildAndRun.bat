@echo off
call mvn clean package
call docker build -t de.rieckpil.blog/microprofile-fault-tolerance .
call docker rm -f microprofile-fault-tolerance
call docker run -d -p 9080:9080 -p 9443:9443 --name microprofile-fault-tolerance de.rieckpil.blog/microprofile-fault-tolerance