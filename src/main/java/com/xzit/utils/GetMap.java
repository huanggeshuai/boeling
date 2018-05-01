package com.xzit.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzit.entity.Gaode;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2018/4/3.
 */
public class GetMap {
   // private static final Logger logger = LoggerFactory.getLogger(GaoDeMapUtil.class);

    // 高德应用的地址
    private static String gaodeAppID = "92cb956c78f2ed82763c66ca9d93b36f";

    // 地理编码地址
    private static String map_codeurl = "http://restapi.amap.com/v3/geocode/geo";

    /*
     * static { Properties properties = new Properties(); try { gaodeAppID =
     * properties.getProperty("appkey"); } catch (Exception e) {
     * e.printStackTrace(); } }
     */

    /**
     * 输入地址返回识别后的信息
     *
     * @param address
     * @return 返回的类gaodelocation，详见类
     */

public static String  getGaodeinfo(String address) throws Exception {
    Dopost dopost=new Dopost();
    Map map=new HashMap();
    map.put("key",gaodeAppID);
    map.put("address",address);
    String url=dopost.dopost(map_codeurl,map);
    JSONObject jsonObject;
    jsonObject = JSON.parseObject(url);
    JSONArray jsa=jsonObject.getJSONArray("geocodes");
    if(jsa==null)
        return null;
    JSONObject jsonArray=jsa.getJSONObject(0);
    String location=jsonArray.getString("location");
   // String location=jsonObject.getString("location");
    return location;
}
    public static void main(String[] args) throws Exception {
   String mes =GetMap.getGaodeinfo("徐州工程学院");
   System.out.println(mes);
    }
}
