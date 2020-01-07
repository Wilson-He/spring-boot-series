FROM java:8

MAINTAINER Wilson

# 统一容器与服务器时间
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#复制target/docker-spring-boot.jar到容器app目录下
COPY ./target/docker-spring-boot.jar app/docker-spring-boot.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","app/docker-spring-boot.jar"]
# docker build -t docker-spring-boot/latest .