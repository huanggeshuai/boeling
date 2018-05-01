package com.xzit.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huang on 2018/1/6.
 */
public class WriteJson {
    static Class aClass=WriteJson.class;
    public static void  printJson(HttpServletResponse response,Object o){
        String json= JSON.toJSONString(o);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(json);
        out.close();
        Log4jUtils.showinfo(json);
    }
}
