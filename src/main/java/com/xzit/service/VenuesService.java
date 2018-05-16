package com.xzit.service;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Venues;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
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
    XSSFWorkbook exportvenuesInfo(Venues venues) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

}
