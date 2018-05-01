package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.User;
import com.xzit.entity.UserCustomActivity;

import java.util.List;

/**
 * Created by huang on 2018/4/27.
 */
public interface UsercustomactivityService {
    int add(UserCustomActivity userCustomActivity);
    boolean edit(UserCustomActivity userCustomActivity);
    PageInfo<UserCustomActivity> allinfo(UserCustomActivity userCustomActivity,Integer pageNo, Integer pageSize);
    PageInfo<UserCustomActivity> allinfoweb(UserCustomActivity userCustomActivity, Integer pageNo, Integer pageSize, String order, String sort, List<Integer> userid, User user);
    UserCustomActivity findbyid(Integer userCustomActivityId);
}
