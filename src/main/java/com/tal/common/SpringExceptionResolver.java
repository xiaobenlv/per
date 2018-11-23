package com.tal.common;

import com.tal.exception.ParamException;
import com.tal.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        String url=request.getRequestURL().toString();
        ModelAndView mv = null;
        String defaultMsg="System error";

        if (url.endsWith(".json")){
            if (ex instanceof PermissionException||ex instanceof ParamException){

                JsonData result=JsonData.fail(ex.getMessage());
                mv=new ModelAndView("jsonView",result.toMap());
            }else {
                log.error("unknown json exception, url:" + url, ex);
                JsonData result = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView", result.toMap());
            }
        }else if (url.endsWith(".page")){
            log.error("unknown page exception, url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception", result.toMap());
        }else {
            log.error("unknow exception, url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView", result.toMap());
        }

        return mv;


    }
}
