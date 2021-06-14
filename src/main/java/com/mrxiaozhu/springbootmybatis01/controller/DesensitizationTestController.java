package com.mrxiaozhu.springbootmybatis01.controller;

import com.alibaba.fastjson.JSONObject;
import com.mrxiaozhu.springbootmybatis01.Interceptor.Desensitization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DesensitizationTestController {

    @GetMapping("/person/info")
    @ResponseBody
    @Desensitization
    public Object getPersonInfo() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("Name", "傻帽周小花");
        jsonObject.put("Sex", "女");
        jsonObject.put("School", "休斯顿大学");
        jsonObject.put("Phone", "18746046328");
        jsonObject.put("idNumber","1234537733636678901");

        return jsonObject;
    }

}
