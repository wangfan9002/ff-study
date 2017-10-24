package com.ff.study.dubbo.service;

import com.ff.study.dubbo.model.Order;

import java.util.List;

/**
 * @author 深谷
 * @serial 2017/10/19 下午1:01.
 */
public interface OrderReadService {
    List<Order> queryOrderList(String title);
}
