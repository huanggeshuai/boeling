package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Venues;

import java.util.List;

/**
 * Created by huang on 2018/4/3.
 */
public interface VenuesService {
    PageInfo<Venues> alluser(Venues venues, Integer pageNo, Integer pageSize, String order, String sort,Integer image);
    boolean addVenues(Venues venues);
    boolean editVenues(Venues venues);
    Venues findbyid(Integer venuesid);
    List<Venues> venues();
    boolean cancel(Venues venues);
    boolean reover(Venues venues);
    List<Integer> getVenuesid(String province);
}
