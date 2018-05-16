package com.xzit.vo;

import com.xzit.entity.Orders;
import com.xzit.utils.ReflexUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by huang on 2018/5/16.
 */
public class Ordervo extends Orders {
    private String paystate;

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }
    public void getMethod(Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class clazz=obj.getClass();//获得实体类名
        Field[] fields = obj.getClass().getDeclaredFields();//获得属性
        //获得Object对象中的所有方法
        for(Field field:fields){
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            Method getMethod = pd.getReadMethod();//获得get方法
            getMethod.invoke(obj);//此处为执行该Object对象的get方法
            Method setMethod = pd.getWriteMethod();//获得set方法
            setMethod.invoke(obj,"参数");//此处为执行该Object对象的set方法
        }
    }
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Orders orders=new Orders();
        orders.setMedium(1);
        orders.setIncomeState(2);
        orders.setMoney(new BigDecimal(23234));
        orders.setUserid(3);
        orders.setTime(new Date());
        Ordervo ordervo=new Ordervo();
        Integer integer=0;
        ReflexUtils.Reflex(orders,integer);

    }
}
