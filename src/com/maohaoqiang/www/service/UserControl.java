package com.maohaoqiang.www.service;

import com.maohaoqiang.www.po.User;
import com.maohaoqiang.www.view.MangerView;
import com.maohaoqiang.www.view.UserView;

import java.util.Map;

public class UserControl {
    private UserControl(){}
    public static  int userWatch(int judge, Map<String,String> userlogin){
        //a是进行返回功能实现的关键
        boolean decide=false;
        while(!decide){//实现权限的区分
            if (judge==1){//普通用户
                String fun=UserView.basicUserView();
                decide=true;
                while (decide){
                    decide=DealUser.user(fun,decide,userlogin);
                }
            }
            if (judge==2){//厨师
                String fun= UserView.basicUnUserView();
                decide=true;
                while (decide){
                    decide=DealChef.Chef(fun,decide,userlogin);
                }
            }
            if (judge==3){//经理
                String fun= MangerView.mangerFrist();
                decide=true;
                while (decide){
                    decide=DealManger.manger(fun,decide,userlogin);
                }
            }
        }
        return 0;
    }

}