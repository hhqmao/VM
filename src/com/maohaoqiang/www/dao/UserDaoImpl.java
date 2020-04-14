package com.maohaoqiang.www.dao;


import com.maohaoqiang.www.po.User;
import com.maohaoqiang.www.util.LoginUtil;
import com.maohaoqiang.www.view.MangerView;
import com.maohaoqiang.www.view.Out;
import com.maohaoqiang.www.view.UserView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {
    @Override
    //查用户
    public boolean selectUser() {
        boolean succ=false;
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        String sql="select real_name,emil,phone_num from user where power=1 or power=2";
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            Out.outUser();
            while (rs.next()){
                succ=true;
                MangerView.selectUser(rs);
            }
            if(succ){
                Out.selectSuccess();
                succ=UserView.comment();
            }
        } catch (Exception e) {
            //Out.error();
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        return succ;
    }

    @Override
    //查厨师
    public boolean selectChef() {
        boolean succ=false;
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        String sql="select real_name,view '窗口' from user where power=2";
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.createStatement();
            rs=stat.executeQuery(sql);
            Out.outChef();
            while (rs.next()){
                succ=true;
                MangerView.selectChef(rs);
            }
            if (succ){
                Out.selectSuccess();
                succ=UserView.comment();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        return succ;
    }

    @Override
    public boolean selectFu_Manger() {
        return false;
    }

    @Override
    public boolean selectAll() {
        return false;
    }

    @Override
    public boolean insertUser() {
        return false;
    }

    @Override
    //增加厨师
    public boolean insertChef() {
        boolean succ=false;
        Connection conn=null;
        PreparedStatement stat=null;
        String sql="insert into user (user_no,user_paw,real_name,power,view,emil,phone_num) values (?,?,?,2,?,?,?)";
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            User user=MangerView.getChef();
            stat.setString(1,user.getUser_no());
            stat.setString(2,user.getUser_paw());
            stat.setString(3,user.getReal_name());
            stat.setInt(4,user.getView());
            stat.setString(5,user.getEmil());
            stat.setString(6,user.getPhone_num());
            int count=stat.executeUpdate();
            if (count>0)succ=true;
            if (succ){
                Out.noerror();
                succ=UserView.comment();
            }
        } catch (Exception e) {
            Out.error();
        }finally {
            LoginUtil.close(null,stat,conn);
        }
        return succ;
    }

    @Override
    //删除厨师
    public boolean deleteChef(String name) {
        boolean succ=false;
        Connection conn=null;
        PreparedStatement stat=null;
        String sql="delete from user where user_no=? and power=2";
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,name);
            int count=stat.executeUpdate();
            if (count>0)succ=true;
            if(succ){
                Out.deleteSuccess();
                succ=UserView.comment();
            }else Out.error();
        } catch (Exception e) {
            Out.error();
        }finally {
            LoginUtil.close(null,stat,conn);
        }
        return succ;
    }

    @Override
    public boolean insertFu_Manger() {
        return false;
    }

    @Override
    public boolean deleteFu_Manger(String name) {
        return false;
    }

    @Override
    //查余额
    public boolean selectMoney(Map<String,String> userLogin) {
        boolean a=false;
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            String loginname=userLogin.get("loginname");
            String sql="select mony from user where user_no = ?";
            conn= LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,loginname);
            rs=stat.executeQuery();
            if (rs.next()){
                UserView.selectMoney(rs);
                a=true;
            }
            if(a)UserView.comment();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        if (a==false)Out.error();

        return a;
    }

    @Override
    //查记录
    public boolean saveMoney(Map<String, String> userLogin) {
        boolean a=false;
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        int i=0;
        try {
            String loginname=userLogin.get("loginname");
            conn= LoginUtil.getoCnnetion();
            String sql="select record from record where user_no= ?";
            stat=conn.prepareStatement(sql);
            stat.setString(1,loginname);
            rs=stat.executeQuery();
            while (rs.next()){
                UserView.setMoney(rs);
                a=true;
                i++;
                if(i==5)break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        if(!a)System.out.println("输入错误");
        if (a)UserView.comment();
        return a;
    }
}
