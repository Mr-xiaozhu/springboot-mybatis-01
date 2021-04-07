package com.mrxiaozhu.springbootmybatis01.mapper;

import com.mrxiaozhu.springbootmybatis01.pojo.Email;
import java.util.List;


public interface EmailMapper {
    void insertEmail(Email email);
    List<Email> selectEmailsAll();
    void deleteEmailById(Integer id);
}
