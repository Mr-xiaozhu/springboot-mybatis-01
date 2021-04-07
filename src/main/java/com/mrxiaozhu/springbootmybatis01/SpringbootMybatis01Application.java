package com.mrxiaozhu.springbootmybatis01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.mrxiaozhu.springbootmybatis01.mapper") //@MapperScan 用户扫描MyBatis的Mapper接口
public class SpringbootMybatis01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatis01Application.class, args);
    }

}
