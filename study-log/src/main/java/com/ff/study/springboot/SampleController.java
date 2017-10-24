package com.ff.study.springboot;

import com.ff.core.message.MessageService;
import com.ff.study.JedisClientUtil;
import com.ff.study.RedisPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(
        basePackages = "com.ff.study"
)
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    JedisClientUtil jedisClientUtil;


    @RequestMapping("/")
    @ResponseBody
    String home() {
        //this.testLog();

        MessageService messageService = new MessageService();
        messageService.sendMessage();
        System.out.println("=================");
//        MessageUtils.sendMessage();
        System.out.println("-------");
        messageService.sendMessageVersionTwo();
       // messageService.sendMessageVersionTwo();

        return "Hello World! 这是王思发的log study";
    }

    @RequestMapping("/hello")
    String hello() {
        String ret = "/index";
        System.out.println("ret==" + ret);
        return ret;
    }


    @RequestMapping("/pool")
    @ResponseBody
    String pool() {
        System.out.println("<<<<<<<<<<<request pool>>>>>>>>>>>>");
        final StringBuilder stringBuilder = new StringBuilder();
        List<Thread> threadList = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            Thread temp = new Thread(new Runnable() {
                public void run() {
                    int total = 0;
                    for (int i=0; i<10000; i++) {
                        total = total + i;
                        stringBuilder.append(jedisClientUtil.getValue());
                    }
                    System.out.println("total: " + total);
                }
            });
            threadList.add(temp);
        }
        for (int i = 0; i < 10; i++) {
            threadList.get(i).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

    private void testLog() {
        //MDC.put("traceId", "00100");
        logger.info("111--address:{}", "安徽和县");
        //MDC.put("traceId", "22900");
        String s = "Hello world";
        try {
            Integer i = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            logger.error("Failed to format {{}}", s, e);
        }
        logger.error("姓名:{}", "王思发");
    }
}
