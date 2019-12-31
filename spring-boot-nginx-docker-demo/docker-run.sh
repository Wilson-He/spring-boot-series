#!/bin/bash

# docker-spring-boot
docker run --rm  -h docker-spring-boot -d \
     -p 8080:8080 \
     -v /etc/localtime:/etc/localtime:ro\
     -v docker-spring-boot--docker:/app \
     --name docker-spring-boot docker-spring-boot-/latest

# docker-spring-boot-2
docker run --rm  -h docker-spring-boot-2 -d \
     -p 8080:8080 \
     - /etc/timezone:/etc/timezone:ro \
     -v /etc/localtime:/etc/localtime:ro \
     -v docker-spring-boot-docker-2:/app \
     --name docker-spring-boot-2 docker-spring-boot-/latest

docker run --rm -d -h  docker-spring-boot- -p 80:80 \
        -v /etc/localtime:/etc/localtime \
        -v nginx:/etc/nginx/ \
        --link docker-spring-boot-:docker-spring-boot- --name ecs-nginx  nginx

# Nginx双SpringBoot容器负载均衡
docker run --rm -d -h  ecs-nginx -p 80:80 \
        -v /etc/localtime:/etc/localtime \
        -v nginx:/etc/nginx/ \
        --link docker-spring-boot --link docker-spring-boot-2 --name ecs-nginx  nginx
