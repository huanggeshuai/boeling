package com.xzit.controller;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.Areas;
import com.xzit.entity.Cities;
import com.xzit.entity.User;
import com.xzit.entity.Venues;
import com.xzit.service.*;
import com.xzit.utils.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2018/4/3.
 */
@Controller
@RequestMapping(value = "/venues")
public class VenuesController {
    @Autowired
    VenuesService venuesService;
    @Autowired
    UserService userService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    CitiesService citiesService;
    @Autowired
    AreasService areasService;

    @RequestMapping(value = "/venuesinfo.action")
    @ResponseBody
    public DataGrid<Venues> allvenueinfo(Venues venues, Integer page, Integer rows, String order, String sort,Integer image) {
        PageInfo<Venues> pageInfo = venuesService.alluser(venues, page, rows, order, sort,image);
        DataGrid<Venues> dataGrid = new DataGrid<Venues>();
        dataGrid.setRows(pageInfo.getList());
        dataGrid.setTotal(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "/findvenues.action")
    public String findvenues() {
        return "web/venues/venues";
    }

    @RequestMapping(value = "/findaddvenues.action")
    public String findaddvenues() {
        return "web/venues/addvenues";
    }


    @RequestMapping(value = "/addvenues.action")
    @ResponseBody
    public void addvenues(Venues venues, HttpServletResponse response) throws Exception {
        boolean flag = false;
        String provincename=provinceService.getProvincename(venues.getVenuesProvice());
        String cityname=citiesService.getCityname(venues.getVenuesCity());
        String areaname=areasService.getarea(venues.getVenuesAreas());
        String address=venues.getVenuesAddress();
        String location= GetMap.getGaodeinfo(provincename+cityname+areaname+address);
        if(location==null){
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("地址错误，请重新输入"));
        } else {
            String loc[]=location.split(",");
            venues.setVenuesLatitude(new BigDecimal(loc[1]));
            venues.setVenuesLongitude(new BigDecimal(loc[0]));
            flag = venuesService.addVenues(venues);
            if (flag) {
                WriteJson.printJson(response, JsonMapUtils.Success_Map("添加成功"));
            } else {
                WriteJson.printJson(response, JsonMapUtils.Fail_Map("添加失败"));
            }
        }


    }

    @RequestMapping(value = "/getcur.action")
    @ResponseBody
    public List<User> getcur(HttpServletResponse response) {
        return userService.getCurator();
    }

    @RequestMapping(value = "/findeditjsp.action")
    public String findeditjsp(HttpServletRequest request, Integer venuesid) {
        Venues venues=venuesService.findbyid(venuesid);
        request.setAttribute("venues",venues);
        return "/web/venues/editvenues";
    }


