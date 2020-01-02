FROM java:8

MAINTAINER Wilson

#这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /docker-spring-boot
RUN mkdir /app
WORKDIR /app


#复制target/spring-boot-web-demo.jar到容器里WORKDIR下
COPY target/docker-spring-boot.jar  docker-spring-boot.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","ecs-application.jar"]

# docker build -t ecs-application/latest .

