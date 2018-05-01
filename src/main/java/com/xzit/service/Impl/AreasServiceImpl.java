package com.xzit.service.Impl;

import com.xzit.entity.Areas;
import com.xzit.entity.AreasExample;
import com.xzit.mapper.AreasMapper;
import com.xzit.service.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huang on 2018/4/3.
 */
@Service
public class AreasServiceImpl implements AreasService {
    @Autowired
    private AreasMapper areasMapper;
    public List<Areas> queryByCityid(Integer cityid) {
        AreasExample areasExample=new AreasExample();
        AreasExample.Criteria criteria=areasExample.createCriteria();
        if(cityid!=null){
            criteria.andCityidEqualTo(cityid);
            return areasMapper.selectByExample(areasExample);
        }else
            return null;
    }

    public String getarea(Integer Areaid) {
        AreasExample areasExample=new AreasExample();
        AreasExample.Criteria criteria=areasExample.createCriteria();
        criteria.andAreaidEqualTo(Areaid);
        List<Areas> areas=areasMapper.selectByExample(areasExample);
        Areas area=areas.get(0);
        return area.getArea();
    }
}
