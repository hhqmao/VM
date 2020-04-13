package com.maohaoqiang.www.service;

import com.maohaoqiang.www.dao.MenuDaoImpl;
import com.maohaoqiang.www.po.Menu;
import com.maohaoqiang.www.view.MenuView;
import com.maohaoqiang.www.view.Out;
import com.maohaoqiang.www.view.UserView;

import java.util.Map;

public class DealChef {
    public static boolean Chef(String fun, boolean decide, Map<String,String> userlogin){
        String fun2="";
        if (fun.equalsIgnoreCase("外卖")||fun.equalsIgnoreCase("管理")||
                fun.equalsIgnoreCase("1")||fun.equalsIgnoreCase("2")){
            if (fun.equalsIgnoreCase("外卖")||fun.equalsIgnoreCase("2")){
                fun2= UserView.basicUserView();
                while (decide){
                    decide=DealUser.user(fun2,decide,userlogin);
                }
            }
            if (fun.equalsIgnoreCase("管理")||fun.equalsIgnoreCase("1")){
                fun2=UserView.chefView();
                MenuDaoImpl menuDao=new MenuDaoImpl();
                while (decide){
                    if(fun2.equalsIgnoreCase("添加菜品")||fun2.equalsIgnoreCase("1")||
                            fun2.equalsIgnoreCase("下架菜品") ||fun2.equalsIgnoreCase("2")||
                            fun2.equalsIgnoreCase("更新菜品")||fun2.equalsIgnoreCase("3")||
                            fun2.equalsIgnoreCase("查看菜品")||fun2.equalsIgnoreCase("4")||
                            fun2.equalsIgnoreCase("返回")||fun2.equalsIgnoreCase("5")||
                            fun2.equalsIgnoreCase("退出")||fun2.equalsIgnoreCase("6")){
                        if(fun2.equalsIgnoreCase("添加菜品")||fun2.equalsIgnoreCase("1")){
                            Menu menu = MenuView.insertView();
                            decide= menuDao.insert(userlogin,menu);
                        }
                        if(fun2.equalsIgnoreCase("下架菜品") ||fun2.equalsIgnoreCase("2")){
                            decide=menuDao.delect(MenuView.deleteView(),userlogin);
                        }
                        if(fun2.equalsIgnoreCase("更新菜品")||fun2.equalsIgnoreCase("3")){
                            String cho=MenuView.updateView();
                            if(!(cho.equalsIgnoreCase("返回")||cho.equalsIgnoreCase("4"))){
                                String menuname=MenuView.updateChoice();
                                decide=DealChefChoice.choice(cho,menuname);
                            }else decide=false;
                        }
                        if(fun2.equalsIgnoreCase("查看菜品")||fun2.equalsIgnoreCase("4")){
                            decide=menuDao.selectChefMenu(userlogin);
                        }
                        if(fun2.equalsIgnoreCase("返回")||fun2.equalsIgnoreCase("5")){
                            decide=false;
                        }
                        if(fun2.equalsIgnoreCase("退出")||fun2.equalsIgnoreCase("6")) Out.exit();
                    }
                }
            }
            if(fun.equalsIgnoreCase("退出")||fun.equalsIgnoreCase("3"))Out.exit();
        }else {
            System.out.println("输入错误");
            decide=true;
        }
        return decide;
    }
}
