package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.*;
import com.xzit.mapper.CitiesMapper;
import com.xzit.mapper.ProvincesMapper;
import com.xzit.mapper.VenuesMapper;
import com.xzit.service.VenuesService;
import com.xzit.utils.Constant;
import com.xzit.utils.EntityToColum;
import com.xzit.utils.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public XSSFWorkbook exportvenuesInfo(Venues venues) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        VenuesExample venuesExample= new VenuesExample();
        VenuesExample.Criteria criteria=venuesExample.createCriteria();
        if(venues.getDeletestate()!=null){
            criteria.andDeletestateEqualTo(venues.getDeletestate());
        }
        List<Venues> list = venuesMapper.selectByExample(venuesExample);
//        for(int i=0;i<list.size();i++){
//
//            list.get(i).setVenuesAddress(getAddress(list.get(i)));
//
//        }
        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap();
        XSSFWorkbook xssfWorkbook=null;
        //设置标题栏
        excel.add(new ExcelBean("场馆编号","venuesid",0));
        excel.add(new ExcelBean("场馆负责人","userCharge",0));
        excel.add(new ExcelBean("省","provinces",0));
        excel.add(new ExcelBean("市","cities",0));
        excel.add(new ExcelBean("县","areas",0));
        excel.add(new ExcelBean("联系方式","phone",0));
        excel.add(new ExcelBean("具体地址地址","venuesAddress",0));
        excel.add(new ExcelBean("开馆时间","openTime",0));
        excel.add(new ExcelBean("闭馆时间","closeTime",0));
        excel.add(new ExcelBean("用户联系方式","phone",0));
        excel.add(new ExcelBean("场馆简介","brief",0));
        map.put(0, excel);

        xssfWorkbook = ExcelUtil.createExcelFile(Venues.class, list, map, "场馆信息");
        return xssfWorkbook;
    }
}
