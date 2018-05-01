package com.xzit.controller.mobile;

import com.xzit.entity.Orders;
import com.xzit.entity.User;
import com.xzit.service.OrderService;
import com.xzit.service.UserService;
import com.xzit.utils.Constant;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * Created by huang on 2018/4/24.
 */
@Controller
@RequestMapping(value = "/mobilepay")
public class MobilePayController {
@Autowired
    UserService userService;
@Autowired
OrderService orderService;
@RequestMapping(value = "/pay.action")
public void Recharge(User user,Orders orders,HttpServletResponse response){
    String med="";
    if(orders.getMedium()== Constant.Medium.account.key){
        med="积分";
    }else if(orders.getMedium()== Constant.Medium.card.key){
        med="银行";
    }else if(orders.getMedium()== Constant.Medium.platform.key){
        med="平台";
    }else if(orders.getMedium()== Constant.Medium.cancel.key){
        med="退款";
    }
    String income="";
    if(orders.getIncomeState()==Constant.Order.outcome.key){
        income="支出";
    }else if(orders.getIncomeState()==Constant.Order.income.key){
        income="收入";
    }
    if(orders.getIncomeUserId()==null){
        orders.setIncomeUserId(3);
    }
    BigDecimal fromMobilebigDecimal=user.getUserBalance();
    BigDecimal fromDatabast=userService.finduserbyuid(user.getUserid()).getUserBalance();
    user.setUserBalance(fromDatabast.add(fromMobilebigDecimal.multiply(new BigDecimal(orders.getIncomeState()))));
    User Incomeuser=userService.finduserbyuid(orders.getIncomeUserId());
    BigDecimal fromdatabaseincome=Incomeuser.getUserBalance();

    Incomeuser.setUserBalance(fromdatabaseincome.add(fromMobilebigDecimal.multiply(new BigDecimal(orders.getIncomeState()).multiply(new BigDecimal(-1)))));
    User user1 =new User();
    user1.setUserid(orders.getIncomeUserId());
    user1.setUserBalance(Incomeuser.getUserBalance());
    if(userService.charge(user)&&userService.charge(user1)){
        WriteJson.printJson(response, JsonMapUtils.Success_Map("充值成功"));
        orders.setMoney(fromMobilebigDecimal);
        if(orders.getMedium()==Constant.Medium.card.key){
            orders.setCause(userService.finduserbyuid(user.getUserid()).getUserTruename()+"通过充值"+
                    "收入"+orders.getMoney()+"积分");
        }else {
            orders.setCause(userService.finduserbyuid(user.getUserid()).getUserTruename()+"通过"+med+
                    income+orders.getMoney());
        }
        orderService.addorder(orders);
        Orders order1=new Orders();
        order1.setUserid(orders.getIncomeUserId());
        order1.setIncomeUserId(user.getUserid());
        order1.setMoney(orders.getMoney());
        if(orders.getIncomeState()==Constant.Order.outcome.key){
            order1.setIncomeState(Constant.Order.income.key);
        }else if(orders.getIncomeState()==Constant.Order.income.key){
            order1.setIncomeState(Constant.Order.outcome.key);
        }
        if(orders.getIncomeState()==Constant.Order.outcome.key){
            income="收入";
        }else if(orders.getIncomeState()==Constant.Order.income.key){
            income="支出";
        }
        order1.setMedium(orders.getMedium());
        if(orders.getMedium()==Constant.Medium.card.key){
            order1.setCause(userService.finduserbyuid(order1.getUserid()).getUserTruename()+"通过支出"+
                    income+orders.getMoney()+"积分"+"给用户"+userService.finduserbyuid(orders.getUserid()).getUserTruename()+"充值");
        }else {

            order1.setCause(userService.finduserbyuid(order1.getUserid()).getUserTruename()+"通过"+med+
                    income+orders.getMoney());
        }

        orderService.addorder(order1);
    }else {
        WriteJson.printJson(response,JsonMapUtils.Fail_Map("充值失败"));
    }

}
}
