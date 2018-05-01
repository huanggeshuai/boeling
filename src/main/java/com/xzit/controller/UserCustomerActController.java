package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.User;
import com.xzit.entity.UserCustomActivity;
import com.xzit.service.UserService;
import com.xzit.service.UsercustomactivityService;
import com.xzit.utils.DataGrid;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by huang on 2018/4/30.
 */
@Controller
@RequestMapping(value = "/usercustomer")
public class UserCustomerActController {
    @Autowired
    UsercustomactivityService usercustomactivityService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/allinfoweb.action")
    @ResponseBody
    public DataGrid<UserCustomActivity> allinfo(Integer page, Integer rows,UserCustomActivity userCustomActivity,String order, String sort,User user){
        List<Integer> userids=userService.findidbyEmail(user);
        PageInfo<UserCustomActivity> userCustomActivityPageInfo=usercustomactivityService.allinfoweb(userCustomActivity,page,rows,order,sort,userids,user);
        DataGrid<UserCustomActivity> customActivityDataGrid=new DataGrid<UserCustomActivity>();
        customActivityDataGrid.setRows(userCustomActivityPageInfo.getList());
        customActivityDataGrid.setTotal(userCustomActivityPageInfo.getTotal());
        return customActivityDataGrid;
    }
    @RequestMapping(value = "/findusercustomerAct.action")
    public String findusercustomerAct(){
        return "web/usercustomer/usercustomer";
    }
    @RequestMapping(value = "/findimage.action")
    public String findimage(Integer userCustomActivityId,HttpServletRequest request){
        UserCustomActivity userCustomActivity=usercustomactivityService.findbyid(userCustomActivityId);
        request.setAttribute("userCustomActivity",userCustomActivity);
        return "web/usercustomer/image";
    }
    @RequestMapping(value = "/findauditingjsp.action")
    public String findauditingjsp(Integer userCustomActivityId,HttpServletRequest request){
        UserCustomActivity userCustomActivity=usercustomactivityService.findbyid(userCustomActivityId);
        request.setAttribute("userCustomActivityauditing",userCustomActivity);
        return "web/usercustomer/audit";
    }
    @RequestMapping(value = "/auditact.action")
    public void auditact(UserCustomActivity userCustomActivity, HttpServletResponse response){
       if(usercustomactivityService.edit(userCustomActivity)){
           WriteJson.printJson(response, JsonMapUtils.Success_Map("审核成功"));
       }else {
           WriteJson.printJson(response, JsonMapUtils.Fail_Map("审核失败"));
       }
    }
}
