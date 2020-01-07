#!/usr/bin
BUILD_ID=DONTKILLME
cd /var/lib/jenkins/workspace/docker-spring-boot/spring-boot-nginx-docker-demo
mvn clean package
if [ -e "./volumes/app/docker-spring-boot.jar" ]
  then rm -f ./volumes/app/docker-spring-boot.jar \
        && cp ./target/docker-spring-boot.jar ./volumes/app/docker-spring-boot.jar \
		&& docker-compose -p docker-spring-boot up -d \
		&& docker restart docker-spring-boot \
		&& docker restart docker-spring-boot-bak \
		&& docker restart docker-nginx \
        && echo "update restart success"
  else mkdir volumes/app -p \
        && cp ./target/docker-spring-boot.jar ./volumes/app/docker-spring-boot.jar \
		&& docker-compose -p docker-spring-boot up -d \
        && echo "first start"
fi