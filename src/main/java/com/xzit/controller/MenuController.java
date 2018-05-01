package com.xzit.controller;

import com.alibaba.fastjson.JSON;
import com.xzit.entity.Menu;
import com.xzit.service.MenuService;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.Log4jUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2018/3/28.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/rootmenu.action")
    @ResponseBody
    public List<Menu> RootMenu(HttpServletResponse response) {
        List<Menu> menus = menuService.kookforRootMenu();
        Log4jUtils.showinfo(menus + "传值");
        WriteJson.printJson(response, menus);
        return menus;
    }

    @RequestMapping("/lookmenu.action")
    @ResponseBody
    public List<Menu> LookMenu(HttpServletResponse response, Integer pid) {
        List<Menu> menus = menuService.kookforChildMenu(pid);
        Log4jUtils.showinfo(menus + "传值");
        WriteJson.printJson(response, menus);
        return menus;
    }

    @RequestMapping("/addmenu.action")
    @ResponseBody
    public void addMenu(HttpServletResponse response, Menu menu) {
        boolean flag = false;
        if (menuService.addMenu(menu)) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("添加成功"));


        } else
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("添加失败"));
    }

    @RequestMapping("/delmenu.action")
    @ResponseBody
    public void delMenu(HttpServletResponse response, Integer[] mids) {
        int num = 0;
        if ((num = menuService.deleteMenu(mids)) > 0) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("您删除了" + num + "数据"));


        } else
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("删除失败"));
    }

    @RequestMapping("/allmenu.action")
    public void allMenu(HttpServletResponse response) throws IOException {
        int num = 0;
        String json;
        json = JSON.toJSONString(menuService.menus());
     //   String test="\"children\": [],";
    //  test=  test.replace("\"children\": [],","");
       //String json1=json.replace("\"children\":[],","");

        PrintWriter out = null;
        out=response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        out.print(json);
        out.close();
        Log4jUtils.showinfo(json);
        //  WriteJson.printJson(response,menuService.allmenu());
       // return menuService.allmenu();
    }
    //该方法谨慎能使用  删除节点
    @RequestMapping("/delnode.action")
    public void del(HttpServletResponse response,Integer id) throws IOException {
    Menu menu=menuService.allmenu(id);
    List<Integer> list=new ArrayList<Integer>();
        list.addAll(getIn(menu)) ;
        menuService.deleteMenu(list);
        Log4jUtils.showinfo(list);
        Menu menu1=menuService.allmenu(id);
        if(menu1==null){
            WriteJson.printJson(response, JsonMapUtils.Success_Map("删除目录成功"));
        }else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("删除目录失败"));
        }
    }
    List getIn(Menu menu){
        List<Integer> list=new ArrayList<Integer>();
        list.add(menu.getMid());
        if(menu.getChildren()!=null){
            for(int i=0;i<menu.getChildren().size();i++){
                list.add(menu.getChildren().get(i).getMid());
                menuService.deleteMenu(list);
                getIn(menu.getChildren().get(i));
            }
        }
      //  Log4jUtils.showinfo(list);
    return list;
    }
    @RequestMapping("/findaddmenu.action")
    public String findaddmenu(Integer mid, HttpServletRequest request)  {
        Menu menu=menuService.findbyprimyid(mid);
        request.setAttribute("menu",menu);
        return "web/menu/addmenu";
    }
    @RequestMapping("/findmenu.action")
    public String findmenu()  {
        return "web/menu/menu";
    }

    @RequestMapping("/idonly.action")
    public void idisonly(Integer id,HttpServletResponse response){
        boolean flag=false;
        flag=menuService.idisonly(id);
        if(flag){
            WriteJson.printJson(response,JsonMapUtils.Success_Map("可以填写"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("该id已存在"));
        }
    }
    @RequestMapping("/findeditmenu.action")
    public String findeditmenu(Integer mid, HttpServletRequest request)  {
        Menu menu=menuService.findbyprimyid(mid);
        request.setAttribute("menu",menu);
        return "web/menu/editmenu";
    }
    @RequestMapping("/editmenu.action")
    @ResponseBody
    public void editMenu(HttpServletResponse response, Menu menu) {
        if (menuService.editmenu(menu)) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("修改成功"));


        } else
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("修改失败"));
    }
}