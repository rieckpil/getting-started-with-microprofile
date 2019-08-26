@echo off
call mvn clean -f book-store/pom.xml package
call mvn clean -f book-store-client/pom.xml package
call docker-compose build
call docker-compose up --force-recreate