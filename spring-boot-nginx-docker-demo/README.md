项目搭建流程
1. 确保已安装配置好maven、java、git、Docker
2. 创建Jenkins项目并配置执行脚本(集群配置则使用bak后缀的文件)

       cd /var/lib/jenkins/workspace/docker-spring-boot/spring-boot-nginx-docker-demo
       mvn clean package
       if [ -e "./volumes/app/docker-spring-boot.jar" ]
         then rm -f ./volumes/app/docker-spring-boot.jar \
               && cp ./target/docker-spring-boot.jar ./volumes/app/docker-spring-boot.jar \
       		&& docker restart docker-spring-boot \
               && echo "update restart success"
         else mkdir volumes/app -p \
               && cp ./target/docker-spring-boot.jar ./volumes/app/docker-spring-boot.jar \
       		&& docker-compose -p docker-spring-boot up -d \
               && echo "first start"
       fi
3. 构建项目
