package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Collections;
import com.xzit.service.CollectionService;
import com.xzit.service.VenuesService;
import com.xzit.utils.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huang on 2018/4/16.
 */
@Controller
public class CollectionController {
    @Autowired
    CollectionService collectionService;
    @Autowired
    VenuesService venuesService;
    @RequestMapping(value = "/collectioninfo.action")
    @ResponseBody
    public DataGrid<Collections> allinfo(Integer page, Integer rows,Collections collections,String City) {
        PageInfo<Collections> collectionsPageInfo=collectionService.allinfo(page,rows,collections,venuesService.getVenuesid(City));
        DataGrid<Collections> collectionsDataGrid=new DataGrid<Collections>();
        collectionsDataGrid.setTotal(collectionsPageInfo.getTotal());
        collectionsDataGrid.setRows(collectionsPageInfo.getList());
        return  collectionsDataGrid;
    }
}

