FROM java:8

MAINTAINER Wilson

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#VOLUME /app
#复制target/spring-boot-web-demo.jar到容器根目录下
EXPOSE 8080

ENTRYPOINT ["java","-jar","app/docker-spring-boot.jar"]
# docker build -t docker-spring-boot/latest .

