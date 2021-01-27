package com.fh.shopapi.service;

import com.fh.shopapi.entity.po.User;

public interface LoginService {
    User queryUserByname(String name);
}
