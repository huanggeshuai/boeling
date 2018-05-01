package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.UserBank;

/**
 * Created by huang on 2018/4/22.
 */
public interface UserBankService {
    PageInfo<UserBank> allinfo( UserBank userBank,Integer pageNo, Integer pageSize);
    boolean addUserBank(UserBank userBank);
}