    @RequestMapping(value = "/editvenues.action")
    @ResponseBody
    public void editjsp(HttpServletResponse response,Venues venues) throws Exception {
        boolean flag=false;
        String provincename=provinceService.getProvincename(venues.getVenuesProvice());
        String cityname=citiesService.getCityname(venues.getVenuesCity());
        String areaname=areasService.getarea(venues.getVenuesAreas());
        String address=venues.getVenuesAddress();
        String location= GetMap.getGaodeinfo(provincename+cityname+areaname+address);
        if(location==null){
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("地址错误，请重新输入"));
        } else {
            String loc[]=location.split(",");
            venues.setVenuesLatitude(new BigDecimal(loc[1]));
            venues.setVenuesLongitude(new BigDecimal(loc[0]));
            flag= venuesService.editVenues(venues);
            if (flag) {
                WriteJson.printJson(response, JsonMapUtils.Success_Map("修改成功"));
            } else {
                WriteJson.printJson(response, JsonMapUtils.Fail_Map("修改失败"));
            }
        }

    }
    @RequestMapping(value = "/getvenues.action")
    @ResponseBody
    public List<Venues> getvenues(HttpServletResponse response) {
        return venuesService.venues();
    }

    @RequestMapping(value = "/cancel.action")
    @ResponseBody
    public void cancel(HttpServletResponse response,Venues venues) {
        boolean flag=false;
        flag=venuesService.cancel(venues);
        if (flag) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("注销成功"));
        } else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("注销失败"));
        }

    }
    @RequestMapping(value = "/recover.action")
    @ResponseBody
    public void recover(HttpServletResponse response,Venues venues) {
        boolean flag=false;
        flag=venuesService.reover(venues);
        if (flag) {
            WriteJson.printJson(response, JsonMapUtils.Success_Map("恢复成功"));
        } else {
            WriteJson.printJson(response, JsonMapUtils.Fail_Map("恢复失败"));
        }

    }
    @RequestMapping(value = "/findauditjsp.action")
    public String findauditjsp(HttpServletRequest request, Integer venuesid) {
        Venues venues=venuesService.findbyid(venuesid);
        request.setAttribute("venuesaudit",venues);
        return "/web/venues/auditvenues";
    }
    @RequestMapping(value = "/auditvenues.action")
    public void auditvenues(HttpServletResponse response, Venues venues) {
              if(venuesService.editVenues(venues)){
                  WriteJson.printJson(response, JsonMapUtils.Success_Map("审核成功"));
              }else {
                  WriteJson.printJson(response, JsonMapUtils.Fail_Map("审核失败"));
              }
    }
    @RequestMapping(value = "/finduploadjsp.action")
    public String finduploadjsp(HttpServletRequest request, Integer venuesid) {
        Venues venues=venuesService.findbyid(venuesid);
        request.setAttribute("venuesupload",venues);
        return "/web/venues/upload";
    }
    @ResponseBody
    @RequestMapping(value = "/filesUpload.action")
    public void photoUpload(@RequestParam("file") MultipartFile file, Venues venues,  HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException{
        String newName = null;
        String newName2 = null;
        newName=venues.getVenuesid()+"";
        newName2="venues";
        boolean flag=false;
        String result = "";
        if (file!=null) {// 判断上传的文件是否为空
            String path=null;// 文件路径
            String type=null;// 文件类型
            String newfilepath = null;//根据编号新建目录和文件
            String fileName=file.getOriginalFilename();// 文件原名称
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("jpeg".equals(type.toUpperCase())||"bmp".equals(type.toUpperCase())||"GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    newfilepath = newName2 + "/" + newName + "/" + newName + UUIDUtils.getUUID()+"VenuesPicture" + "." + type;
                    path=readImgUrl() + newfilepath;

                    // 转存文件到指定的路径
                    try {
                        File file2=new File(path);
                        if(!file2.exists()){
                            file2.mkdirs();
                        }
                        file.transferTo(file2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        venues.setImageurl("/upload/"+newfilepath);
                         flag=venuesService.editVenues(venues);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    result = "不是我们想要的文件类型,请按要求重新上传";
                }
            }else {
                result = "文件类型为空";
            }
        }else {
            result = "没有找到相对应的文件";
        }
//        JSONObject obj = new JSONObject();
//        obj.put("message",result);
//        response.setCharacterEncoding("utf-8");
//        response.getWriter().print(obj.toString());
        if(flag){
            WriteJson.printJson(response,JsonMapUtils.Success_Map("上传成功"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map(result));

        }
    }

    //读取图片的存放的路径
    private static  String readImgUrl(){
        //服务器存储图片位置
        //String saveImgUrl = "C:/upload/";

        //本地存储图片位置
        String saveImgUrl = "C:/Users/huang/Desktop/upload/";
       // String url="";
        return saveImgUrl;
    }
    @RequestMapping("/exportvenuesinfo.action")
    @ResponseBody
    public  void exportvenues(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException, UnsupportedEncodingException {
        String excelname = "场馆信息信息.xlsx";
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
            workbook = venuesService.exportvenuesInfo(new Venues());
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
