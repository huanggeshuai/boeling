package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.ParticipateActivitiesUser;
import com.xzit.entity.ParticipateActivitiesUserExample;
import com.xzit.mapper.ParticipateActivitiesUserMapper;
import com.xzit.service.ParticipateActivitiesUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by huang on 2018/5/1.
 */
@Service
public class ParticipateActivitiesUserServiceImpl implements ParticipateActivitiesUserService {
    @Autowired
    ParticipateActivitiesUserMapper participateActivitiesUserMapper;
    public int add(ParticipateActivitiesUser participateActivitiesUser) {
        participateActivitiesUser.setTime(new Date());
        int num=participateActivitiesUserMapper.insertSelective(participateActivitiesUser);
        int id=participateActivitiesUser.getParticipateActivitiesIdUser();
        return id;
    }

    public boolean edit(ParticipateActivitiesUser participateActivitiesUser) {
        if(participateActivitiesUser.getPaymentState()!=null){
            if(participateActivitiesUser.getPaymentState()==1){
                participateActivitiesUser.setOrdertime(new Date());
            }
        }
        return (participateActivitiesUserMapper.updateByPrimaryKeySelective(participateActivitiesUser)>0?true:false);
    }

    public PageInfo<ParticipateActivitiesUser> allinfo(ParticipateActivitiesUser participateActivitiesUser, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        ParticipateActivitiesUserExample userExample=new ParticipateActivitiesUserExample();
        ParticipateActivitiesUserExample.Criteria criteria=userExample.createCriteria();
        if(participateActivitiesUser.getUserid()!=null){
            criteria.andUseridEqualTo(participateActivitiesUser.getUserid());
        }
        return new PageInfo<ParticipateActivitiesUser>(participateActivitiesUserMapper.selectByExample(userExample));
    }
}
