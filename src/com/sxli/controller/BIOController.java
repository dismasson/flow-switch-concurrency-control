package com.sxli.controller;

import com.sxli.service.sayHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BIO 同步阻塞线程的方式来处理，从接受请求到返回响应都是一个线程在处理
 *
 * http://www.cnblogs.com/zedosu/p/6666984.html
 */
@RestController
@RequestMapping("bio")
public class BIOController {


    @Autowired
    private sayHello sayHello;

    @RequestMapping("helloworld")
    public String sayHello(){
        //获取Controller方法运行的线程ID
        long controllerNowThreadId = Thread.currentThread().getId();
        //获取Service方法运行的线程ID
        long serviceNowThreadId = sayHello.returnThreadId();
        StringBuffer strBuff=new StringBuffer();
        strBuff.append("Controller的ThreadId="+controllerNowThreadId);
        strBuff.append("\t\tService的ThreadId="+serviceNowThreadId);
        strBuff.append("\t\t线程ID是否是同一个："+(controllerNowThreadId==serviceNowThreadId ? "是" : "否"));
        return strBuff.toString();
    }

}
