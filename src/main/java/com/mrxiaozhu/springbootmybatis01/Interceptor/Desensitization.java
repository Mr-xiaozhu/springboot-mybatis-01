package com.mrxiaozhu.springbootmybatis01.Interceptor;


import com.mrxiaozhu.springbootmybatis01.common.SensitiveTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitization {
    SensitiveTypeEnum type() ;
}
