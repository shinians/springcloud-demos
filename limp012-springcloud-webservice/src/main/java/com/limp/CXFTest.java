package com.limp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.limp.service.OrderInfo;
import com.limp.service.HelloService;
//import com.limp.service.OrderInfo;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.*;
import org.springframework.core.annotation.Order;

import javax.xml.namespace.QName;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

public class CXFTest {
//	private static  String   wsdlUrl="http://localhost:8001/demo/HelloServiceDemoUrl?wsdl";
	private static  String   wsdlUrl="http://192.168.1.15/csp/i-lis/DHC.LIS.BS.WebLisService.cls?wsdl";
//	private static final QName SERVICE_NAME = new QName("namespace", "serviceName");
	private static final QName SERVICE_NAME = new QName("http://service.limp.com/", "HelloServiceDemo");

	//定义缓存，加快创建效率
	public static Map<String,Endpoint> factoryMap=new HashMap<String, Endpoint>();
	public static Map<String,Client> clientMap=new HashMap<String, Client>();
	public static void main(String[] args) throws Exception{

		/*********************参数初始化过程************************************/
		String str="[{\"id\":\"NO.1\",\"money\":23},{\"id\":\"NO.2\",\"money\":24}]";
		Object initDomain=JSON.parseArray(str,OrderInfo.class);

//		pojoInvokes1();
		List<Object> listParam=new ArrayList<>();
		String params="{\"id\":\"zhangsan\",\"money\":23}";
		listParam.add(params);

		//////
		List<Object> listParam2=new ArrayList<>();
		String obj0="超级管理员";
		String obj1="{\"id\":\"zhangsan\",\"money\":23}";
		String obj2="{\"name\":\"one test\",\"intro\":\"这是订单详情\"}";
		listParam2.add(obj0);
		listParam2.add(obj1);
		listParam2.add(obj2);

		/////
		List<Object> listParam1=new ArrayList<>();
		listParam1.add("zhangsan");
		listParam1.add("lisi");
		listParam1.add(6);

		List<Object> listParam11=new ArrayList<>();
		listParam11.add("12");

		/////
		List<Object> listParam4=new ArrayList<>();
		OrderInfo orderInfo1=new OrderInfo();
		orderInfo1.setMoney(23);
		orderInfo1.setId("NO.1");
		OrderInfo orderInfo2=new OrderInfo();
		orderInfo2.setMoney(24);
		orderInfo2.setId("NO.2");
		List listOrder=new ArrayList();
		listOrder.add(orderInfo1);
		listOrder.add(orderInfo2);
		//[{"id":"NO.2","money":24},{"money":0}]
		listParam4.add(JSON.toJSON(listOrder).toString());

		List<Object> listParam6=new ArrayList<>();
		listParam6.add("北京");

		/*********************方法动态调用测试************************************/

		for(int i=0;i<2;i++){
			Long start=System.currentTimeMillis();
			//多个参数情况
			System.out.println(dynamicCallWebServiceByCXF(wsdlUrl,"SendLinkLabNoWithOrdRowId",
					"http://tempuri.org","HelloServiceDemo",listParam11));
			//单个对象
//			System.out.println(dynamicCallWebServiceByCXF(wsdlUrl,"selectOrderInfo", "http://service.limp.com/","HelloServiceDemo",listParam));
			//多个对象
//			System.out.println(dynamicCallWebServiceByCXF(wsdlUrl,"selectOrderInfoAndOrderDetail", "http://service.limp.com/","HelloServiceDemo",listParam2));
			//集合测试
//			System.out.println(dynamicCallWebServiceByCXF(wsdlUrl,"getOrderList", "http://service.limp.com/","HelloServiceDemo",listParam4));

			//net创建的webservice通过其他方式获取
//			System.out.println(dynamicCallWebServiceByCXF("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl","getSupportCity",
//					"http://WebXml.com.cn/","",listParam6));
			Long end=System.currentTimeMillis();
			System.out.println(i+"调用用时"+(end-start));
		}
	}

