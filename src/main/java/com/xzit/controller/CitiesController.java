package com.xzit.controller;

import com.xzit.entity.Cities;
import com.xzit.service.CitiesService;
import com.xzit.utils.Log4jUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by huang on 2018/1/3.
 */
@Controller
public class CitiesController {
    static Class city=CitiesController.class;
    @Autowired
    private CitiesService citiesService;
    @RequestMapping(value = "/venues/querycityByprovince.action")
    @ResponseBody
    public List queryall(Integer provinceid){
        List<Cities> cities=citiesService.queryByProvinces(provinceid);
        Log4jUtils.showinfo(cities);
        return cities;
    }
}
