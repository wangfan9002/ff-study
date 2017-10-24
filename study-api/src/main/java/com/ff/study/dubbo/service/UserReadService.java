package com.ff.study.dubbo.service;


import com.ff.study.dubbo.model.User;

import java.util.List;

/**
 * @author 深谷
 * @serial 2017/10/18 下午4:08.
 */
public interface UserReadService {
    List<User> queryList(String userName);
}
