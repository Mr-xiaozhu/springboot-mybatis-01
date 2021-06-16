package com.mrxiaozhu.springbootmybatis01.controller;

import com.alibaba.fastjson.JSONObject;
import com.mrxiaozhu.springbootmybatis01.Interceptor.Desensitization;
import com.mrxiaozhu.springbootmybatis01.common.ResultContentResponse;
import com.mrxiaozhu.springbootmybatis01.pojo.PersonPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DesensitizationTestController {

    @GetMapping("/person/info")
    @ResponseBody
    public ResultContentResponse getPersonInfo() {
        PersonPojo person = new PersonPojo();
        person.setName("周小花");
        person.setSex("女");
        person.setSchool("休斯顿大学");
        person.setPhone("18722236328");
        person.setIdNumber("1234537733636678901");
        return ResultContentResponse.success("success", person);
    }

}
