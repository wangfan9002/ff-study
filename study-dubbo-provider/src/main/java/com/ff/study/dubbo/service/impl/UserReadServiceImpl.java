package com.ff.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ff.study.dubbo.model.User;
import com.ff.study.dubbo.service.UserReadService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 深谷
 * @serial 2017/10/18 下午4:14.
 */
@Service(version="1.0.0", group = "userReadService")
public class UserReadServiceImpl implements UserReadService {

    @Override
    public List<User> queryList(String userName) {
        List<User> userList = new ArrayList<User>(10);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setUserName(userName + "-" + i);
            user.setId(i + 0L);
            userList.add(user);
        }
        return userList;
    }
}
