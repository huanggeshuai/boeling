package com.xzit.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.xzit.entity.UserCustomActivity;
import com.xzit.entity.Venues;
import com.xzit.service.UsercustomactivityService;
import com.xzit.utils.DataGrid;
import com.xzit.utils.JsonMapUtils;
import com.xzit.utils.UUIDUtils;
import com.xzit.utils.WriteJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by huang on 2018/4/27.
 */
@Controller
@RequestMapping(value = "/usercustomactivity")
public class MobileUserCustomActController {
    @Autowired
    UsercustomactivityService usercustomactivityService;
    @RequestMapping(value = "/allinfo.action")
    @ResponseBody
    public DataGrid<UserCustomActivity> allinfo(Integer page, Integer rows,UserCustomActivity userCustomActivity){
        PageInfo<UserCustomActivity> userCustomActivityPageInfo=usercustomactivityService.allinfo(userCustomActivity,page,rows);
        DataGrid<UserCustomActivity> customActivityDataGrid=new DataGrid<UserCustomActivity>();
        customActivityDataGrid.setRows(userCustomActivityPageInfo.getList());
        customActivityDataGrid.setTotal(userCustomActivityPageInfo.getTotal());
        return customActivityDataGrid;
    }
    @RequestMapping(value = "/addinfo.action")
    public void add(UserCustomActivity userCustomActivity, HttpServletResponse response){
        int id=usercustomactivityService.add(userCustomActivity);
        if(id>0){
            WriteJson.printJson(response,JsonMapUtils.Success_Map(id));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("添加失败"));
        }
    }
    @RequestMapping(value = "/editinfo.action")
    public void edit(UserCustomActivity userCustomActivity, HttpServletResponse response){
        if(usercustomactivityService.edit(userCustomActivity)){
            WriteJson.printJson(response,JsonMapUtils.Success_Map("修改成功"));
        }else {
            WriteJson.printJson(response,JsonMapUtils.Fail_Map("修改失败"));
        }
    }
    @ResponseBody
    @RequestMapping(value = "/filesUpload.action")
    public void photoUpload(@RequestParam("file") MultipartFile file, UserCustomActivity userCustomActivity, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException {
        String newName = null;
        String newName2 = null;
        newName=userCustomActivity.getUserCustomActivityId()+"";
        newName2="usercustomeractivity";
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
                    // 项目在容器中实际发布运行的根路径
                    //String realPath=request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    //String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;

                    //path=readImgUrl()+/*System.getProperty("file.separator")+*/trueFileName;

                    // 设置存放图片文件的路径
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
                    int ii = 0;
                    try {
                        //  String httpuring = "http://127.0.0.1:8080";
                        //阿里云服务器
                        //String httpuring = "http://39.106.162.126:8088";
                        //腾讯云服务器
                        //String httpuring = "http://139.199.207.168:8088";
                        //在web端不加ip和端口号在页面可以正常加载图片，但在android无法加载图片，故添加ip
                        userCustomActivity.setImageurl("/upload/"+newfilepath);
                        flag=usercustomactivityService.edit(userCustomActivity);
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

}
