package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.ParticipateVenuesActivitiey;
import com.xzit.entity.User;
import com.xzit.service.ParticipateVenuesActivitieyService;
import com.xzit.service.UserService;
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
 * Created by huang on 2018/4/20.
 */
@Controller
@RequestMapping(value = "/participatevenuesactivity")
public class ParticipateVenuesActivityController {
    @Autowired
    ParticipateVenuesActivitieyService participateVenuesActivitieyService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/joinVenuesActivity.action")
    public void JoinVenuesActivity(ParticipateVenuesActivitiey participateVenuesActivitiey, HttpServletResponse response){
          int id=participateVenuesActivitieyService.add(participateVenuesActivitiey);
        if(id>0) {
          WriteJson.printJson(response, JsonMapUtils.Success_Map(id));
      }else{
          WriteJson.printJson(response, JsonMapUtils.Fail_Map("预定失败"));
      }
    }
    @RequestMapping(value = "/editOrderVenuesActivity.action")
    public void editOrderVenuesActivity(ParticipateVenuesActivitiey participateVenuesActivitiey, HttpServletResponse response){
        if(participateVenuesActivitieyService.editOrdertime(participateVenuesActivitiey)) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("修改成功"));
        }else{
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("修改失败"));
        }
    }
    @RequestMapping(value = "/allinfoVenuesActivity.action")
    @ResponseBody
    public DataGrid<ParticipateVenuesActivitiey> info(User user, ParticipateVenuesActivitiey participateVenuesActivitiey, Integer page, Integer rows,String order, String sort){
        List<Integer> userids=userService.findidbyEmail(user);
        PageInfo<ParticipateVenuesActivitiey> pageInfo=participateVenuesActivitieyService.allinfoweb(participateVenuesActivitiey,page,rows,userids,user, order,  sort);
        DataGrid<ParticipateVenuesActivitiey> dataGrid=new DataGrid<ParticipateVenuesActivitiey>();
        dataGrid.setRows(pageInfo.getList());
        dataGrid.setTotal(pageInfo.getTotal());
        return dataGrid;
    }
    @RequestMapping(value = "/editFinishtime.action")
    public void editFinishtime(ParticipateVenuesActivitiey participateVenuesActivitiey, HttpServletResponse response){
        if(participateVenuesActivitieyService.editFinishtime(participateVenuesActivitiey)) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("修改成功"));
        }else{
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("修改失败"));
        }
    }
    @RequestMapping(value = "/findjsp.action")
    public String showinfojsp(HttpServletResponse response){
        return "web/venuesactivity/venuesactivity";
    }

    @RequestMapping(value = "/findfinishjsp.action")
    public String findfinishjsp(HttpServletRequest request,Integer participateVenuesActivieyId){
        ParticipateVenuesActivitiey participateVenuesActivitiey
                =participateVenuesActivitieyService.findbyid(participateVenuesActivieyId);
        request.setAttribute("participateVenuesActivitiey",participateVenuesActivitiey);
        return "web/venuesactivity/finish";
    }

}
