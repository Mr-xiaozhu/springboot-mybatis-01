package com.mrxiaozhu.springbootmybatis01.controller;

import java.util.*;

class RunoobTest {
    public static void main(String[] args) {
        String a = new String("a");
        Integer b = new Integer(1);
        fun(a, b);
        System.out.println(a + "--" + b);
    }

    public static void fun(String a, Integer b){
        a = "xyz";
        b = 2;
    }
}
