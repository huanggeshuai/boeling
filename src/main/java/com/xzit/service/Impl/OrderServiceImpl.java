package com.xzit.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.ExcelBean;
import com.xzit.entity.Orders;
import com.xzit.entity.OrdersExample;
import com.xzit.entity.VenuesExample;
import com.xzit.mapper.OrdersMapper;
import com.xzit.service.OrderService;
import com.xzit.utils.*;
import com.xzit.vo.Ordervo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

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

    public XSSFWorkbook exportpayInfo(Orders orders) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria=ordersExample.createCriteria();
        criteria.andUseridEqualTo(orders.getUserid());
        List<Ordervo> list =new ArrayList<Ordervo>();

        List<Orders> orders1=orderMapper.selectByExample(ordersExample);
         for(Orders o:orders1){
             Ordervo ordervo=new Ordervo();
             ReflexUtils.Reflex(o,ordervo);
             list.add(ordervo);
         }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getIncomeState()==-1){
                list.get(i).setPaystate("支出");
            }else list.get(i).setPaystate("收入");
        }
        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap();
        XSSFWorkbook xssfWorkbook=null;
        //设置标题栏
        excel.add(new ExcelBean("用户姓名","user",0));
        excel.add(new ExcelBean("收款人","incomeUser",0));
        excel.add(new ExcelBean("日期","time",0));
        excel.add(new ExcelBean("收款明细","cause",0));
        excel.add(new ExcelBean("钱","money",0));
        excel.add(new ExcelBean("支付支出","paystate",0));
//        excel.add(new ExcelBean("具体地址地址","venuesAddress",0));
//        excel.add(new ExcelBean("开馆时间","openTime",0));
//        excel.add(new ExcelBean("闭馆时间","closeTime",0));
//        excel.add(new ExcelBean("用户联系方式","phone",0));
//        excel.add(new ExcelBean("场馆简介","brief",0));
        map.put(0, excel);

        xssfWorkbook = ExcelUtil.createExcelFile(Ordervo.class, list, map, "支付信息");
        return xssfWorkbook;
    }


}
