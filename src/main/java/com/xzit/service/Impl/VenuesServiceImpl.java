package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.CitiesExample;
import com.xzit.entity.ProvincesExample;
import com.xzit.entity.Venues;
import com.xzit.entity.VenuesExample;
import com.xzit.mapper.CitiesMapper;
import com.xzit.mapper.ProvincesMapper;
import com.xzit.mapper.VenuesMapper;
import com.xzit.service.VenuesService;
import com.xzit.utils.Constant;
import com.xzit.utils.EntityToColum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2018/4/3.
 */
@Service
public class VenuesServiceImpl implements VenuesService {
    @Autowired
    VenuesMapper venuesMapper;
    @Autowired
    CitiesMapper provincesMapper;
    public PageInfo<Venues> alluser(Venues venues, Integer pageNo, Integer pageSize, String order, String sort,Integer image) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        VenuesExample venuesExample= new VenuesExample();
        VenuesExample.Criteria criteria=venuesExample.createCriteria();
        if(order!=null&&sort!=null){
            venuesExample.setOrderByClause(EntityToColum.GetVenuesMap(sort)+" "+order);
        }
        if(venues.getDeletestate()!=null){
            criteria.andDeletestateEqualTo(venues.getDeletestate());
        }
        if(image!=null){
            if(image==1){
                criteria.andImageurlIsNotNull();
            }else if(image==0){
                criteria.andImageurlIsNull();
            }
        }

        PageInfo<Venues> pageInfo=new PageInfo<Venues>(venuesMapper.selectByExample(venuesExample));
        return pageInfo;
    }

    public boolean addVenues(Venues venues) {
        int num=venuesMapper.insertSelective(venues);

        return (num>0)?true:false;
    }

    public boolean editVenues(Venues venues) {
        return (venuesMapper.updateByPrimaryKeySelective(venues)>0)?true:false;
    }

    public Venues findbyid(Integer venuesid) {
        return venuesMapper.selectByPrimaryKey(venuesid);
    }

    public List<Venues> venues() {
        VenuesExample venuesExample= new VenuesExample();
        return venuesMapper.selectByExample(venuesExample);
    }

    public boolean cancel(Venues venues) {
        VenuesExample venuesExample= new VenuesExample();
        VenuesExample.Criteria criteria=venuesExample.createCriteria();
        venues.setDeletestate(Constant.Del.isdel.getKey());

        return (venuesMapper.updateByPrimaryKeySelective(venues)>0)?true:false;
    }

    public boolean reover(Venues venues) {
        VenuesExample venuesExample= new VenuesExample();
        VenuesExample.Criteria criteria=venuesExample.createCriteria();
        venues.setDeletestate(Constant.Del.nodel.getKey());

        return (venuesMapper.updateByPrimaryKeySelective(venues)>0)?true:false;
    }

    public List<Integer> getVenuesid(String province) {
        CitiesExample provincesExample=new CitiesExample();
        CitiesExample.Criteria criteriaP=provincesExample.createCriteria();
        criteriaP.andCityLike("%"+province+"%");
        Integer pid=provincesMapper.selectByExample(provincesExample).get(0).getCityid();
        VenuesExample venuesExample= new VenuesExample();
        VenuesExample.Criteria criteria=venuesExample.createCriteria();
        criteria.andDeletestateEqualTo(0);
        criteria.andVenuesCityEqualTo(pid);
        List<Venues> venues=venuesMapper.selectByExample(venuesExample);
        List<Integer> venuesids=new ArrayList<Integer>();
        for(int i=0;i<venues.size();i++){
            venuesids.add(venues.get(i).getVenuesid());
        }
        return venuesids;
    }
}
