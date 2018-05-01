package com.xzit.service.Impl;

import com.xzit.entity.Cities;
import com.xzit.entity.CitiesExample;
import com.xzit.mapper.CitiesMapper;
import com.xzit.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huang on 2018/4/3.
 */
@Service
public class CitiesServiceImpl implements CitiesService {
    @Autowired
    private CitiesMapper citiesMapper;
    public List<Cities> queryByProvinces(Integer provinceid) {
        CitiesExample citiesExample=new CitiesExample();
        CitiesExample.Criteria criteria=citiesExample.createCriteria();
        if(provinceid!=null){
            criteria.andProvinceidEqualTo(provinceid);
            return citiesMapper.selectByExample(citiesExample);
        }
        else
            return null;
    }

    public String getCityname(Integer cityid) {
        CitiesExample citiesExample=new CitiesExample();
        CitiesExample.Criteria criteria=citiesExample.createCriteria();
        criteria.andCityidEqualTo(cityid);
        List<Cities> cities=citiesMapper.selectByExample(citiesExample);
        Cities citie=cities.get(0);
        return citie.getCity();
    }
}
