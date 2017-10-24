package com.ff.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ff.study.dubbo.model.Order;
import com.ff.study.dubbo.service.OrderReadService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 深谷
 * @serial 2017/10/19 下午1:02.
 */
@Service(version = "1.0.0")
public class OrderReadServiceImpl implements OrderReadService {
    @Override
    public List<Order> queryOrderList(String title) {
        List<Order> orderList = new ArrayList<Order>(2);
        for (int i = 0; i < 3; i++) {
            Order order = new Order();
            order.setId(i + 100L);
            order.setCreateDate(new Date());
            order.setTitle(title + "--" + i);
            orderList.add(order);
        }
        return orderList;
    }
}
