package com.fh.shopapi.service;

import com.fh.shopapi.entity.po.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getData();

    void add(Menu menu);

    void update(Menu menu);

    void del(Integer id);
}
