package com.maohaoqiang.www.dao;

import com.maohaoqiang.www.po.Menu;

import java.util.Map;

public interface MenuDao {
    public boolean insert(Map<String,String> userlogin, Menu menu);//添加菜品
    public boolean updatename(String menu,String newnam);//更新菜品
    public boolean updatecash(String menu,String newcash);
    public boolean updatenumber(String menu,String newnum);
    public boolean delect(String menu,Map<String,String> userlogin);//删除菜品
    public boolean select(String menu, Map<String, String> userlogin);//查询菜品
    public void selectAll();
    public boolean selectChefMenu(Map<String,String> userlogin);
}
