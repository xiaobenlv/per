package com.tal.controller;


import com.tal.pojo.SysUser;
import com.tal.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/login.page")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
//   1.从页面得到用户名和密码，利用request，http协议中的所有内容都包含在request中， username,password,需要与页面保持一致
        String username=request.getParameter("username");
        String password=request.getParameter("password");

//   2.利用service、mapper根据用户名查询密码，如果
        SysUser sysUser=sysUserService.findByKeyword(username);
        String passget=sysUser.getPassword();

       if (password==passget){
            // 登陆成功的话，把当前的用户信息放到session中， 把用户信息存在了session中
            request.getSession().setAttribute("user", sysUser);
            return "success";
        }

        return "fail";
    }

    @RequestMapping("/logout.page")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().invalidate();
        String path = "signin.jsp";
        response.sendRedirect(path);
    }
}
