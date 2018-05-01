package com.xzit.interceptor;

import com.xzit.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huang on 2018/4/3.
 */
public class AuthorityizationInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URL={"/login.action","/findloginjsp.action","/mobilelogin.action","/mobileadduser.action","/send.action",
            "/changepassword.action","/mobilefinduserinfo.action"};
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag=false;
        String servletPath=httpServletRequest.getServletPath();
        for (String s:IGNORE_URL){
            if(servletPath.contains(s)){
                flag=true;
                break;
            }
        }
        if(!flag){
            User user=(User) httpServletRequest.getSession().getAttribute("admin");
            User user1=(User) httpServletRequest.getSession().getAttribute("mobile");
            if(user==null&&user1==null){
                httpServletRequest.getRequestDispatcher("findloginjsp.action").forward(httpServletRequest,httpServletResponse);
            }else {
                flag=true;
            }
        }
        return flag;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
