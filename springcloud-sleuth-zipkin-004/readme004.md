zipkin
在使用 Spring Boot 2.x 版本后，官方就不推荐自行定制编译了，让我们直接使用编译好的 jar 包
也就是说原来通过@EnableZipkinServer或@EnableZipkinStreamServer的路子，启动SpringBootApplication自建Zipkin Server是不行了。Spring Cloud Finchley官方文档中直接让我们去参考旧版本的Dalson的文档。


参考文档
https://blog.csdn.net/zsf4748/article/details/80852264?utm_source=blogxgwz8

通过zuul访问：
http://localhost:6001/spring-cloud-provider-004/hello?name=zs


熔断：访问地址
http://desktop-po54vo9:9001/hello/dsfdsf


注册中心
Spring Cloud的注册中心可以由Eureka、Consul、Zookeeper、ETCD等来实现，
这里推荐使用Spring Cloud Eureka来实现注册中心，它基于Netfilix的Eureka做了二次封装，完成分布式服务中服务治理的功能，微服务系统中的服务注册与发现都通过这个注册中心来进行管理。
