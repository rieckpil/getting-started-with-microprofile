#!/bin/sh
mvn clean -f book-store/pom.xml package && mvn clean -f book-store-client/pom.xml package
docker-compose build && docker-compose up --force-recreate