package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.VenuesAllocation;
import com.xzit.entity.VenuesAllocationExample;
import com.xzit.mapper.VenuesAllocationMapper;
import com.xzit.service.VenuesAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huang on 2018/4/7.
 */
@Service
public class VenuesAllocationServiceImpl implements VenuesAllocationService {
    @Autowired
    VenuesAllocationMapper venuesAllocationMapper;
    public PageInfo<VenuesAllocation> alluser(VenuesAllocation venuesAllocation, Integer pageNo, Integer pageSize, String order, String sort) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        VenuesAllocationExample venuesAllocationExample=new VenuesAllocationExample();
        VenuesAllocationExample.Criteria criteria=venuesAllocationExample.createCriteria();
        criteria.andVenuesidEqualTo(venuesAllocation.getVenuesid());
        PageInfo<VenuesAllocation> pageInfo=new PageInfo<VenuesAllocation>(venuesAllocationMapper
        .selectByExample(venuesAllocationExample));
        return pageInfo;
    }
    public boolean addvenuesallocation(VenuesAllocation venuesAllocation) {
        return (venuesAllocationMapper.insertSelective(venuesAllocation)>0)?true:false;
    }
    public boolean editvenuesallocation(VenuesAllocation venuesAllocation) {
        return  (venuesAllocationMapper.updateByPrimaryKeySelective(venuesAllocation)>0)?true:false;
    }
    public VenuesAllocation findbyid(Integer venuesAllocationId) {
        return venuesAllocationMapper.selectByPrimaryKey(venuesAllocationId);
    }
}
