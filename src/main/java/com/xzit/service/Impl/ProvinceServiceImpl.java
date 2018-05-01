package com.xzit.service.Impl;

import com.xzit.entity.Provinces;
import com.xzit.entity.ProvincesExample;
import com.xzit.mapper.ProvincesMapper;
import com.xzit.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huang on 2018/4/3.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvincesMapper provincesMapper;
    public List<Provinces> queryall() {
        ProvincesExample provincesExample=new ProvincesExample();
        ProvincesExample.Criteria criteria=provincesExample.createCriteria();

        return provincesMapper.selectByExample(provincesExample);
    }

    public String getProvincename(Integer provinceid) {
        ProvincesExample provincesExample=new ProvincesExample();
        ProvincesExample.Criteria criteria=provincesExample.createCriteria();
        criteria.andProvinceidEqualTo(provinceid);
        List<Provinces > provinces=provincesMapper.selectByExample(provincesExample);
        return provinces.get(0).getProvince();
    }
}
