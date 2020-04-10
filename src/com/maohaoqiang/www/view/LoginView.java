package com.maohaoqiang.www.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginView {
    public LoginView(){}
    //获取账号密码
    public Map<String,String> inPut(){
        System.out.println("******************************");
        Scanner s=new Scanner(System.in);
        System.out.print("用户名：");
        String loginname=s.nextLine();
        System.out.print("密码：");
        String loginpaw=s.nextLine();
        System.out.println("******************************");
        Map<String,String> userLogin= new HashMap<>();
        userLogin.put("loginname",loginname);
        userLogin.put("loginpaw",loginpaw);
        return userLogin;
    }
}
