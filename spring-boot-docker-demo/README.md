# [项目部署流程](https://mp.csdn.net/postedit/103873995)

---

## Docker远程连接配置
  - 修改Docker配置：<code>vi /lib/systemd/system/docker.service</code>
  注释原有ExecStart行再添加ExceStart：
  	```
  	ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock --containerd=/run/containerd/containerd.sock
  	```
  - 重启Docker并校验
    ```
    systemctl daemon-reload
    systemctl restart docker
    curl 127.0.0.1:2375/info
    ```
## Intellij IDEA配置
-  **配置Docker连接**
   ![plugin config](https://img-blog.csdnimg.cn/20200107143821577.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3oyODEyNjMwOA==,size_16,color_FFFFFF,t_70)
- **配置插件运行参数**
   ![plugin params](https://img-blog.csdnimg.cn/2020010714462784.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3oyODEyNjMwOA==,size_16,color_FFFFFF,t_70)
- **插件运行前项目打包**
    <code>mvn package</code>
- **运行插件**
   ![run plugin](https://img-blog.csdnimg.cn/20200107145042575.png)    