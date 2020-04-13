package com.maohaoqiang.www.util;

import com.maohaoqiang.www.dao.JudgeMenuDao;

import java.util.Map;

public class JudgeMenu {
    public static boolean judguMenu(Map<String,String> userlogin,int view){
        String loginname=userlogin.get("loginname");
        JudgeMenuDao judgeMenuDao=new JudgeMenuDao();
        return judgeMenuDao.jdugeMenu(loginname,view);
    }
}
