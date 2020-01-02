项目搭建流程
1. 确保已安装配置好maven、java、git、Docker
2. 创建该项目挂载卷目录保存容器文件(/var/lib/docker/volumes/docker-spring-boot/_data)，如果使用默认随机命名则可不创建
3. 创建Jenkins项目并配置执行脚本

       BUILD_ID=DONTKILLME
       cd /var/lib/jenkins/workspace/docker-spring-boot/spring-boot-nginx-docker-demo
       mvn clean package
       # 不存在镜像则构建镜像
       hasImage=$(docker images|grep docker-spring-boot| wc -l)
       if [ $hasImage == 0 ];
         then docker build -t docker-spring-boot/latest .
       fi
       # 停止删除容器
       hasContainer=$(docker ps|grep docker-spring-boot | wc -l)
       if [ $hasContainer != 0 ];
          then docker stop docker-spring-boot
       fi
       hasContainer=$(docker ps -a|grep docker-spring-boot | wc -l)
       if [ $hasContainer != 0 ];
          then docker rm docker-spring-boot
       fi
       docker run -h docker-spring-boot -d \
                # 设置容器与主机时间同步
                -v /etc/localtime:/etc/localtime:ro \
                # 设置容器与主机时间同步
                -e LC_ALL="en_US.UTF-8" -e TZ="Asia/Shanghai" \
                # 将容器中的工作目录内容同步到/var/lib/docker/volumes/docker-spring-boot/_data中，如不配置使用默认随机生成目录名可省略该配置与第二步
                -v docker-spring-boot:/app \
                --name docker-spring-boot docker-spring-boot/latest
4. 构建项目
