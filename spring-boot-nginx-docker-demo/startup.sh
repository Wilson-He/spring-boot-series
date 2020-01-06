#!/bin/bash
BUILD_ID=DONTKILLME
cd /var/lib/jenkins/workspace/docker-spring-boot/spring-boot-nginx-docker-demo
mvn clean package
if [ -e "./volume/docker-spring-boot.jar" ]
  then rm -f ./volume/docker-spring-boot.jar \
        && cp ./target/docker-spring-boot.jar ./volume/docker-spring-boot.jar \
        && docker stop docker-spring-boot \
        && echo "update jar success"
  else mkdir volume \
        && cp ./target/docker-spring-boot.jar ./volume/docker-spring-boot.jar \
        && echo "first start"
fi
docker-compose -p docker-spring-boot up -d