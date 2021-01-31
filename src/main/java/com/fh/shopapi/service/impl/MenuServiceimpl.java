package com.fh.shopapi.service.impl;

import com.fh.shopapi.dao.MenuDao;
import com.fh.shopapi.entity.po.Menu;
import com.fh.shopapi.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceimpl implements MenuService {
    @Resource
    private MenuDao menuDao;

    @Override
    public List<Menu> getData() {
        return menuDao.getData();
    }

    @Override
    public void add(Menu menu) {
        menu.setAuthor("test");
        menu.setCreateDate(new Date());
        menu.setIsDel(0);
        menuDao.add(menu);
    }

    @Override
    public void update(Menu menu) {
        menuDao.update(menu);
    }

    @Override
    public void del(Integer id) {
        menuDao.del(id);
    }
}
