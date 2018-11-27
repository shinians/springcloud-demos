/*
package com.limp.controller;

import com.limp.CXFTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/24 23:26
 * @website： www.shinians.com
 *//*

@RestController
public class ClientController {
    private static  String   wsdlUrl="http://localhost:8001/demo/HelloServiceDemoUrl?wsdl";

     @RequestMapping("/client")
    public String invokeWS(){
        Long start=System.currentTimeMillis();
        try {
            String   wsdlUrl="http://localhost:8001/demo/HelloServiceDemoUrl?wsdl";
//            CXFTest.dynamicCallWebService(wsdlUrl,"selectOrderInfo","http://service.limp.com/","HelloServiceDemo");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        Long end=System.currentTimeMillis();

        return "ok:"+(end-start);
    }
}
*/
