//package com.mrxiaozhu.springbootmybatis01.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.math.BigDecimal;
///**
// *  异常处理
// */
//@Controller
//public class ExceptionController {
//
//    /**
//     * 方法名：exceptionText1
//     * 参数名：divisor1 被除数 ，divisor2 除数
//     * 描述：模拟算数异常
//     */
//
//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public BigDecimal exceptionText1(BigDecimal divisor1, BigDecimal divisor2){
//        BigDecimal temp = divisor1.divide(divisor2);
//        return temp;
//    }
//
//    /**
//     * 方法名：exceptionText2
//     * 参数名：str 任意字符串
//     * 描述：模拟空指针异常
//     */
//    public int exceptionText2(String str){
//        return str.length();
//    }
//
//    /**
//     * 方法名：exceptionText
//     * 参数名：
//     * 描述：异常测试方法
//     */
//
//    @RequestMapping("/toError")
//    public ModelAndView toError(){
//        ModelAndView model = new ModelAndView();
//        model.addObject("exceptionText1_result",exceptionText1(BigDecimal.TEN,BigDecimal.ZERO));
//        model.setViewName("success");
//        return model;
//    }
//
//    @RequestMapping("/toError2")
//    public ModelAndView showInfo2(){
//        ModelAndView model = new ModelAndView();
//        model.addObject("exceptionText2_result",exceptionText2(null));
//        model.setViewName("success");
//        return model;
//    }
//}
