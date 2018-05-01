package com.xzit.utils;

import org.apache.log4j.Logger;

/**
 * Created by huang on 2018/1/6.
 */
 public  class  Log4jUtils  {
     static final String info="输出信息";
     public static void showinfo(Object o){
         Logger logger=Logger.getLogger(info);
         logger.info(o.toString());

     }
}
