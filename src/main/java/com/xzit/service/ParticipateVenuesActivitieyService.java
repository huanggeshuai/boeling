package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.ParticipateVenuesActivitiey;
import com.xzit.entity.User;

import java.util.List;

/**
 * Created by huang on 2018/4/20.
 */
public interface ParticipateVenuesActivitieyService {
    boolean editOrdertime(ParticipateVenuesActivitiey participateVenuesActivitiey);
    int add(ParticipateVenuesActivitiey participateVenuesActivitiey);
    PageInfo<ParticipateVenuesActivitiey> allinfo(ParticipateVenuesActivitiey participateVenuesActivitiey,Integer pageNo, Integer pageSize);
    boolean editFinishtime(ParticipateVenuesActivitiey participateVenuesActivitiey);
    ParticipateVenuesActivitiey findbyid(Integer participateVenuesActivieyId);
    PageInfo<ParticipateVenuesActivitiey> allinfoweb(ParticipateVenuesActivitiey participateVenuesActivitiey, Integer pageNo, Integer pageSize, List<Integer> userids, User user,String order, String sort);
    boolean comment(ParticipateVenuesActivitiey participateVenuesActivitiey);
}
