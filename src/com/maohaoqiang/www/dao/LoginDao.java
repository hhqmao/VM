package com.maohaoqiang.www.dao;

import com.maohaoqiang.www.util.LoginUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class LoginDao {
    public static int login(Map<String,String> userLogin) {
        int loginSuccess=0;
        String loginname=userLogin.get("loginname");
        String loginpaw=userLogin.get("loginpaw");
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            conn= LoginUtil.getoCnnetion();
            String sql="select * from user where user_no=? and user_paw=? ";
            stat=conn.prepareStatement(sql);
            stat.setString(1,loginname);
            stat.setString(2,loginpaw);
            rs=stat.executeQuery();
            if(rs.next()){
                if(rs.getInt("power")==1)loginSuccess=1;
                if(rs.getInt("power")==2)loginSuccess=2;
                if(rs.getInt("power")==3)loginSuccess=3;
                if(rs.getInt("power")==4)loginSuccess=4;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        return loginSuccess;
    }
}
