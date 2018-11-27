操作流程
1.依次启动注册中心 、生产者、路由zuul

2.调用过程

访问注册中心（验证能否访问，其他组件是否已经注册进来）：http://localhost:7001/

看生产者是否能调通
访问：http://localhost:8001/hello?name=zs
访问：http://localhost:8002/hello?name=zs

通过zuul访问生产者
生产者1：http://localhost:6001/spring-cloud-producter1-002/hello?name=zs
生产者2：http://localhost:6001/spring-cloud-producter2-002/hello?name=zs
两个生产者名称如下：
spring-cloud-producter1-002
spring-cloud-producter2-002

一、zuul：token拦截、开启重试机制
二、api服务网关zuul回退fallback
hystrix有fallback回退能力，及如果服务调用出现了异常，则执行指定的fallback方法。
zuul对api服务集群进行了反向代理，集成了hystrix，那zuul也能fallback了。

启动所有组件后->调用生产者2：http://localhost:6001/spring-cloud-producter2-002/hello?name=zs得到正常结果；
把spring-cloud-producter2-002服务停止掉。稍等一会，刷新页面，得到就是ServerFallback中指定的返回的内容。
如果把ServerFallback.java去掉，会发现页面得到的时候异常信息，zuul的日志或控制台打印refuse connection的异常信息。
三、zuul其他配置，结合spring-cloud-zuul-config-test-002
http://localhost:6002/api1/hello?name=zs&token=zs

四、springbootadmin构建
https://github.com/codecentric/spring-boot-admin
构建流程


所需要jar

创建package
/**************************************/
eureka版本 在springboot1.X 和2.X区别
<artifactId>spring-cloud-starter-eureka</artifactId>
<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>




/******默认引用日志：默认日志Logback*****************/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

private Logger logger= LoggerFactory.getLogger(HelloController.class);

SLF4J——Simple Logging Facade For Java，它是一个针对于各类Java日志框架的统一Facade抽象。Java日志框架众多——常用的有java.util.logging, log4j, logback，commons-logging, Spring框架使用的是Jakarta Commons Logging API (JCL)。而SLF4J定义了统一的日志抽象接口，而真正的日志实现则是在运行时决定的——它提供了各类日志框架的binding。

Logback是log4j框架的作者开发的新一代日志框架，它效率更高、能够适应诸多的运行环境，同时天然支持SLF4J。

默认情况下，Spring Boot会用Logback来记录日志，并用INFO级别输出到控制台。在运行应用程序和其他例子时，你应该已经看到很多INFO级别的日志了。
