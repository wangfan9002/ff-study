package com.ff.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 深谷 on 2017/8/31 下午8:59.
 */
@Component
public class JedisClientUtil {
    @Autowired
    RedisPool redisPool;

    public String getValue() {
        return this.redisPool.getPool();
    }
}
