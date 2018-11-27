package com.limp.service;


import com.limp.domain.OrderDetail;
import com.limp.domain.OrderInfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/21 16:56
 * @website： www.shinians.com
 */
@WebService
public interface  HelloService {
    /**
     * 你好，webservice
     * @param name
     * @return
     */
    @WebMethod
    String sayHello(@WebParam(name="name")  String name);

    @WebMethod
    String invoke(@WebParam(name="methodName")  String methodName);


    /**
     * 支持多个普通参数，单个对象
     * 如果我们想保证参数在wsdl文件中是正确的可以使用下面的注解，否则参数就是arg0
     * @param name
     * @param name2
     * @param times 次数
     * @return
     */
    @WebMethod
    String sayHello2(String name,@WebParam(name="name2")String name2,Integer times);

    @WebMethod
    String testMap(HashMap<String,String> param,String name);

    @WebMethod
    String testListMap(List<HashMap<String,String>>listMap);

    /**
     * 啊 遇到这个问题 就是Webservice不能传递Map类型的数据。
     webservice可以处理String 基本数据类型，普通POJO、list 数组。
     所以将map进行转换吧。
     * @param mapOrder
     * @return
     */
//    @WebMethod
//    String getMapOrder(Map<String,OrderInfo> mapOrder);

    @WebMethod(action = "OrderInfoProcess")
    String selectOrderInfo(@WebParam(name="OrderDomain") OrderInfo order);

    /**
     *
     * @param name
     * @param order
     * @param orderDetail
     * @return
     */
    @WebMethod
    String selectOrderInfoAndOrderDetail(String name,@WebParam(name="OrderDomain") OrderInfo order,@WebParam(name="OrderDetail") OrderDetail orderDetail);



    @WebMethod
    String getOrderList(@WebParam(name="Orders")ArrayList<OrderInfo> orderInfoList);
    @WebMethod
    String getOrderList1(@WebParam(name="Orders")OrderInfo [] orderInfoList);



}
