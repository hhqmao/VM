package com.maohaoqiang.www.service;

import com.maohaoqiang.www.dao.MenuDaoImpl;
import com.maohaoqiang.www.dao.SetMenuDao;
import com.maohaoqiang.www.view.DecideView;
import com.maohaoqiang.www.view.Out;

import java.util.Map;
import java.util.Scanner;

public class DealUser {
    public static boolean user(String fun, boolean decide, Map<String,String> userlogin){
        Scanner scanner=new Scanner(System.in);
        if (fun.equalsIgnoreCase("查看窗口")||fun.equalsIgnoreCase("1")||fun.equalsIgnoreCase("搜索菜品")
                ||fun.equalsIgnoreCase("2") ||fun.equalsIgnoreCase("退出")||fun.equalsIgnoreCase("3")||
                fun.equalsIgnoreCase("个人中心")||fun.equalsIgnoreCase("4")){
            if (fun.equalsIgnoreCase("查看窗口")||fun.equalsIgnoreCase("1")){
                MenuDaoImpl menuDao=new MenuDaoImpl();
                menuDao.selectAll();//遍历输出菜品
                decide= UserChoice.checkView();//点餐界面功能选择
                if (decide){
                    String s= DecideView.decideMenu();
                    decide= SetMenuDao.set(s,userlogin);//传入菜名和账号信息，实现点餐功能
                }
            }
            if (fun.equalsIgnoreCase("搜索菜品")||fun.equalsIgnoreCase("2")){
                System.out.println("————————————————————————————");
                System.out.print("请输入您要搜索的菜名：");
                MenuDaoImpl menuDao=new MenuDaoImpl();
                String s=scanner.nextLine();
                decide=menuDao.select(s,userlogin);//实现查询功能并且可以实现点餐
            }
            if(fun.equalsIgnoreCase("个人中心")||fun.equalsIgnoreCase("3")){
                decide= UserChoice.personalCenter(userlogin);//进入个人中心界面
            }
            if (fun.equalsIgnoreCase("退出")||fun.equalsIgnoreCase("4")) Out.exit();
        }else{
            System.out.println("输入错误");
            decide=false;
        }
        return decide;
    }
}
