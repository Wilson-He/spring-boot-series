FROM java:8

MAINTAINER Wilson

VOLUME /docker-spring-boot
EXPOSE 8080

ENV LC_ALL="en_US.UTF-8"
ENV TZ="Asia/Shanghai"

WORKDIR /app
ADD target/docker-spring-boot.jar  docker-spring-boot.jar

ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]