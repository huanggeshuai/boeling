package com.xzit.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by huang on 2017/11/24.
 */
public class DateConverter implements Converter<String ,Date> {
    public Date convert(String s) {
        try{
            if(s!=null && !"".equals(s.trim())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return sdf.parse(s);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }

    //如要求：日期格式可以为yyyy/MM/dd、yyyy-MM-dd 或yyyyMMdd。
    private SimpleDateFormat getSimpeDateFormat(String source) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat();
        if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",source)){
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$",source)){
            sdf = new SimpleDateFormat("yyyy/MM/dd");
        }else if(Pattern.matches("^\\d{4}\\d{2}\\d{2}$",source)){
            sdf = new SimpleDateFormat("yyyyMMdd");
        }
        return sdf;
    }

}
