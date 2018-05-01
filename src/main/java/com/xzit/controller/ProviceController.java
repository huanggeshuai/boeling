package com.xzit.controller;

import com.xzit.entity.Provinces;
import com.xzit.service.ProvinceService;
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
public class ProviceController {
    static  Class prov=ProviceController.class;
    @Autowired
    private ProvinceService provinceService;
     @RequestMapping(value = "/venues/provinceQueryall.action")
     @ResponseBody
    public List queryall(){
         List<Provinces> provinces=provinceService.queryall();
         Log4jUtils.showinfo(provinces);
        return provinces;
    }
}
