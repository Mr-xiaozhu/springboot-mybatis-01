package com.mrxiaozhu.springbootmybatis01.controller;

import com.alibaba.fastjson.JSONObject;
import com.mrxiaozhu.springbootmybatis01.Interceptor.Desensitization;
import com.mrxiaozhu.springbootmybatis01.common.ResultContentResponse;
import com.mrxiaozhu.springbootmybatis01.pojo.PersonPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class DesensitizationTestController {

    @GetMapping("/person/info")
    @ResponseBody
    public ResultContentResponse getPersonInfo() {

        PersonPojo person = PersonPojo.builder().name("mrs.xiaoHua").sex("女").school("休斯顿大学").value("18722236328").
                idNumber("1234537733636678901").idNumbers(Arrays.asList("1234537733636678901")).build();

//        PersonPojo person = new PersonPojo();
//        person.setName("mrs.xiaoHua");
//        person.setSex("女");
//        person.setSchool("休斯顿大学");
//        person.setValue("18722236328");
//        person.setIdNumber("1234537733636678901");
        return ResultContentResponse.success("success", person);
    }

}
