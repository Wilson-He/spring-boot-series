FROM java:8

MAINTAINER Wilson

# 统一容器与服务器时间
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#复制当前项目target/spring-boot-demo.jar到容器中
COPY ./target/spring-boot-demo.jar spring-boot-demo.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","spring-boot-demo.jar"]