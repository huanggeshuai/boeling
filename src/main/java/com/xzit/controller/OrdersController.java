package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Orders;
import com.xzit.service.OrderService;
import com.xzit.utils.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.OptionalDataException;

/**
 * Created by huang on 2018/4/10.
 */
@Controller
@RequestMapping(value = "/orders")
public class OrdersController {
    Integer uid;
    @Autowired
    OrderService orderService;
    @RequestMapping(value = "/showallorderinfo.action")
    @ResponseBody
    public DataGrid<Orders> allinfo(Orders orders,Integer page, Integer rows,String order,String sort){
       if(orders.getUserid()==null){
           orders.setUserid(uid);

       }
        PageInfo<Orders> ordersPageInfo=orderService.allinfo(orders,page,rows,order,sort);
        DataGrid<Orders> dataGrid=new DataGrid<Orders>();
        dataGrid.setRows(ordersPageInfo.getList());
        dataGrid.setTotal(ordersPageInfo.getTotal());
        return dataGrid;
    }
    @RequestMapping(value = "findorderjsp.action")
    public String findjsp(Integer userid) {
        uid = userid;
        return "web/orders/orders";
    }
}
