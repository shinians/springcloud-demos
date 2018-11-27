启动项目后访问:springcloud-feign-hello-011；
  profiles:
      active: gzip(nogzip)切换是否启用压缩
     
      访问未压缩方法: http://localhost:8001/search?q=springcloud
      GZIP压缩方法 http://localhost:8001/searchGzip?q=springcloud
    
    Feign注解详解：
    name:微服务的名称，服务发现时使用
    url：url一般用于调试，可以手动指定FeignClien的调用地址
    decode404：当发生404错误时，如果该字段为true，会调用decoder进行解码，否则抛出FeignException
    configuration：Feign的配置类，可以自定义Feign的encoder，Decoder，loglevel，Contract
    fallback：定义容错的处理类
    fallfactory：工厂类
    path：定义当前FeignClient的统一前缀。
    
      

       
技能点：
1、feign的service的注解使用
@FeignClient(name = "github-client", url = "https://api.github.com", configuration = HelloFeignServiceConfig.class)
2、使用流程
   pom文件引入jar、启动类加入@EnableFeignClients、编写相应的service类

  /******************开启了Gzip压缩***********************/        
  1. 配置文件增加：
  feign:
      compression:
          request:
              enabled: true
              mime-types: text/xml,application/xml,application/json # 配置压缩支持的MIME TYPE
              min-request-size: 2048  # 配置压缩数据大小的下限
          response:
              enabled: true # 配置响应GZIP压缩
  
  2.Feign增加客户端返回方式：需要二进制流接受
     ResponseEntity<byte[]> searchRepoGzip(@RequestParam("q") String queryStr);
    
             
一、 Feign设置超时时间 
使用Feign调用接口分两层，ribbon的调用和hystrix的调用，所以ribbon的超时时间和Hystrix的超时时间的结合就是Feign的超时时间

#hystrix的超时时间
hystrix:
    command:
        default:
            execution:
              timeout:
                enabled: true
              isolation:
                    thread:
                        timeoutInMilliseconds: 60000
#ribbon的超时时间
ribbon:
  ReadTimeout: 3000
  ConnectTimeout: 3000

一般情况下 都是 ribbon 的超时时间（<）hystrix的超时时间（因为涉及到ribbon的重试机制） 
因为ribbon的重试机制和Feign的重试机制有冲突，所以源码中默认关闭Feign的重试机制


#hystrix的超时时间  也可以尝试这样设置 ，【book】
#ribbon的超时时间
ribbon:
  ReadTimeout: 3000
  ConnectTimeout: 3000
  
  ###熔断机制
feign.hystrix.enabled: true
hystrix:
    shareSecurityConttext:  true
    command:
        default:
            circuitBreaker:
              sleepWindowInMilliseconds: 10000
              forceClosed: true
            execution:
              timeout:
                enabled: true
              isolation:
                    thread:
                        timeoutInMilliseconds: 60000
                        
                        
# 使用Apache HttpClient替换Feign原生httpclient
1. pom文件引入相应的jar
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
		</dependency>    
2.配置文件配置参数 application-httpclient.yml
feign:
  httpclient:
      enabled: true		
      
      
#使用okhttp替换Feign原生httpclient 
1. pom文件引入相应的jar
    <dependency>
        <groupId>io.github.openfeign</groupId>
        <artifactId>feign-okhttp</artifactId>
    </dependency>    
 2.配置文件新增配置：参考application-okhttp.yml
 feign:
     httpclient:
          enabled: false
     okhttp:
          enabled: true      
   3.增加FeignOkHttpConfig配置类     
 多参数传递问题：get方法传递POJO解决方案
 1）把POJO拆成一个一个的单独的属性放在参数里面
 2）把方法参数变成map
 3）使用get传递@RequstBody,但是此方法违反restful规范
 4)参考ch4-2-consumer--》 FeignRequestInterceptor
 feign 不支持 GET 方法传 POJO, json body转query  
 
 
 Feign的文件上传参考：ch4-4                    