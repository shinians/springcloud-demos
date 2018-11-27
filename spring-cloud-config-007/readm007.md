启动server和client后
访问：http://localhost:7002/limp-config/dev/master
查看结果


client无法获得注入的值，版本引入的jar包的问题可能性比较大
 中文乱码问题解决方案？？？
 
 案例1：启动spring-cloud-config-server-007、spring-cloud-config-client-007
 改变git配置文件，然后看改变状态
 
 案例2：
 配置文件手动刷新：
 启动 spring-cloud-config-refresh-007 
 http://localhost:8002/actuator/refresh   注意POST提交
  http://localhost:8002/hello访问查看结果
  
  案例3
  ch11-3 自动刷新结合 spring cloud bus ，需要git或者码云上的回调地址
  
  mysql数据和和非关系型数据库mongdb可以看ch3-4
  
  #案例4
  自动刷新插件：springcloud-autoconfig-refresh-starter
  
  #案例 5 ch12-6
  自动刷新回退： profile: dev
                     fallbackLocation