package com.xzit.service;


import com.github.pagehelper.PageInfo;
import com.xzit.entity.Orders;

/**
 * Created by huang on 2018/4/2.
 */
public interface OrderService {
    void addorder(Orders order);
    PageInfo<Orders> allinfo(Orders orders, Integer pageNo, Integer pageSize, String order, String sort);
}
