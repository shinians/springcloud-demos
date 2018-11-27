package com.limp.service.impl;

import com.alibaba.fastjson.JSON;
import com.limp.domain.OrderDetail;
import com.limp.domain.OrderInfo;
import com.limp.service.HelloService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/21 16:57
 * @website： www.shinians.com
 */

/**
 * org.apache.cxf.common.i18n.UncheckedException: No operation was found with the name {http://impl.server.test.com/}helloWorld
 */
@WebService(targetNamespace = "http://service.limp.com/",
        endpointInterface = "com.limp.service.HelloService",serviceName = "HelloServiceDemo")
public class HelloServiceImpl  implements HelloService{
    @Override
    public String sayHello(String name) {
        return "你好,"+name;
    }

    @Override
    public String invoke(String methodName) {
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

    @Override
    public String sayHello2(String name, String name2,Integer times) {
        return "你好,"+name+" [and] "+name2+"  重复了"+times+"次数";
    }


        @Override
    public String testMap(HashMap<String, String> param, String name) {
        param.put("name",name);
        return param.toString();
    }

    @Override
    public String testListMap(List<HashMap<String, String>> listMap) {
        return listMap.toString();
    }

//    @Override
//    public String getMapOrder(Map<String, OrderInfo> mapOrder) {
//        return mapOrder.toString();
//    }

    @Override
    public String selectOrderInfo(OrderInfo order) {
        return JSON.toJSON(order).toString();
    }

    @Override
    public String selectOrderInfoAndOrderDetail(String name ,OrderInfo order, OrderDetail orderDetail) {
        return "["+name+"]"+JSON.toJSON(order).toString()+"【分割线】"+JSON.toJSON(orderDetail).toString();
    }

    @Override
    public String getOrderList(ArrayList<OrderInfo> orderInfos) {
        return JSON.toJSON(orderInfos).toString();
    }

    @Override
    public String getOrderList1(OrderInfo[] orderInfoList) {
        return null;
    }
}
