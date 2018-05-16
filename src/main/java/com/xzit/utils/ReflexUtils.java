package com.xzit.utils;

import org.apache.poi.ss.formula.functions.T;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by huang on 2018/5/16.
 */
public class ReflexUtils {
    public static void Reflex(Object obj1,Object obj2) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class clazz=obj1.getClass();//获得实体类名
        Field[] fields = obj1.getClass().getDeclaredFields();//获得属性
        //获得Object对象中的所有方法
       if(obj1.getClass().isAssignableFrom(obj2.getClass()))
           for(Field field:fields) {
               PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
               Method getMethod = pd.getReadMethod();//获得get方法
               Object obj = getMethod.invoke(obj1);//此处为执行该Object对象的get方法
               Method setMethod = pd.getWriteMethod();//获得set方法
               setMethod.invoke(obj2, obj);//此处为执行该Object对象的set方法
            //   System.out.println(obj);

           }else{
          // System.out.println("adasd");
       }
    }
}
