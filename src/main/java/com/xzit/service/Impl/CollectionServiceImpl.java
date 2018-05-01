package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Collections;
import com.xzit.entity.CollectionsExample;
import com.xzit.entity.Venues;
import com.xzit.mapper.CollectionsMapper;
import com.xzit.service.CollectionService;
import com.xzit.service.VenuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by huang on 2018/4/15.
 */
@Service
public class CollectionServiceImpl implements CollectionService {

@Autowired
    CollectionsMapper collectionsMapper;

    public PageInfo<Collections> allinfo(Integer pageNo, Integer pageSize, Collections collections, List<Integer> venuesids) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        CollectionsExample collectionsExample=new CollectionsExample();
        CollectionsExample.Criteria criteria=collectionsExample.createCriteria();
        collectionsExample.setDistinct(true);
        criteria.andUseridEqualTo(collections.getUserid());
        criteria.andVenuesidIn(venuesids);
        PageInfo<Collections> collectionsPageInfo= new PageInfo<Collections>(collectionsMapper.selectByExample(collectionsExample));
        return collectionsPageInfo;
    }

    public boolean update(Collections collections) {

        return (collectionsMapper.updateByPrimaryKeySelective(collections)>0?true:false);
    }

    public Collections findbyid(Collections collections) {
        return collectionsMapper.selectByPrimaryKey(collections.getCollectionId());
    }


}
