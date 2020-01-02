#!/bin/bash
hasImage=$(docker images|grep nginx|wc -l)
if [ $hasImage == 0 ];
   then docker pull nginx && mkdir -p /var/lib/docker/volumes/nginx-spring-boot
fi
hasContainer=$(docker images|grep nginx-spring-boot|wc -l)
if [ $hasContainer == 1 ];
    then exit
fi;
docker run -d -h nginx-spring-boot \
    -p 80:80 \
    -v /etc/localtime:/etc/localtime:ro \
    -e LC_ALL="en_US.UTF-8" -e TZ="Asia/Shanghai" \
    -v nginx-spring-boot:/etc/nginx \
    --link docker-spring-boot \
    --name nginx-spring-boot nginx

