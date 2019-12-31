FROM java:8

MAINTAINER Wilson

VOLUME /docker-spring-boot
EXPOSE 80

ENV LC_ALL="en_US.UTF-8"
ENV TZ="Asia/Shanghai"

WORKDIR /app
ADD target/spring-boot-nginx-docker-demo.jar  spring-boot-nginx-docker-demo.jar

ENTRYPOINT ["java","-jar","spring-boot-nginx-docker-demo.jar"]