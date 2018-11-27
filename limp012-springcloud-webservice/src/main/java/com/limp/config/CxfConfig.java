package com.limp.config;

import com.limp.service.HelloService;
import com.limp.service.impl.HelloServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/21 16:58
 * @website： www.shinians.com
 */
@Configuration
public class CxfConfig {
   @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(),"/demo/*");
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public HelloService demoService() {
        return new HelloServiceImpl();
    }
     @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoService());
        endpoint.publish("/HelloServiceDemoUrl");
//        endpoint.publish("/sayHello2");
        return endpoint;
    }

}
