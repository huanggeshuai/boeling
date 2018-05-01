package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.ParticipateActivitiesUser;

/**
 * Created by huang on 2018/5/1.
 */
public interface ParticipateActivitiesUserService {
    int add(ParticipateActivitiesUser participateActivitiesUser);
    boolean edit(ParticipateActivitiesUser participateActivitiesUser);
    PageInfo<ParticipateActivitiesUser> allinfo(ParticipateActivitiesUser participateActivitiesUser, Integer pageNo, Integer pageSize);
}
