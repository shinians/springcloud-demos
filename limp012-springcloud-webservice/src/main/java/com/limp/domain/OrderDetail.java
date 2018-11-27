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
@XmlRootElement(name = "OrderDetail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name","intro" })
public class OrderDetail implements Serializable {
    public String name;
    public String intro;


    public OrderDetail() {
//        System.out.println("空构造方法");
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }

    public OrderDetail(String name, String intro) {
        this.name = name;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
