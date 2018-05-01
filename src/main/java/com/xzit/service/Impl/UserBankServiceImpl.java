package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.UserBank;
import com.xzit.entity.UserBankExample;
import com.xzit.mapper.UserBankMapper;
import com.xzit.service.UserBankService;
import com.xzit.utils.Dateutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huang on 2018/4/22.
 */
@Service
public class UserBankServiceImpl implements UserBankService {
    @Autowired
    UserBankMapper userBankMapper;
    public PageInfo<UserBank> allinfo(UserBank userBank, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        UserBankExample userBankExample=new UserBankExample();
        UserBankExample.Criteria criteria=userBankExample.createCriteria();
        criteria.andUserIdEqualTo(userBank.getUserId());
        PageInfo<UserBank> pageInfo=new PageInfo<UserBank>(userBankMapper.selectByExample(userBankExample));
        return pageInfo;
    }

    public boolean addUserBank(UserBank userBank) {
        userBank.setAddtime(Dateutils.getDate());

        return (userBankMapper.insertSelective(userBank)>0)?true:false;
    }
}
