#!/bin/bash
hasImage=$(docker images|grep nginx|wc -l)
if [ $hasImage == 0 ];
   then docker pull nginx && mkdir -p /var/lib/docker/volumes/nginx-spring-boot
fi
hasContainer=$(docker images|grep nginx-spring-boot|wc -l)
if [ $hasContainer == 1 ];
    then exit
fi;

docker run --rm  -h docker-spring-boot -d \
     -p 8080:8080 \
     -v /var/run/docker.sock:/var/run/docker.sock \
     -v /etc/localtime:/etc/localtime:ro \
     -v docker-spring-boot:/app \
     -e TZ="Asia/Shanghai" \
     --name docker-spring-boot docker-spring-boot/latest

# 单SpringBoot容器
docker run  -d -h  nginx-spring-boot -p 80:80 \
        -v /etc/localtime:/etc/localtime \
        -v nginx-spring-boot:/etc/nginx/ \
        --link docker-spring-boot --name nginx-spring-boot  nginx
