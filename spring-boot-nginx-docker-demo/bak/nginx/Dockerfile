FROM nginx:stable

MAINTAINER Wilson

EXPOSE 80
VOLUME /docker-nginx
WORKDIR /etc/nginx
ADD nginx /etc
ENTRYPOINT ["nginx","-g","daemon off"]