package com.tal.controller;


import com.tal.common.JsonData;
import com.tal.dto.UserLevelDto;
import com.tal.param.UserParam;
import com.tal.pojo.Page;
import com.tal.pojo.SysUser;
import com.tal.service.SysTreeService;
import com.tal.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysTreeService sysTreeService;




    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveUser(UserParam param) {
        sysUserService.save(param);
        return JsonData.success();
    }
    @RequestMapping("/tree.json")
    @ResponseBody
    public JsonData tree() {
     List<UserLevelDto> userLevelDtos=sysTreeService.userTree();
     return JsonData.success(userLevelDtos);
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateUser(UserParam param) {
        sysUserService.update(param);
        return JsonData.success();
    }


//    @RequestMapping("/delete.json")
//    @ResponseBody
//    public JsonData delete(@RequestParam("id") int id) {
//        sysDeptService.delete(id);
//        return JsonData.success();
//    }

    public String showUser(HttpServletRequest request, Model model){
        SysUser sysUser=(SysUser) request.getSession().getAttribute("loguser");
        int uid=sysUser.getUid();
        Page page=null;
        String pagenow=request.getParameter("pagenow");

        int totalcount=sysUserService.gettotalCount(uid);
        if (pagenow!=null){
            page=new Page(Integer.parseInt(pagenow),totalcount);
        }else {
            page=new Page(1,totalcount);
        }

        List<SysUser> sysUserList= sysUserService.selectUserByPage(page.getPagenow(),page.getPagesize(),uid);
        model.addAttribute("user",sysUserList);
        model.addAttribute("page",page);

        return null;
    }



}
