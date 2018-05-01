package com.xzit.utils;

import java.util.Random;

/**
 * Created by huang on 2018/4/14.
 */
public class VerifyCode {
    public static String getNum(){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        return result;

    }
    public static void main(String[] args) throws Exception {

        System.out.println(VerifyCode.getNum());
    }
}
