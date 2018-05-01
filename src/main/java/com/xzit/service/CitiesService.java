package com.xzit.service;

import com.xzit.entity.Cities;

import java.util.List;

/**
 * Created by huang on 2018/4/3.
 */
public interface CitiesService {
    List<Cities> queryByProvinces(Integer provinceid);
    String getCityname(Integer cityid);
}
