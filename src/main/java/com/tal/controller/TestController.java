package com.tal.controller;

import cn.bupt.service.Sql_Service;
import com.tal.common.ApplicationContextHelper;
import com.tal.common.JsonData;
import com.tal.dao.SysperModelMapper;
import com.tal.param.TestVo;
import com.tal.pojo.SysperModel;
import com.tal.util.BeanValidator;
import com.tal.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello(){

        log.info("hello，123");
        throw  new RuntimeException("test permission");
//        return JsonData.success("hello,permission");
    }
    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo){

        log.info("validate");
        SysperModelMapper modelMapper= ApplicationContextHelper.popBean(SysperModelMapper.class);
        SysperModel model=modelMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(model));

        BeanValidator.check(vo);
        return JsonData.success("hello,validate");
    }




}
