package com.mrxiaozhu.springbootmybatis01.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.mrxiaozhu.springbootmybatis01.Interceptor.Desensitization;
import com.mrxiaozhu.springbootmybatis01.common.SensitiveTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Builder
@Setter
@Getter
@ToString
public class PersonPojo {
    private String name;
    private String sex;
    private String school;
    @Desensitization(type = SensitiveTypeEnum.encrypt)
    private String value;
    @Desensitization(type = SensitiveTypeEnum.desensitization)
    private String idNumber;

    @Desensitization(type = SensitiveTypeEnum.desensitization_list)
    private List<String> idNumbers;

    private int testInt;

    private List<String> testList;

    private List<PersonPojo> testObject;
}