    /**
     * 简单类型的调用（String）：
	 */
	public  static void SimpleInvoke(){
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient(wsdlUrl);
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
		Object[] objects = new Object[0];
		try {
			// invoke("方法名",参数1,参数2,参数3....);
			objects = client.invoke("sayHello", "张三","lis");
			System.out.println("返回数据:" + objects[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 网上流传的方法【初始化复杂，后续有改进版】
	 * @throws Exception
	 */
	public  static void pojoInvokes()throws Exception{
		// 创建动态客户端
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		// 创建客户端连接
		Client client = factory.createClient(wsdlUrl, SERVICE_NAME);
		ClientImpl clientImpl = (ClientImpl) client;
		Endpoint endpoint = clientImpl.getEndpoint();
		// Make use of CXF service model to introspect the existing WSDL
		ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
		// 创建QName来指定NameSpace和要调用的service
		QName bindingName = new QName("http://service.limp.com/", "HelloServiceImplService");
		BindingInfo binding = serviceInfo.getBinding(bindingName);

		//todo:??????????    // 创建QName来指定NameSpace和要调用的方法
		QName opName = new QName("http://service.limp.com/", "getOrder");

		BindingOperationInfo boi = binding.getOperation(opName);
		BindingMessageInfo inputMessageInfo = boi.getInput();
		List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();
		// 取得对象实例
		MessagePartInfo partInfo = parts.get(0);
		Class<?> partClass = partInfo.getTypeClass();
		Object inputObject = partClass.newInstance();

		// 取得字段的set方法并赋值
		PropertyDescriptor partPropertyDescriptor = new PropertyDescriptor("id", partClass);
		Method userNoSetter = partPropertyDescriptor.getWriteMethod();
		userNoSetter.invoke(inputObject, "no001todo");

		// 调用客户端invoke()方法，把inputObject传递给要调用的方法并取得结果对象
		Object[] result = client.invoke(opName, inputObject);
		// 取得的结果是一个对象
		Class<?> resultClass = result[0].getClass();
		// 取得返回结果的get方法并得到它的值
		PropertyDescriptor resultDescriptor = new PropertyDescriptor("id", resultClass);
		Object resultGetter = resultDescriptor.getReadMethod().invoke(result[0]);
		System.out.println("result：" + resultGetter);
		// 取得返回结果的get方法并得到它的值
		PropertyDescriptor tokenDescriptor = new PropertyDescriptor("id", resultClass);
		// 取得的是一个对象实例
		Object getObj= tokenDescriptor.getReadMethod().invoke(result[0]);
		if("tokenGetter "!= null) {
			Class<?> resultTokenClass = tokenDescriptor.getReadMethod().invoke(result[0]).getClass();
			// 得到对象实例下的***属性值
			PropertyDescriptor expiredTimeDescriptor = new PropertyDescriptor("id", resultTokenClass);
			Object getter = expiredTimeDescriptor.getReadMethod().invoke(getObj);
			System.out.println("字段名：" + getter );
		}

	}

	/**
	 *
	 * @param wsdlUrl  wsdl的地址：http://localhost:8001/demo/HelloServiceDemoUrl?wsdl
	 * @param methodName 调用的方法名称 selectOrderInfo
	 * @param targetNamespace 命名空间 http://service.limp.com/
	 * @param name  name HelloServiceDemo
	 * @param paramList 参数集合
	 * @throws Exception
	 */
	public  static String dynamicCallWebServiceByCXF(String wsdlUrl,String methodName,String targetNamespace,String name,List<Object> paramList)throws Exception{
		//临时增加缓存，增加创建速度
		if(!factoryMap.containsKey(methodName)){
			// 创建动态客户端
			JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
			// 创建客户端连接
			Client client = factory.createClient(wsdlUrl);
			ClientImpl clientImpl = (ClientImpl) client;
			Endpoint endpoint = clientImpl.getEndpoint();
			factoryMap.put(methodName,endpoint);
			clientMap.put(methodName,client);
			System.out.println("初始化");
		}
		//从缓存中换取 endpoint、client
		Endpoint endpoint=factoryMap.get(methodName);
		Client client=clientMap.get(methodName);
		// Make use of CXF service model to introspect the existing WSDL
		ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
		// 创建QName来指定NameSpace和要调用的service
//		String localPart=name+"SoapBinding";//{http://tempuri.org}WebLisServiceSoap
		String localPart="WebLisServiceSoap";//{http://tempuri.org}WebLisServiceSoap
		QName bindingName = new QName(targetNamespace, localPart);
		BindingInfo binding = serviceInfo.getBinding(bindingName);

		//创建QName来指定NameSpace和要调用的方法绑定方法
		QName opName = new QName(targetNamespace, methodName);//selectOrderInfo

		BindingOperationInfo boi = binding.getOperation(opName);
//		BindingMessageInfo inputMessageInfo = boi.getInput();
		BindingMessageInfo inputMessageInfo = null;
		if (!boi.isUnwrapped()) {
			//OrderProcess uses document literal wrapped style.
			inputMessageInfo = boi.getWrappedOperation().getInput();
		} else {
			inputMessageInfo = boi.getUnwrappedOperation().getInput();
		}

		List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();

		/***********************以下是初始化参数，组装参数；处理返回结果的过程******************************************/
		Object[] parameters = new Object[parts.size()];
		for(int m=0;m<parts.size();m++){
			MessagePartInfo  part=parts.get(m);
			// 取得对象实例
			Class<?> partClass = part.getTypeClass();//OrderInfo.class;
			System.out.println(partClass.getCanonicalName()); // GetAgentDetails
			//实例化对象
			Object initDomain=null;
			//普通参数的形参，不需要fastJson转换直接赋值即可
			if("java.lang.String".equalsIgnoreCase(partClass.getCanonicalName())
					||"int".equalsIgnoreCase(partClass.getCanonicalName())){
				initDomain=paramList.get(m).toString();
			}
			//如果是数组
			else if(partClass.getCanonicalName().indexOf("[]")>-1){
				//转换数组
				initDomain=JSON.parseArray(paramList.get(m).toString(),partClass.getComponentType());
			}else{
				initDomain=JSON.parseObject(paramList.get(m).toString(),partClass);
			}
			parameters[m]=initDomain;

		}
		//定义返回结果集
		Object[] result=null;
	 	//普通参数情况 || 对象参数情况  1个参数 ||ArryList集合
			try {
				result = client.invoke(opName,parameters);
			}catch (Exception ex){
				ex.printStackTrace();
				return "参数异常"+ex.getMessage();
			}
		//返回调用结果
		if(result.length>0){
			return  JSON.toJSON(result[0]).toString();
		}
		return  "invoke success, but is void ";
	}

	public  static void pojoInvokes1()throws Exception{
		// 创建动态客户端
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		// 创建客户端连接
		Client client = factory.createClient(wsdlUrl);
		ClientImpl clientImpl = (ClientImpl) client;
		Endpoint endpoint = clientImpl.getEndpoint();
		// Make use of CXF service model to introspect the existing WSDL
		ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
		// 创建QName来指定NameSpace和要调用的service
		QName bindingName = new QName("http://service.limp.com/", "HelloServiceDemoSoapBinding");
		BindingInfo binding = serviceInfo.getBinding(bindingName);

		//todo:??????????    // 创建QName来指定NameSpace和要调用的方法绑定方法
		QName opName = new QName("http://service.limp.com/", "selectOrderInfo");//selectOrderInfo

		BindingOperationInfo boi = binding.getOperation(opName);
//		BindingMessageInfo inputMessageInfo = boi.getInput();
		BindingMessageInfo inputMessageInfo = null;
		if (!boi.isUnwrapped()) {
			//OrderProcess uses document literal wrapped style.
			inputMessageInfo = boi.getWrappedOperation().getInput();
		} else {
			inputMessageInfo = boi.getUnwrappedOperation().getInput();
		}

		List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();
		// 取得对象实例
		MessagePartInfo partInfo = parts.get(0);
		Class<?> partClass = partInfo.getTypeClass();//OrderInfo.class;
		System.out.println(partClass.getCanonicalName()); // GetAgentDetails
		Object inputObject = partClass.newInstance();

		// 取得字段的set方法并赋值
		PropertyDescriptor partPropertyDescriptor = new PropertyDescriptor("id", partClass);
		Method userNoSetter = partPropertyDescriptor.getWriteMethod();
		userNoSetter.invoke(inputObject, "zhangsan");

		//设置money
		PropertyDescriptor partPropertyDescriptor2 = new PropertyDescriptor("money", partClass);
		partPropertyDescriptor2.getWriteMethod().invoke(inputObject, 23);

		// 调用客户端invoke()方法，把inputObject传递给要调用的方法并取得结果对象
		Object[] parameters = new Object[]{"我是参数"};
//		Object[] result = client.invoke(opName, parameters);
		Object[] result = client.invoke(opName, inputObject);
		System.out.println(result);
		// 取得的结果是一个对象
	/*	Class<?> resultClass = result[0].getClass();
		// 取得返回结果的get方法并得到它的值
		PropertyDescriptor resultDescriptor = new PropertyDescriptor("id", resultClass);
		Object resultGetter = resultDescriptor.getReadMethod().invoke(result[0]);
		System.out.println("result：" + resultGetter);
		// 取得返回结果的get方法并得到它的值
		PropertyDescriptor tokenDescriptor = new PropertyDescriptor("id", resultClass);
		// 取得的是一个对象实例
		Object getObj= tokenDescriptor.getReadMethod().invoke(result[0]);
		if("tokenGetter "!= null) {
			Class<?> resultTokenClass = tokenDescriptor.getReadMethod().invoke(result[0]).getClass();
			// 得到对象实例下的***属性值
			PropertyDescriptor expiredTimeDescriptor = new PropertyDescriptor("id", resultTokenClass);
			Object getter = expiredTimeDescriptor.getReadMethod().invoke(getObj);
			System.out.println("字段名：" + getter );
		}*/


	}


		/**
         * 对象传参
         */
	public  static void pojoInvoke(){
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient(wsdlUrl);
		Object[] objects = new Object[0];
		try {
			//通过反射，创建OrderInfo对象，com.limp.service.OrderInfo 这个包名称必须和webservice的中的order路径一致
			Object order = Thread.currentThread().getContextClassLoader().
					loadClass("com.limp.service.OrderInfo").newInstance();

			//初始化实体对象
			Method m = order.getClass().getMethod("setId", String.class);
			Method m1 = order.getClass().getMethod("setMoney", double.class);
			Method m2 = order.getClass().getMethod("setOrderNo", String.class);
			m.invoke(order, "uuid213-281heq-2131");
			m1.invoke(order, 23);
			m2.invoke(order, "NO110");

			//开始调用
			objects = client.invoke("getOrder", order);
			System.out.println("调用对象形式参数返回数据:" + objects[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  方式1.代理类工厂的方式,需要拿到对方的接口
	 */
	public   void  methodMustCreate(){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloService.class);
		//特别注意：地址不要写成http://localhost:8001/demo
		factory.setAddress("http://localhost:8001/demo/sayHello?wsdl");
		//只能添加接口类，否则会提示参数错误：错误demo：factory.setServiceClass(HelloServiceImpl.class);
		factory.getInInterceptors().add(new LoggingInInterceptor());
		HelloService service = (HelloService) factory.create();
		System.out.println(service.sayHello2("你好","2",4));
	}


}
