package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Orders;
import com.xzit.service.OrderService;
import com.xzit.utils.DataGrid;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2018/4/10.
 */
@Controller
@RequestMapping(value = "/orders")
public class OrdersController {
    Integer uid;
    private Orders orders;
    @Autowired
    OrderService orderService;
    @RequestMapping(value = "/showallorderinfo.action")
    @ResponseBody
    public DataGrid<Orders> allinfo(Orders orders,Integer page, Integer rows,String order,String sort){
       if(orders.getUserid()==null){
           orders.setUserid(uid);
       }
       this.orders=orders;
        PageInfo<Orders> ordersPageInfo=orderService.allinfo(orders,page,rows,order,sort);
        DataGrid<Orders> dataGrid=new DataGrid<Orders>();
        dataGrid.setRows(ordersPageInfo.getList());
        dataGrid.setTotal(ordersPageInfo.getTotal());
        return dataGrid;
    }
    @RequestMapping(value = "findorderjsp.action")
    public String findjsp(Integer userid) {
        uid = userid;
        return "web/orders/orders";
    }
    @RequestMapping("/exportvenuesinfo.action")
    @ResponseBody
    public  void exportvenues(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, UnsupportedEncodingException {
        String excelname = "支付信息.xlsx";
        if(excelname!=""){
            response.reset(); //清除buffer缓存
            Map<String,Object> map=new HashMap<String,Object>();
            // 指定下载的文件名
            //response.setHeader("Content-Disposition", "attachment;filename=用户信息.xlsx");
            response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(excelname, "utf-8"));
            //response.setHeader("Content-Disposition", "attachment;filename="+salaryDate+".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            XSSFWorkbook workbook=null;
            //导出Excel对象
            workbook = orderService.exportpayInfo(orders);
            OutputStream output;
            try {
                output = response.getOutputStream();
                BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
                bufferedOutPut.flush();
                workbook.write(bufferedOutPut);
                bufferedOutPut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
