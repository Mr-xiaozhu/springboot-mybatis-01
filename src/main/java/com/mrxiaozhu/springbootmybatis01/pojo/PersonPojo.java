package com.mrxiaozhu.springbootmybatis01.pojo;


import com.mrxiaozhu.springbootmybatis01.Interceptor.Desensitization;
import com.mrxiaozhu.springbootmybatis01.common.SensitiveTypeEnum;

import java.util.List;


public class PersonPojo {
    private String name;
    private String sex;
    private String school;
    @Desensitization(type = SensitiveTypeEnum.desensitization)
    private String phone;
    @Desensitization(type = SensitiveTypeEnum.desensitization)
    private String idNumber;

    private int testInt;

    private List<String> testList;

    private List<PersonPojo> testObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
