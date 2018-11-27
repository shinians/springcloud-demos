/*
package com.limp;

import com.limp.service.HelloService;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.*;

import javax.xml.namespace.QName;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;

public class Anix2Test {
	private static  String   wsdlUrl="http://localhost:8001/demo/sayHello?wsdl";
//	private static final QName SERVICE_NAME = new QName("namespace", "serviceName");
	private static final QName SERVICE_NAME = new QName("http://service.limp.com/", "HelloServiceImplService");

	public static void main(String[] args) throws Exception{
		methodMustCreate();

	}





	*/
/**
	 *  方式1.代理类工厂的方式,需要拿到对方的接口
	 *//*

	public  static void  methodMustCreate()throws Exception{
		//使用RPC方式调用WebService
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
//        options.setExceptionToBeThrownOnSOAPFault(false);
		options.setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
		options.setProperty(HTTPConstants.CHUNKED, "false");
		//指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl");
		options.setTo(targetEPR);
		options.setAction("http://WebXml.com.cn/getWeather");

		//指定方法的参数值
		Object[] opAddEntryArgs = new Object[] {"昌平",""};

		//指定要调用的方法及WSDL文件的命名空间
		QName opAddEntry = new QName("http://WebXml.com.cn/", "getWeather");
		//调用法并输出该方法的返回值
//        System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs));
		Object[] result=serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, new Class[]{String.class});
		for (Object object : result) {
			System.out.println(object.toString());
		}
	}

	}


*/
