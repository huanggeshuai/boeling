package com.xzit.service;

import com.xzit.entity.Areas;

import java.util.List;

/**
 * Created by huang on 2018/4/3.
 */
public interface AreasService {
    List<Areas> queryByCityid(Integer cityid);
    String getarea(Integer Areaid);

}
