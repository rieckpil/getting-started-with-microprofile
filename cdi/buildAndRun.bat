@echo off
call mvn clean package
call docker build -t de.rieckpil.udemy/cdi .
call docker rm -f cdi
call docker run -d -p 9080:9080 -p 9443:9443 --name cdi de.rieckpil.udemy/cdi