package com.xzit.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.xzit.entity.User;
import com.xzit.service.UserService;
import com.xzit.utils.Constant;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by huang on 2018/4/11.
 */
@Controller
public class MobileController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/mobilelogin.action")
    @ResponseBody
    public void userlogin(User user, HttpServletResponse response, HttpSession session){
        User user1=userService.login(user);
   if (user1==null){
       WriteJson.printJson(response,JsonMapUtils.Fail_Map("用户名或者密码错误"));
   }else {
       if(user1.getUserState()== Constant.UserState.isdel.key){
           WriteJson.printJson(response,JsonMapUtils.Fail_Map("该用户被禁用"));
       }else if(user1.getDeletestate()== Constant.Del.isdel.key){
           WriteJson.printJson(response,JsonMapUtils.Fail_Map("该用户被删除"));
       }else {
           userService.updateLogintimeandlogincount(user1);
           session.setAttribute("mobile",user1);
           WriteJson.printJson(response,JsonMapUtils.Success_Map(JSON.toJSONString(user1)));
       }
   }
    }
    @RequestMapping("/mobileadduser.action")
    @ResponseBody
    public void adduser(HttpServletResponse response,User user){
        boolean flag=false;
        flag=userService.adduser(user);
        if(flag){
            WriteJson.printJson(response, JsonMapUtils.Success_Map("添加成功"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("添加失败"));
        }
    }
    @RequestMapping("/changepassword.action")
    @ResponseBody
    public void changepassword(HttpServletResponse response,User user){
        boolean flag=false;
        flag=userService.changePassword(user);
        if(flag){
            WriteJson.printJson(response, JsonMapUtils.Success_Map("密码修改成功"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("密码修改失败"));
        }
    }

    @RequestMapping("/mobilefinduserinfo.action")
    public void GetUserinfobyid(Integer userid, HttpServletResponse response)  {
        User user =userService.finduserbyuid(userid);
       // request.setAttribute("user",user);
       // return "web/user/charge";
        WriteJson.printJson(response,JsonMapUtils.Success_Map(JSON.toJSONString(user)));
    }
}
