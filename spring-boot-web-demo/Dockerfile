FROM java:8

MAINTAINER Wilson

#这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /spring-boot-web-demo
RUN mkdir /app
WORKDIR /app

#复制target/spring-boot-web-demo.jar到容器里WORKDIR下
COPY target/spring-boot-web-demo.jar  spring-boot-web-demo.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","spring-boot-demo.jar"]
