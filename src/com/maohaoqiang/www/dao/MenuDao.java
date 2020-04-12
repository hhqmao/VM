package com.maohaoqiang.www.dao;

import java.util.Map;

public interface MenuDao {
    public boolean insert();//添加菜品
    public boolean update(String menu);//更新菜品
    public boolean delect(String menu);//删除菜品
    public boolean select(String menu, Map<String, String> userlogin);//查询菜品
    public void selectAll();
}
