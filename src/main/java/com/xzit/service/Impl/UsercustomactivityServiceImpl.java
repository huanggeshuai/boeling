package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.User;
import com.xzit.entity.UserCustomActivity;
import com.xzit.entity.UserCustomActivityExample;
import com.xzit.mapper.UserCustomActivityMapper;
import com.xzit.service.UsercustomactivityService;
import com.xzit.utils.EntityToColum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by huang on 2018/4/27.
 */
@Service
public class UsercustomactivityServiceImpl implements UsercustomactivityService {
    @Autowired
    UserCustomActivityMapper userCustomActivityMapper;
    public int add(UserCustomActivity userCustomActivity) {
        userCustomActivity.setActivitiesSettingTime(new Date());
        int num= userCustomActivityMapper.insertSelective(userCustomActivity);
        int id=userCustomActivity.getUserCustomActivityId();
        return id;
    }

    public boolean edit(UserCustomActivity userCustomActivity) {
        if(userCustomActivity.getAuditing()!=null){
            if(userCustomActivity.getAuditing()==1){
                userCustomActivity.setCreatetime(new Date());
            }
        }

          return (userCustomActivityMapper.updateByPrimaryKeySelective(userCustomActivity)>0?true:false);
    }

    public PageInfo<UserCustomActivity> allinfo(UserCustomActivity userCustomActivity,Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        UserCustomActivityExample userCustomActivityExample=new UserCustomActivityExample();
        UserCustomActivityExample.Criteria criteria=userCustomActivityExample.createCriteria();
        criteria.andAuditingEqualTo(1);
        PageInfo<UserCustomActivity> pageInfo=new PageInfo<UserCustomActivity>(userCustomActivityMapper.selectByExampleWithBLOBs(userCustomActivityExample));
        return pageInfo;
    }

    public PageInfo<UserCustomActivity> allinfoweb(UserCustomActivity userCustomActivity, Integer pageNo, Integer pageSize, String order, String sort, List<Integer> userids, User user) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        UserCustomActivityExample userCustomActivityExample=new UserCustomActivityExample();
        UserCustomActivityExample.Criteria criteria=userCustomActivityExample.createCriteria();
        if(userids.size()>0){
            criteria.andUseridIn(userids);
        }else if(userids.size()==0){
            if(user.getPhone()!=null||user.getUserEmail()!=null){
                if(user.getPhone().length()>0||user.getUserEmail().length()>0){
                    criteria.andUseridEqualTo(0);
                }
            }
        }
        if(userCustomActivity.getVenuesid()!=null){
            criteria.andVenuesidEqualTo(userCustomActivity.getVenuesid());
        }
        if(userCustomActivity.getPayState()!=null){
            criteria.andPayStateEqualTo(userCustomActivity.getPayState());
        }
        if(userCustomActivity.getAuditing()!=null){
            criteria.andAuditingEqualTo(userCustomActivity.getAuditing());
        }
        if(order!=null&&sort!=null){
            userCustomActivityExample.setOrderByClause(EntityToColum.GetUserCustomer(sort)+" "+order);
        }
        PageInfo<UserCustomActivity> pageInfo=new PageInfo<UserCustomActivity>(userCustomActivityMapper.selectByExampleWithBLOBs(userCustomActivityExample));
        return pageInfo;
    }

    public UserCustomActivity findbyid(Integer userCustomActivityId) {
        return userCustomActivityMapper.selectByPrimaryKey(userCustomActivityId);
    }
}
