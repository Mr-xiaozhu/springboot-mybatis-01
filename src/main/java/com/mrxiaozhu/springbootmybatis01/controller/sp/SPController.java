package com.mrxiaozhu.springbootmybatis01.controller.sp;

import com.mrxiaozhu.springbootmybatis01.Interceptor.Desensitization;
import com.mrxiaozhu.springbootmybatis01.common.ResultContentResponse;
import com.mrxiaozhu.springbootmybatis01.pojo.PersonPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SPController {

    @GetMapping("/sp/person/info")
    @ResponseBody
    public ResultContentResponse getPersonInfo() {
        PersonPojo person = PersonPojo.builder().name("mrs.xiaoHua").sex("女").school("休斯顿大学").value("18722236328").idNumber("1234537733636678901").build();

//        PersonPojo person = new PersonPojo();
//        person.setName("mrs.xiaoCao");
//        person.setSex("女");
//        person.setSchool("休斯顿大学");
//        person.setValue("18722236328");
//        person.setIdNumber("1234537733636678901");
        return ResultContentResponse.success("success", person);
    }
}
