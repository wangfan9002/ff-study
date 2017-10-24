package com.ff.study;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.RandomAccess;
import java.util.UUID;

/**
 * Created by 深谷 on 2017/8/31 下午8:44.
 */
@Component
public class RedisPool {

    private String pool;

    @PostConstruct
    private String initPool() {
        System.out.println("initPool=============");
        try {
            //Thread.sleep(1000 * 10);
            int total = 0;
            for (int i=0; i<100000000; i++) {
                total = total + i;
            }
            System.out.println("pool total: " + total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pool = UUID.randomUUID().toString();
        return pool;
    }

    public String getPool() {
        //System.out.println("getPool=============");
        if (pool == null) {
            this.initPool();
        }
        return pool;
    }


}
