package com.xzit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.entity.ExcelBean;
import com.xzit.entity.User;
import com.xzit.entity.UserExample;
import com.xzit.mapper.UserMapper;
import com.xzit.service.UserService;
import com.xzit.utils.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2018/3/31.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public PageInfo<User> alluser(User user, Integer pageNo, Integer pageSize,String order,String sort) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        if(user.getUserEmail().length()>0){
            criteria.andUserEmailLike("%"+user.getUserEmail()+"%");
        }
        if(user.getDeletestate()!=null){
            criteria.andDeletestateEqualTo(user.getDeletestate());
        }
        if(user.getUserAuthority()!=null){
            criteria.andUserAuthorityEqualTo(user.getUserAuthority());
        }
        if(user.getUserState()!=null){
            criteria.andUserStateEqualTo(user.getUserState());
        }
        //criteria.andDeletestateEqualTo(Constant.Authority.Curator.getKey());
        if(order!=null&&sort!=null){
            userExample.setOrderByClause(EntityToColum.GetUserMap(sort)+" "+order);
        }

        PageInfo<User> userPageInfo=new PageInfo<User>(userMapper.selectByExample(userExample));
         return userPageInfo;
    }

    public boolean adduser(User user) {
        int num=0;
        user.setUserResignDate(Dateutils.getDate());
        user.setUserPassword(MD5Util.MD5(user.getUserPassword()));


        num=userMapper.insertSelective(user);

        return (num>0)? true: false;
    }

    public boolean edituser(User user) {
        int num=0;
      //  user.setUserResignDate(Dateutils.getDate());
        user.setUserPassword(MD5Util.MD5(user.getUserPassword()));
        if(user.getUserPaypassword()!=null){
            user.setUserPaypassword(MD5Util.MD5(user.getUserPaypassword()));
        }
        num=userMapper.updateByPrimaryKeySelective(user);
        return (num>0)?true:false;
    }

    public boolean deleteuser(User user) {
        int num=0;
        user.setDeletestate(Constant.Del.isdel.getKey());
         num=userMapper.updateByPrimaryKeySelective(user);
        return (num>0)? true:false;
    }

    public User login(User user) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserEmailEqualTo(user.getUserEmail());
        criteria.andUserPasswordEqualTo(MD5Util.MD5(user.getUserPassword()));
        List<User> users=userMapper.selectByExample(userExample);
        if(users.size()!=0){
            return users.get(0);
        }
      else   return null;

    }

    public User finduserbyuid(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    public boolean emailisonly(String emil) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserEmailEqualTo(emil);
        return userMapper.selectByExample(userExample).size()>0?false:true;

    }

    public boolean phoneisonly(String phone) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        return userMapper.selectByExample(userExample).size()>0?false:true;
    }

    public void updateLogintimeandlogincount(User user) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        user.setUserLoginCount(user.getUserLoginCount()+1);
        user.setUserLoginDate(Dateutils.getDate());
        userMapper.updateByPrimaryKeySelective(user);
    }

    public boolean VerifyPassword(User user) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUseridEqualTo(user.getUserid());
        criteria.andUserPasswordEqualTo(MD5Util.MD5(user.getUserPassword()));

        return (userMapper.selectByExample(userExample).size()>0)?true:false;
    }

    public boolean charge(User user) {
     int num=userMapper.updateByPrimaryKeySelective(user);

        return (num>0)?true:false;
    }

    public List<User> getCurator() {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria  =userExample.createCriteria();
        criteria.andUserAuthorityEqualTo(Constant.Authority.Curator.getKey());
        return userMapper.selectByExample(userExample);
    }
    public boolean changePassword(User user) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria  =userExample.createCriteria();
        user.setUserPassword(MD5Util.MD5(user.getUserPassword()));
        criteria.andUserEmailEqualTo(user.getUserEmail());
        return (userMapper.updateByExampleSelective(user,userExample)>0)?true:false;
    }

    public List<Integer> findidbyEmail(User user) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria  =userExample.createCriteria();
        criteria.andUserEmailLike("%"+user.getUserEmail()+"%");
        criteria.andPhoneLike("%"+user.getPhone()+"%");
        List<Integer> userids=new ArrayList<Integer>();
        List<User> users=userMapper.selectByExample(userExample);
        for(int i=0;i<users.size();i++){
            userids.add(users.get(i).getUserid());
        }
        return userids;
    }

    public XSSFWorkbook exportUserInfo(User user) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        if(user.getUserEmail().length()>0){
            criteria.andUserEmailLike("%"+user.getUserEmail()+"%");
        }
        if(user.getDeletestate()!=null){
            criteria.andDeletestateEqualTo(user.getDeletestate());
        }
        if(user.getUserAuthority()!=null){
            criteria.andUserAuthorityEqualTo(user.getUserAuthority());
        }
        if(user.getUserState()!=null){
            criteria.andUserStateEqualTo(user.getUserState());
        }
        List<User> list = userMapper.selectByExample(userExample);

        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap();
        XSSFWorkbook xssfWorkbook=null;
        //设置标题栏
        excel.add(new ExcelBean("用户编号","userid",0));
        excel.add(new ExcelBean("用户昵称","userNickname",0));
        excel.add(new ExcelBean("用户姓名","userTruename",0));
        excel.add(new ExcelBean("用户邮箱","userEmail",0));
        excel.add(new ExcelBean("账户余额","userBalance",0));
        excel.add(new ExcelBean("用户注册日期","userResignDate",0));
        excel.add(new ExcelBean("用户注册日期","userLoginDate",0));
        excel.add(new ExcelBean("用户登入次数","userLoginCount",0));
        excel.add(new ExcelBean("用户联系方式","phone",0));
        excel.add(new ExcelBean("用户使用设备","userDrive",0));
        map.put(0, excel);
        //  String sheetName = salaryDate + "月份收入";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(User.class, list, map, "用户信息");
        return xssfWorkbook;
    }
}



