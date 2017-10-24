package com.ff.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ff.study.dubbo.model.User;
import com.ff.study.dubbo.service.UserReadService;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 深谷
 * @serial 2017/10/18 下午4:14.
 */
@Service(version="1.0.0", group = "vipUserReadService")
public class VipUserReadServiceImpl implements UserReadService, InitializingBean {

    @Override
    public List<User> queryList(String userName) {
        List<User> userList = new ArrayList<User>(10);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setUserName(userName + "-vip-" + i);
            user.setId(i + 0L);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=====================");
        System.out.println("$$$$$$$$$$$############");
    }
}
