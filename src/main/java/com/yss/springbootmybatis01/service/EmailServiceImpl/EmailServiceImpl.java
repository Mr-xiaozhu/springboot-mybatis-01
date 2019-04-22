package com.yss.springbootmybatis01.service.EmailServiceImpl;

import com.yss.springbootmybatis01.mapper.EmailMapper;
import com.yss.springbootmybatis01.pojo.Email;
import com.yss.springbootmybatis01.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailMapper emailMapper;

    @Override
    public void insertEmail(Email email) {
        emailMapper.insertEmail(email);
    }

    @Override
    public List<Email> selectEmailsAll() {
        return emailMapper.selectEmailsAll();
    }

    @Override
    public void deleteEmailById(Integer id) {
        emailMapper.deleteEmailById(id);
    }
}
