package com.xzit.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Orders;
import com.xzit.entity.OrdersExample;
import com.xzit.mapper.OrdersMapper;
import com.xzit.service.OrderService;
import com.xzit.utils.Dateutils;
import com.xzit.utils.EntityToColum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huang on 2018/4/2.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersMapper orderMapper;

    public void addorder(Orders order) {
        order.setTime(Dateutils.getDate());
        orderMapper.insertSelective(order);
    }

    public PageInfo<Orders> allinfo(Orders orders, Integer pageNo, Integer pageSize, String order, String sort) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria=ordersExample.createCriteria();
        criteria.andUseridEqualTo(orders.getUserid());
        if(order!=null&&sort!=null){
            ordersExample.setOrderByClause(EntityToColum.GetOrderMap(sort)+" "+order);
        }
        PageInfo<Orders> ordersPageInfo=new PageInfo<Orders>(orderMapper.selectByExample(ordersExample));
        return ordersPageInfo;
    }


}
