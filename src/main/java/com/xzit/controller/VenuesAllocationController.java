package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Venues;
import com.xzit.entity.VenuesAllocation;
import com.xzit.service.VenuesAllocationService;
import com.xzit.service.VenuesService;
import com.xzit.utils.DataGrid;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created by huang on 2018/4/7.
 */
@Controller
@RequestMapping(value = "/venuesallcoation")
public class VenuesAllocationController {
    @Autowired
    private VenuesAllocationService venuesAllocationService;
    @Autowired
    private VenuesService venuesService;
    Integer Venuesid;

    @RequestMapping(value = "findjspbyvenuesid.action")
    public String findjsp(Integer venuesid) {
        Venuesid = venuesid;
        return "web/venuesallcoation/venuesallcoation";
    }

    @RequestMapping(value = "venuesallocationinfo.action")
    @ResponseBody
    public DataGrid showAllinfo(VenuesAllocation venuesAllocation, Integer page, Integer rows, String order, String sort) {
        if(venuesAllocation.getVenuesid()==null){
            venuesAllocation.setVenuesid(Venuesid);
        }

        PageInfo<VenuesAllocation> pageInfo = venuesAllocationService.alluser(venuesAllocation, page, rows, order, sort);
        DataGrid<VenuesAllocation> dataGrid = new DataGrid<VenuesAllocation>();
        dataGrid.setTotal(pageInfo.getTotal());
        dataGrid.setRows(pageInfo.getList());
        return dataGrid;
    }

    @RequestMapping(value = "addvenuesallocation.action")
    @ResponseBody
    public boolean addvenuesallocation(VenuesAllocation venuesAllocation, HttpServletResponse response) {
        boolean flag = false;
       flag= venuesAllocationService.addvenuesallocation(venuesAllocation);
        if (flag) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("添加成功"));
        } else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("添加失败"));
        }
        return flag;
    }
    @RequestMapping(value = "findaddvenuesallocationjsp.action")
    public String findaddvenuesallocationjsp(HttpServletRequest request) {
        Venues venues=venuesService.findbyid(Venuesid);
        request.setAttribute("venuesA",venues);
        return "web/venuesallcoation/addvenuesallocation";
    }
    @RequestMapping(value = "findeditvenuesallocationjsp.action")
    public String findeditvenuesallocationjsp(HttpServletRequest request,Integer venuesAllocationId) {
        VenuesAllocation venuesAllocation
                =venuesAllocationService.findbyid(venuesAllocationId);
        request.setAttribute("venuesAllocation",venuesAllocation);
        return "web/venuesallcoation/editvenuesallocation";
    }
    @RequestMapping(value = "editvenuesallocation.action")
    @ResponseBody
    public boolean editvenuesallocation(VenuesAllocation venuesAllocation, HttpServletResponse response) {
        boolean flag = false;
        flag= venuesAllocationService.editvenuesallocation(venuesAllocation);
        if (flag) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("修改成功"));
        } else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("修改失败"));
        }
        return flag;
    }
    @RequestMapping("/import.action")
    public void impotr(HttpServletRequest request, Model model) throws Exception {
        int adminId = 1;
        //获取上传的文件
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("upfile");
        InputStream in = file.getInputStream();
        //数据导入
        venuesAllocationService.importExcelInfo(in,file);
        in.close();

    }
}
