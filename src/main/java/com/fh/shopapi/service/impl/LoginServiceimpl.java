package com.fh.shopapi.service.impl;

import com.fh.shopapi.dao.LoginDao;
import com.fh.shopapi.entity.po.User;
import com.fh.shopapi.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class LoginServiceimpl implements LoginService {
    @Resource
    private LoginDao loginDao;

    @Override
    public User queryUserByname(String name) {
        User user =loginDao.queryUserByname(name);
        return user;
    }

    @Override
    public void addUser(User user) {
        user.setCreateDate(new Date());
        loginDao.addUser(user);
    }
}
