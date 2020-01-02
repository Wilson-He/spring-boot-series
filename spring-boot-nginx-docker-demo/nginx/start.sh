BUILD_ID=DONTKILLME
pid=$(ps -aux|grep docker-spring-boot | grep -v grep| gawk '{print $2}')
if [ ${#pid} != 0 ]
    then kill -9 $pid
fi
cd /var/lib/jenkins/workspace/docker-spring-boot/spring-boot-nginx-docker-demo
mvn clean package
docker build -t docker-spring-boot/latest .
# 判断镜像是否已存在，不存在则根据当前目录下的Dockerfile构建镜像
hasContainer=$(docker ps|grep docker-spring-boot | wc -l)
if [ $hasExcuteContainer != 0 ];
   then docker stop docker-spring-boot
fi
hasContainer=$(docker ps -a|grep docker-spring-boot | wc -l)
if [ $hasContainer != 0 ];
   then docker rm docker-spring-boot
fi
docker run -h docker-spring-boot -d \
         -v /etc/localtime:/etc/localtime:ro \
         -v docker-spring-boot:/app \
         --name docker-spring-boot docker-spring-boot/latest

   #      -e LC_ALL="en_US.UTF-8" -e TZ="Asia/Shanghai" \


