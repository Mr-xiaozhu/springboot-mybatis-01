package com.mrxiaozhu.springbootmybatis01.global;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class GlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView model = new ModelAndView();
        if(e instanceof ArithmeticException){
            model.setViewName("Exception/arithmeticError");
        }
        if(e instanceof NullPointerException){
            model.setViewName("Exception/nullPointException");
        }
        System.out.println(e.toString());
        model.addObject("error",e.toString());
        return model;
    }

}
