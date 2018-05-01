package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.ParticipateVenuesActivitiey;
import com.xzit.entity.ParticipateVenuesActivitieyExample;
import com.xzit.entity.User;
import com.xzit.mapper.ParticipateActivitiesUserMapper;
import com.xzit.mapper.ParticipateVenuesActivitieyMapper;
import com.xzit.service.ParticipateVenuesActivitieyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by huang on 2018/4/20.
 */
@Service
public class ParticipateVenuesActivitieyServiceImpl implements ParticipateVenuesActivitieyService {
    @Autowired
    ParticipateVenuesActivitieyMapper participateVenuesActivitieyMapper;
    public boolean editOrdertime(ParticipateVenuesActivitiey participateVenuesActivitiey) {
        if(participateVenuesActivitiey.getPaymentState()==1){
            participateVenuesActivitiey.setOrdertime(new Date());
        }

        return (participateVenuesActivitieyMapper.updateByPrimaryKeySelective(participateVenuesActivitiey)>0)?true:false;
    }

    public int add(ParticipateVenuesActivitiey participateVenuesActivitiey) {
        participateVenuesActivitiey.setCreatetime(new Date());
        int num=participateVenuesActivitieyMapper.insertSelective(participateVenuesActivitiey);
        Integer id=participateVenuesActivitiey.getParticipateVenuesActivieyId();
        return id;
    }

    public PageInfo<ParticipateVenuesActivitiey> allinfo(ParticipateVenuesActivitiey participateVenuesActivitiey,Integer pageNo, Integer pageSize) {
        ParticipateVenuesActivitieyExample participateVenuesActivitieyExample=new ParticipateVenuesActivitieyExample();
        ParticipateVenuesActivitieyExample.Criteria criteria=participateVenuesActivitieyExample.createCriteria();
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        if(participateVenuesActivitiey.getUserid()!=null){
            criteria.andUseridEqualTo(participateVenuesActivitiey.getUserid());
            participateVenuesActivitieyExample.setOrderByClause("createtime"+" "+"desc");
        }
       if(participateVenuesActivitiey.getVenuesAllocationId()!=null){
            criteria.andVenuesAllocationIdEqualTo(participateVenuesActivitiey.getVenuesAllocationId());
            criteria.andUserStateEqualTo(1);
       }

        PageInfo<ParticipateVenuesActivitiey> participateVenuesActivitieyPageInfo
                =new PageInfo<ParticipateVenuesActivitiey>(participateVenuesActivitieyMapper.selectByExample(participateVenuesActivitieyExample));
        return participateVenuesActivitieyPageInfo;
    }

    public boolean editFinishtime(ParticipateVenuesActivitiey participateVenuesActivitiey) {
        if(participateVenuesActivitiey.getUserState()==1||participateVenuesActivitiey.getUserState()==-1){
            participateVenuesActivitiey.setFinishtime(new Date());
        }
        return (participateVenuesActivitieyMapper.updateByPrimaryKeySelective(participateVenuesActivitiey)>0)?true:false;

    }

    public ParticipateVenuesActivitiey findbyid(Integer participateVenuesActivieyId) {
        return participateVenuesActivitieyMapper.selectByPrimaryKey(participateVenuesActivieyId);
    }

    public PageInfo<ParticipateVenuesActivitiey> allinfoweb(ParticipateVenuesActivitiey participateVenuesActivitiey, Integer pageNo, Integer pageSize, List<Integer> userids, User user,String order, String sort) {
        ParticipateVenuesActivitieyExample participateVenuesActivitieyExample=new ParticipateVenuesActivitieyExample();
        ParticipateVenuesActivitieyExample.Criteria criteria=participateVenuesActivitieyExample.createCriteria();
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        if(userids.size()>0){
            criteria.andUseridIn(userids);
        }else if(userids.size()==0){
            if(user.getPhone()!=null||user.getUserEmail()!=null){
                if(user.getPhone().length()>0||user.getUserEmail().length()>0){
                    criteria.andUseridEqualTo(0);
                }
            }
        }

        if(participateVenuesActivitiey.getVenuesid()!=null){
            criteria.andVenuesidEqualTo(participateVenuesActivitiey.getVenuesid());
        }
        if(participateVenuesActivitiey.getUserState()!=null){
            criteria.andUserStateEqualTo(participateVenuesActivitiey.getUserState());
        }
        if(participateVenuesActivitiey.getPaymentState()!=null){
            criteria.andPaymentStateEqualTo(participateVenuesActivitiey.getPaymentState());
        }
        if(order!=null&&sort!=null){
            participateVenuesActivitieyExample.setOrderByClause(sort+" "+order);
        }
        PageInfo<ParticipateVenuesActivitiey> participateVenuesActivitieyPageInfo
                =new PageInfo<ParticipateVenuesActivitiey>(participateVenuesActivitieyMapper.selectByExample(participateVenuesActivitieyExample));
        return participateVenuesActivitieyPageInfo;
    }

    public boolean comment(ParticipateVenuesActivitiey participateVenuesActivitiey) {
         return (participateVenuesActivitieyMapper.updateByPrimaryKeySelective(participateVenuesActivitiey)>0)?true:false;
    }
}
