package com.xzit.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.ParticipateVenuesActivitiey;
import com.xzit.service.ParticipateVenuesActivitieyService;
import com.xzit.utils.DataGrid;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by huang on 2018/4/20.
 */
@Controller
@RequestMapping(value = "/join")
public class MobileJoinVenuesActivityController {
    @Autowired
    ParticipateVenuesActivitieyService participateVenuesActivitieyService;
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
    public DataGrid<ParticipateVenuesActivitiey> info(ParticipateVenuesActivitiey participateVenuesActivitiey,Integer page, Integer rows){
        PageInfo<ParticipateVenuesActivitiey> pageInfo=participateVenuesActivitieyService.allinfo(participateVenuesActivitiey,page,rows);
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
    @RequestMapping(value = "/comment.action")
    public void comment(ParticipateVenuesActivitiey participateVenuesActivitiey, HttpServletResponse response){
        if(participateVenuesActivitieyService.comment(participateVenuesActivitiey)) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("修改成功"));
        }else{
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("修改失败"));
        }
    }
}
