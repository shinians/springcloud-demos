package com.limp.controller;

import com.limp.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/21 10:43
 * @website： www.shinians.com
 */
@RestController
public class HelloController {
    @Autowired
   private HelloFeignService helloFeignService;

    /**
     * 未压缩的请求
     * @param q
     * @return
     */
    @GetMapping(value ="search")
    public String search(String q){
        Long start=System.currentTimeMillis();
        String returnStr=helloFeignService.searchRepo(q);
        Long end=System.currentTimeMillis();

        System.out.println("未压缩请求用时"+(end-start));
        return  returnStr;
    }

    /**
     * 含有压缩的请求
     * @param q
     * @return
     */
    @GetMapping(value ="searchGzip")
    public ResponseEntity<byte[]> searchGzip(String q){
        Long start=System.currentTimeMillis();
        ResponseEntity<byte[]> returnByte=helloFeignService.searchRepoGzip(q);
        Long end=System.currentTimeMillis();
        System.out.println("压缩请求用时"+(end-start));
        return  returnByte;
    }
    /**
     * 含有压缩的请求：返回String类型
     * @param q
     * @return
     */
    @GetMapping(value ="searchGzipStr")
    public String searchGzipStr(String q){
        Long start=System.currentTimeMillis();
        ResponseEntity<byte[]> returnByte=helloFeignService.searchRepoGzip(q);
        String str=new String(returnByte.getBody());
        Long end=System.currentTimeMillis();
        System.out.println("压缩请求用时Str"+(end-start));
        return  str;
    }

    /**
     * 下载操作
     * @param request
     * @return
     */
    @RequestMapping(value="/down")
    public ResponseEntity<byte[]>  testDownload(HttpServletRequest request){
        String filename="2.pdf";
        ServletContext scontext=request.getServletContext();
//        String path=scontext.getRealPath("/WEB-INF/file/"+filename);
        String path="D://1.pdf";
        System.out.println(path);
        File f=new File(path);
        InputStream in;
        ResponseEntity<byte[]> response=null ;
        try {
            in = new FileInputStream(f);
            byte[] b=new byte[in.available()];
            in.read(b);
            HttpHeaders headers = new HttpHeaders();
            filename = new String(filename.getBytes("gbk"),"iso8859-1");
            headers.add("Content-Disposition", "attachment;filename="+filename);
            HttpStatus statusCode=HttpStatus.OK;
            response = new ResponseEntity<byte[]>(b, headers, statusCode);
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }



}
