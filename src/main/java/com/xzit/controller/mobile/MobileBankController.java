package com.xzit.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.UserBank;
import com.xzit.service.UserBankService;
import com.xzit.utils.DataGrid;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by huang on 2018/4/22.
 */
@Controller
@RequestMapping(value = "/mobilebank")
public class MobileBankController {
    @Autowired
    UserBankService userBankService;
    @RequestMapping(value = "/showinfo.action")
    @ResponseBody
    public DataGrid<UserBank> shoeinfo(UserBank userBank,Integer page, Integer rows){
        PageInfo<UserBank> userBankPageInfo=userBankService.allinfo(userBank,page,rows);
        DataGrid<UserBank> userBankDataGrid=new DataGrid<UserBank>();
        userBankDataGrid.setTotal(userBankPageInfo.getTotal());
        userBankDataGrid.setRows(userBankPageInfo.getList());
        return userBankDataGrid;
    }
    @RequestMapping(value = "/addbank.action")
    public void addBank(UserBank userBank, HttpServletResponse response){
     if(userBankService.addUserBank(userBank)){
         WriteJson.printJson(response, JsonMapUtils.Success_Map("添加成功"));
     }else {
         WriteJson.printJson(response, JsonMapUtils.Fail_Map("失败成功"));
     }
    }

}
