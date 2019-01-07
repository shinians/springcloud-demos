package com.limp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @intro ：核心业务：转发功能实现【动态转发功能】
 * http://localhost:6001/testforward/hello?name=zs&token=1
 * @auth ： shinians
 * @time ： 2018/10/27 15:24
 * @website： www.shinians.com
 */
@Component
public class ForwardFilter extends ZuulFilter{

    private Logger logger= LoggerFactory.getLogger(ForwardFilter.class);

    private static Map<String,String> forwardUrlMap=new HashMap<>();

    static {
        forwardUrlMap.put("testforward","http://127.0.0.1:8001/");
    }

    @Override
    public String filterType() {
        //路由时进行转发；此外还含有 pre post error等类型
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();

        //获取请求的URI  //测试访问：http://localhost:6001/testforward/hello?name=zs&token=1
        String url=request.getRequestURI();//
        if(url.indexOf("testforward")>-1){
            try {
                //[1]：设置RouteHost
                URI uri1=new URI(forwardUrlMap.get("testforward"));
                ctx.setRouteHost(uri1.toURL());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //[2]：设置URI
            url=url.substring(url.indexOf("testforward")+12,url.length());
            ctx.put(FilterConstants.REQUEST_URI_KEY,url);
        }

//        url.split("/",3);
        logger.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());


        return null;
    }
}
