package com.xzit.service;

import com.xzit.entity.Provinces;

import java.util.List;

/**
 * Created by huang on 2018/4/3.
 */
public interface ProvinceService {
    List<Provinces> queryall();
    String getProvincename(Integer provinceid);
}
