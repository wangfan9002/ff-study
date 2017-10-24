package com.ff.study.springboot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class BootController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World! 这是王思发的测试项目-hdd";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootController.class, args);
    }
}
