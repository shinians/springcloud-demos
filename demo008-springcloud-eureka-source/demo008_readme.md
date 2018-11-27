管理eureka：
1、访问 http://127.0.0.1:7001/eureka/apps
可以获得所有的提供者的情况，同时可以通过程序监控运行状态
<application>
....相关信息
</application>

2. eureka 共有2种

<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>

3.如 eureka客户端启动不起来可能和版本有很大关系
G降级到Finchley.SR1尝试下

4.eureka用户名密码加密以及启用https方式参考ch3-4和ch3-5
