package com.maohaoqiang.www;

import com.maohaoqiang.www.service.UserView;
import com.maohaoqiang.www.util.LoginUtil;
import com.maohaoqiang.www.view.LoginView;

import java.util.Map;


public class Main {
    public static void  main(String[]args){
        int judge=0;
        //judge判断权限，0代表数据库中没有这个数据，就代表登陆失败
        while (judge==0){
            LoginView loginView=new LoginView();
            Map<String,String> userLogin=loginView.inPut();//获取账号密码
            //与数据库中的账号密码进行比对，并判断权限等级
            judge= LoginUtil.login(userLogin);
            if(judge==0)System.out.println("账号或者密码错误");
            else UserView.userWatch(judge,userLogin);//进入用户界面
        }
    }
}
