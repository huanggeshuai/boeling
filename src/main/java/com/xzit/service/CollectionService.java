package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Collections;

import java.util.List;

/**
 * Created by huang on 2018/4/15.
 */
public interface CollectionService {
    PageInfo<Collections> allinfo(Integer pageNo, Integer pageSize,Collections collections, List<Integer> venuesids);
    boolean update(Collections collections);
    Collections findbyid(Collections collections);
}
