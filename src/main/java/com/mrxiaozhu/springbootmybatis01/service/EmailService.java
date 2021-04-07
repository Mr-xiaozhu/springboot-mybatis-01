package com.mrxiaozhu.springbootmybatis01.service;

import com.mrxiaozhu.springbootmybatis01.pojo.Email;

import java.util.List;

public interface EmailService {
    void insertEmail(Email email);
    List<Email> selectEmailsAll();
    void deleteEmailById(Integer id);
}
