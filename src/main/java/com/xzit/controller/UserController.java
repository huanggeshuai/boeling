package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Menu;

import com.xzit.entity.Orders;
import com.xzit.entity.User;
import com.xzit.service.OrderService;
import com.xzit.service.UserService;
import com.xzit.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * Created by huang on 2018/3/31.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @RequestMapping("/showalluser.action")
    @ResponseBody
    public DataGrid<User> alluserinfo(User user,Integer page, Integer rows,String order,String sort){
        PageInfo<User> pageInfo=userService.alluser(user, page, rows,order,sort);
        DataGrid<User> userDataGrid=new DataGrid<User>();
        userDataGrid.setTotal(pageInfo.getTotal());
        userDataGrid.setRows(pageInfo.getList());
        Log4jUtils.showinfo(userDataGrid);
        return userDataGrid;
    }
    @RequestMapping("/showuserjsp.action")
    public String showuserjsp(){
        return "web/user/user";
    }
    @RequestMapping("/showadduserjsp.action")
    public String showadduserjsp(){
        return "web/user/adduser";
    }
    @RequestMapping("/adduser.action")
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
    @RequestMapping("/edituser.action")
    @ResponseBody
    public void edituser(HttpServletResponse response,User user){
        boolean flag=false;
        flag=userService.edituser(user);
        if(flag){
            WriteJson.printJson(response, JsonMapUtils.Success_Map("更新成功"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("更新失败"));
        }
    }
    @RequestMapping("/findedituser.action")
    public String findaddmenu(Integer userid, HttpServletRequest request)  {
        User user =userService.finduserbyuid(userid);
        request.setAttribute("user",user);
        return "web/user/edituser";
    }
    @RequestMapping("/deluser.action")
    @ResponseBody
    public void deluser(HttpServletResponse response,User user){
        boolean flag=false;
        User user1=userService.finduserbyuid(user.getUserid());
        if((user1.getUserBalance().compareTo(BigDecimal.ZERO))>0){
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("账户还有余额，不能注销"));
        }else {
            flag=userService.deleteuser(user);
            if(flag){
                WriteJson.printJson(response, JsonMapUtils.Success_Map("账户注销成功"));
            }else {
                WriteJson.printJson(response,JsonMapUtils.Fail_Map("账户注销失败"));
            }
        }

    }
    @RequestMapping("/emailisonly.action")
    @ResponseBody
    public void emailisonly(HttpServletResponse response,String userEmail){
        boolean flag=false;
        flag=userService.emailisonly(userEmail);
        if(flag){
            WriteJson.printJson(response,JsonMapUtils.Success_Map("可以填写"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("该email已被注册，请重新更换"));
        }
    }
    @RequestMapping("/verifypassword.action")
    @ResponseBody
    public void verifypassword(HttpServletResponse response,User user){
        boolean flag=false;
        flag=userService.VerifyPassword(user);
        if(flag){
            WriteJson.printJson(response,JsonMapUtils.Success_Map("密码正确"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("密码错误"));
        }
    }
    @RequestMapping("/findpassworduser.action")
    public String findpassword(Integer userid, HttpServletRequest request)  {
        User user =userService.finduserbyuid(userid);
        request.setAttribute("user",user);
        return "web/user/editpassword";
    }
    @RequestMapping("/charge.action")
    @ResponseBody
    public void charge(HttpServletResponse response, User user, Orders order){
        if(order.getIncomeUserId()==null){
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("请刷新页面在重试"));
        }else {
            int outcomeUserId=order.getIncomeUserId();  //支出者
            int income=user.getUserid();
            boolean flag=false;
            BigDecimal count=user.getUserBalance();
            User user2= userService.finduserbyuid(user.getUserid());
            user.setUserBalance(user2.getUserBalance().add(user.getUserBalance()));
            flag=userService.edituser(user);
            if(flag){
                WriteJson.printJson(response,JsonMapUtils.Success_Map("充值成功"));
                order.setMoney(count);
                order.setIncomeState(Constant.Order.income.key);
                order.setCause(outcomeUserId+"通过平台向"+income+"充值:"+count);
                order.setMedium(Constant.Medium.platform.key);
                orderService.addorder(order);
                Orders order1=new Orders();
                order1.setUserid(outcomeUserId);
                order1.setIncomeUserId(income);
                order1.setMoney(count);
                order1.setIncomeState(Constant.Order.outcome.key);
                order1.setCause(outcomeUserId+"通过平台向"+income+"充值:"+count);
                order1.setMedium(Constant.Medium.platform.key);
                orderService.addorder(order1);
            }else {
                WriteJson.printJson(response,JsonMapUtils.Fail_Map("充值失败"));
            }
        }

    }
    @RequestMapping("/findcharge.action")
    public String charge(Integer userid, HttpServletRequest request)  {
        User user =userService.finduserbyuid(userid);
        request.setAttribute("user",user);
        return "web/user/charge";
    }


    @RequestMapping("/phoneisonly.action")
    @ResponseBody
    public void phoneisonly(HttpServletResponse response,String phone){
        boolean flag=false;
        flag=userService.phoneisonly(phone);
        if(flag){
            WriteJson.printJson(response,JsonMapUtils.Success_Map("可以填写"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("该phone已被注册，请重新更换"));
        }
    }
}
