package com.ff.study.dubbo;

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
 * Created by 深谷 on 2017/9/22 上午10:58.
 */

@Controller
@ComponentScan("com.ff.dubbo.api")
@SpringBootApplication
@ImportResource(value = {"classpath:spring/*.xml"})
public class DubboProviderApplication {

    @Resource
    @Qualifier("vipUserReadService")
    private UserReadService vipUserReadService;

    @Resource
    @Qualifier("userReadService")
    private UserReadService userReadService;

    @Autowired
    private OrderReadService orderReadService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        System.out.println(userReadService.queryList("do"));
        return orderReadService.queryOrderList("dangdang") + "hello dubbo provider: " + vipUserReadService.queryList("wsf");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
