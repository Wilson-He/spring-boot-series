FROM java:8

MAINTAINER Wilson

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#复制target/spring-boot-web-demo.jar到容器根目录下
COPY target/docker-spring-boot.jar  docker-spring-boot.jar
RUN mkdir app && cp docker-spring-boot.jar app
EXPOSE 8080

ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]
# docker build -t docker-spring-boot/latest .

