package com.ff.dubbo.server;

import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ff.study.dubbo.service.OrderReadService;
import com.ff.study.dubbo.service.UserReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 深谷
 * @serial 2017/10/18 下午4:52.
 */
@Controller
@SpringBootApplication
@ComponentScan(value = "com.ff.study")
@ImportResource(value = {"classpath:spring/*.xml"})
public class DubboConsumerApplication {
    @Autowired
    private UserReadService userReadService;

    @Autowired
    private UserReadService vipUserReadService;

    @Autowired
    private OrderReadService orderReadService;

    //@DubboConsumer
    //private OrderReadService orderReadService;


    @RequestMapping("/")
    @ResponseBody
    String home() {
       // Jedis
       System.out.println(vipUserReadService.queryList("vipService"));
        //System.out.println(userReadService.queryList("do"));
        return orderReadService.queryOrderList("consumer") + "hello dubbo consumer: " + userReadService.queryList("boot-dubbo");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

}
