package com.xzit.controller;

import com.xzit.entity.User;
import com.xzit.service.UserService;
import com.xzit.utils.Constant;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by huang on 2018/3/30.
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/findmain.action")
    public String index() {
        return "web/index";
    }

    @RequestMapping("/findmap.action")
    public String map() {
        return "web/map";
    }

    @RequestMapping("/findloginjsp.action")
    public String loginjsp() {
        return "web/login";
    }

    @RequestMapping("/login.action")
    public void Login(User user, HttpServletResponse response, HttpSession session) {
        User user1 = new User();
        if (user.getUserEmail() == null || user.getUserPassword() == null) {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("用户名或密码不能为空"));
        } else if ((user1 = userService.login(user)) == null) {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("用户名或密码错误"));
        } else if (user1.getDeletestate() == Constant.Del.isdel.getKey()) {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("该用户被注销"));
        } else if (user1.getDeletestate() == Constant.Del.nodel.getKey() && user1.getUserAuthority() == Constant.Authority.Admin.getKey()) {
            userService.updateLogintimeandlogincount(user1);
            session.setAttribute("admin", user1);

            WriteJson.printJson(response, JsonMapUtils.Success_Map("登陆成功"));
        } else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("权限不正确"));

        }
    }

    @RequestMapping("/loginout.action")
    public String loginout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);//防止创建Session
        if (session == null) {

            return "redirect:findloginjsp.action";
        }
        session.removeAttribute("admin");
        return "redirect:findloginjsp.action";
    }

}