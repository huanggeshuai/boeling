package com.xzit.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2018/1/6.
 */
public class JsonMapUtils {
    private static final String success="success";
    private static final String msg="msg";
    public static void Success_Map(Map map,String data){
        map.put(success,true);
        map.put(msg,data);
        Log4jUtils.showinfo(map);
    }
    public static void Fail_Map(Map map,String data){
        map.put(success,false);
        map.put(msg,data);
        Log4jUtils.showinfo(map);
    }
    public static Map Success_Map(Object data){
        Map map=new HashMap();
        map.put(success,true);
        map.put(msg,data);
        Log4jUtils.showinfo(map);
        return map;
    }
    public static Map Fail_Map(String data){
        Map map=new HashMap();
        map.put(success,false);
        map.put(msg,data);
        Log4jUtils.showinfo(map);
        return map;
    }
}
