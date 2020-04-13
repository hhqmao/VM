package com.maohaoqiang.www;

import com.maohaoqiang.www.dao.LoginDao;
import com.maohaoqiang.www.service.UserControl;
import com.maohaoqiang.www.view.LoginView;
import com.maohaoqiang.www.view.Out;

import java.util.Map;


public class Main {
    public static void  main(String[]args){
        int judge=0;
        //judge判断权限，0代表数据库中没有这个数据，就代表登陆失败
        while (judge==0){
            LoginView loginView=new LoginView();
            Map<String,String> userLogin=loginView.inPut();//获取账号密码
            //与数据库中的账号密码进行比对，并判断权限等级
            judge= LoginDao.login(userLogin);
            if(judge==0) Out.loginError();
            else UserControl.userWatch(judge,userLogin);//进入用户界面
        }
    }
}
