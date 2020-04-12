package com.maohaoqiang.www.service;

import com.maohaoqiang.www.dao.UserDaoImpl;
import com.maohaoqiang.www.view.DecideView;
import com.maohaoqiang.www.view.PersonalCenterView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Scanner;

public class UserChoice {
    private UserChoice(){}

    public static boolean checkView(){
        boolean a=false;
            String fun=DecideView.decideView();
            if (fun.equalsIgnoreCase("点餐")||fun.equalsIgnoreCase("返回")||fun.equalsIgnoreCase("退出")){
                if(fun.equalsIgnoreCase("点餐"))a=true;
                if (fun.equalsIgnoreCase("返回"))a=false;
                if (fun.equalsIgnoreCase("退出")){
                    System.out.println("谢谢光临");
                    System.exit(1);
            }
        }else System.out.println("输入错误");
        return a;
    }
    public static boolean personalCenter(Map<String,String> userLogin){
        boolean a=false;
        String fun=PersonalCenterView.view();
        UserDaoImpl userDao=new UserDaoImpl();
        if (fun.equalsIgnoreCase("查询余额")||fun.equalsIgnoreCase("查询历史记录")
        ||fun.equalsIgnoreCase("返回")||fun.equalsIgnoreCase("退出")){
            if (fun.equalsIgnoreCase("查询余额")){
                a=userDao.selectMoney(userLogin);
            }
            if(fun.equalsIgnoreCase("查询历史记录")){
                a=userDao.saveMoney(userLogin);
            }
            if (fun.equalsIgnoreCase("返回"))a=false;
            if(fun.equalsIgnoreCase("退出")){
                System.exit(1);
                System.out.println("谢谢光临");
            }
        }else System.out.println("输入错误");
        return a;
    }
}
