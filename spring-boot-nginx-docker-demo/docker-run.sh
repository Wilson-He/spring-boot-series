#!/bin/bash

# docker-spring-boot
docker run --rm -h docker-spring-boot -d \
     -p 8080:8080 \
     -v /etc/localtime:/etc/localtime:ro\
     -v /var/run/docker.sock:/var/run/docker.sock \
     --name docker-spring-boot docker-spring-boot/latest
     
docker run --rm  -h docker-spring-boot -d -p 8080:8080 \
     -v docker-spring-boot:/app \
    --name docker-spring-boot docker-spring-boot/latest

# docker-spring-boot
docker run -d \
     -p 8080:8080 \
     --name docker-spring-boot docker-spring-boot/latest

# docker-spring-boot-2
docker run --rm  -h docker-spring-boot-2 -d \
     -p 8080:8080 \
     -v /etc/timezone:/etc/timezone:ro \
     -v docker-spring-boot-docker-2:/app \
     --name docker-spring-boot-2 docker-spring-boot/latest

# Nginx单SpringBoot
docker run -d -h docker-nginx -p 80:80 \
        -v /etc/localtime:/etc/localtime \
        -v docker-nginx:/etc/nginx/ \
        --link docker-spring-boot\
        --name docker-nginx  nginx

# Nginx双SpringBoot容器负载均衡
docker run --rm -d -h  ecs-nginx -p 80:80 \
        -v /etc/localtime:/etc/localtime \
        -v nginx:/etc/nginx/ \
        --link docker-spring-boot --link docker-spring-boot-2 \
        --name ecs-nginx  nginx


