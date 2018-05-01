package com.xzit.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.ParticipateActivitiesUser;
import com.xzit.entity.UserCustomActivity;
import com.xzit.service.ParticipateActivitiesUserService;
import com.xzit.service.UsercustomactivityService;
import com.xzit.utils.DataGrid;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by huang on 2018/5/1.
 */
@Controller
@RequestMapping(value = "/mobileparticipateuser")
public class MobileParticipateUserController {
    @Autowired
    ParticipateActivitiesUserService service;
    @Autowired
    UsercustomactivityService usercustomactivityService;
    @RequestMapping(value = "addparticipate.action")
    public void Add(ParticipateActivitiesUser participateActivitiesUser, HttpServletResponse response){
        int id=service.add(participateActivitiesUser);
        if(id>0){
            WriteJson.printJson(response, JsonMapUtils.Success_Map(id));
        }else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("预约失败"));
        }
    }
    @RequestMapping(value = "editparticipate.action")
    public void edit(ParticipateActivitiesUser participateActivitiesUser, HttpServletResponse response){
        boolean id=service.edit(participateActivitiesUser);
        if(id){
            UserCustomActivity userCustomActivity=new UserCustomActivity();
            userCustomActivity.setUserCustomActivityId(participateActivitiesUser.getUserCustomActivityId());
            UserCustomActivity userCustomActivity1=usercustomactivityService.findbyid(participateActivitiesUser.getUserCustomActivityId());
            userCustomActivity.setEnlistnum(userCustomActivity1.getEnlistnum()+participateActivitiesUser.getTotalnum());
            usercustomactivityService.edit(userCustomActivity);
            WriteJson.printJson(response, JsonMapUtils.Success_Map("预约成功"));
        }else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("修改失败"));
        }
    }
    @RequestMapping(value = "allinfo.action")
    @ResponseBody
    public DataGrid allinfo(ParticipateActivitiesUser participateActivitiesUser, Integer page, Integer rows){
        PageInfo<ParticipateActivitiesUser> participateActivitiesUserPageInfo=service.allinfo(participateActivitiesUser,page,rows);
        DataGrid<ParticipateActivitiesUser> dataGrid=new DataGrid<ParticipateActivitiesUser>();
        dataGrid.setTotal(participateActivitiesUserPageInfo.getTotal());
        dataGrid.setRows(participateActivitiesUserPageInfo.getList());
        return dataGrid;
    }
}
