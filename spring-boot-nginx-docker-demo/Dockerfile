FROM java:8

MAINTAINER Wilson

VOLUME /docker-spring-boot

WORKDIR /app
ADD target/docker-spring-boot.jar  docker-spring-boot.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]