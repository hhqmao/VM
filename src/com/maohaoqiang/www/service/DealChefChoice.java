package com.maohaoqiang.www.service;

import com.maohaoqiang.www.dao.MenuDaoImpl;
import com.maohaoqiang.www.view.MenuView;

public class DealChefChoice {
    public static boolean choice(String cho,String menuname){
        boolean result=false;
        MenuDaoImpl menuDao=new MenuDaoImpl();
        if (cho.equalsIgnoreCase("更新菜名")||cho.equalsIgnoreCase("1")){
            String newnam=MenuView.getMenuNam();//获得新菜名
            result= menuDao.updatename(menuname,newnam);
        }
        if (cho.equalsIgnoreCase("更新价格")||cho.equalsIgnoreCase("2")){
            String newcash=MenuView.getMenuCash();//获得新价格
            result=menuDao.updatecash(menuname,newcash);
        }
        if(cho.equalsIgnoreCase("补充数量")||cho.equalsIgnoreCase("3")){
            String newnum=MenuView.getMenuNum();//获得补充数量
            result=menuDao.updatenumber(menuname,newnum);
        }
    return result;
    }
}
