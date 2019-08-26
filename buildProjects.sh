#!/bin/bash
declare -a arr=(
 "cdi" 
 "jax-rs"
 "json-b"
 "json-p"
 "microprofile-config"
 "microprofile-fault-tolerance"
 "microprofile-health"
 "microprofile-jwt-auth"
 "microprofile-metrics"
 "microprofile-open-api"
 "microprofile-open-tracing/book-store"
 "microprofile-open-tracing/book-store-client"
 "microprofile-rest-client"
)

for project in "${arr[@]}"
do
   mvn -B -f $project/pom.xml package
done