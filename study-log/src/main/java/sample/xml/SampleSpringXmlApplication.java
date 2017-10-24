package sample.xml;

/**
 * Created by 深谷 on 2017/8/22 下午3:01.
 */
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import sample.xml.service.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class SampleSpringXmlApplication implements CommandLineRunner {

    private static final String CONTEXT_XML = "classpath:/META-INF/application-context.xml";

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public void run(String... args) {
        System.out.println(this.helloWorldService.getHelloMessage());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication();
        Set<Object> set = new HashSet<Object>();
        set.add(CONTEXT_XML);
        application.setSources(set);
        //application.setSources(Collections.singleton(CONTEXT_XML));
        application.run(args);
    }

}