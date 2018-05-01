package com.xzit.service;


import com.github.pagehelper.PageInfo;
import com.xzit.entity.User;

import java.util.List;

/**
 * Created by huang on 2018/3/31.
 */
public interface UserService {
    PageInfo<User> alluser(User user, Integer pageNo, Integer pageSize,String order,String sort);
    boolean adduser(User user);
    boolean edituser(User user);
    boolean deleteuser(User user);
    User login(User user);
    User finduserbyuid(Integer uid);
    boolean emailisonly(String emil);
    boolean phoneisonly(String phone);
    void updateLogintimeandlogincount(User user);
    boolean VerifyPassword(User user);
    boolean charge(User user);
    List<User> getCurator();
    boolean changePassword(User user);
    List<Integer> findidbyEmail(User user);
}
