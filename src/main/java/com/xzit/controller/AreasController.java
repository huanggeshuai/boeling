package com.xzit.controller;

import com.xzit.entity.Areas;
import com.xzit.service.AreasService;
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
public class AreasController {
  static Class name=AreasController.class;
    @Autowired
    AreasService areasService;
    @RequestMapping(value = "/venues/queryareaBycities.action")
    @ResponseBody
    public List queryall(Integer cityid){
        List<Areas> areas=areasService.queryByCityid(cityid);
        Log4jUtils.showinfo(areas);
        return areas;
    }
}
