package com.limp.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/21 20:27
 * @website： www.shinians.com
 */
@XmlRootElement(name = "OrderInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "orderNo", "id","money" })
public class OrderInfo implements Serializable {
    public String orderNo;
    public String id;
    public  double money;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public OrderInfo() {
//        System.out.println("空构造方法");
    }

    /**
     * 注意：在webService的调用过程中，不能使用Order的全构造函数。在网上查找原因的时候遇到了一些解释。主要原因就是在调用构造函数的时候，在本地其实是Student的一个代理类，并且这时候没有和服务器进行通信。只有当webservice方法被调用的时候，才会和服务器端通信
     * @return
     */
    public OrderInfo(String orderNo, String id, double money) {
        this.orderNo = orderNo;
        this.id = id;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", id='" + id + '\'' +
                ", money=" + money +
                '}';
    }
}
