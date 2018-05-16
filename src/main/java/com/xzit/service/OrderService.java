package com.xzit.service;


import com.github.pagehelper.PageInfo;
import com.xzit.entity.Orders;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

/**
 * Created by huang on 2018/4/2.
 */
public interface OrderService {
    void addorder(Orders order);
    PageInfo<Orders> allinfo(Orders orders, Integer pageNo, Integer pageSize, String order, String sort);
    XSSFWorkbook exportpayInfo(Orders orders) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

}
