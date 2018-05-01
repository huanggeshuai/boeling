package com.xzit.controller;

import com.xzit.service.SendMailService;
import com.xzit.service.UserService;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.VerifyCode;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huang on 2018/4/12.
 */
@Controller
public class SendEmailController {
    @Resource
   private SendMailService sendMailService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/send.action")

    public void Send(String tomail, HttpServletResponse response){
        if(userService.emailisonly(tomail)){
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("该邮箱没有注册"));
        }else {
            String subject="这是一封找回密码的邮件";
            String content="尊敬的用户,您好，这是找回密码的验证码:";
            String verify= VerifyCode.getNum();
            content=content+verify;
            sendMailService.sendSimpleMail(subject,content,tomail);
            WriteJson.printJson(response,JsonMapUtils.Success_Map(verify));
        }
    }
}
