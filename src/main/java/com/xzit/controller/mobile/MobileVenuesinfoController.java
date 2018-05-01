package com.xzit.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.Collections;
import com.xzit.service.CollectionService;
import com.xzit.service.VenuesService;
import com.xzit.utils.DataGrid;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by huang on 2018/4/16.
 */
@Controller
@RequestMapping(value = "/mobile")
public class MobileVenuesinfoController {
    @Autowired
    CollectionService collectionService;
    @Autowired
    VenuesService venuesService;

    @RequestMapping(value = "/collectioninfo.action")
    @ResponseBody
    public DataGrid<Collections> allinfo(Integer page, Integer rows, Collections collections,String City) {

        PageInfo<Collections> collectionsPageInfo=collectionService.allinfo(page,rows,collections,venuesService.getVenuesid(City));
        DataGrid<Collections> collectionsDataGrid=new DataGrid<Collections>();
        collectionsDataGrid.setTotal(collectionsPageInfo.getTotal());
        collectionsDataGrid.setRows(collectionsPageInfo.getList());
        return  collectionsDataGrid;
    }
    @RequestMapping(value = "/collectio.action")
    @ResponseBody
    public void Collection(Collections collections, HttpServletResponse response){
        if(collectionService.update(collections)){
            WriteJson.printJson(response, JsonMapUtils.Success_Map("添加成功"));
        }else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("添加失败"));
        }
    }
    @RequestMapping(value = "/getcollectio.action")
    @ResponseBody
    public void GetCollection(Collections collections, HttpServletResponse response){
        WriteJson.printJson(response, JsonMapUtils.Success_Map(JSON.toJSONString(collectionService.findbyid(collections))));
    }
}
