package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.VenuesAllocation;
import com.xzit.entity.VenuesAllocationExample;
import com.xzit.mapper.VenuesAllocationMapper;
import com.xzit.service.VenuesAllocationService;
import com.xzit.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public void importExcelInfo(InputStream in, MultipartFile file) throws Exception {
        List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
        List<VenuesAllocation> venuesAllocations = new ArrayList<VenuesAllocation>();
        //遍历listob数据，把数据放到List中
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            VenuesAllocation venuesAllocation = new VenuesAllocation();
            //设置编号

            venuesAllocation.setVenuesid(new Integer(ob.get(0).toString()));
            venuesAllocation.setVenuesConfiguration(new Integer(ob.get(1).toString()));
            venuesAllocation.setFeeScale(new BigDecimal(ob.get(2).toString()));
            venuesAllocation.setRemark(ob.get(3).toString());

            venuesAllocations.add(venuesAllocation);
        }
        //批量插入
        for(VenuesAllocation venuesAllocations1:venuesAllocations){
              venuesAllocationMapper.insertSelective(venuesAllocations1);
        }
    }
}
