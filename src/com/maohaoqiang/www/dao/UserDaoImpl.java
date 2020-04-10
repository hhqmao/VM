package com.maohaoqiang.www.dao;


import com.maohaoqiang.www.util.LoginUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean selectUser() {
        return false;
    }

    @Override
    public boolean selectChef() {
        return false;
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
    public boolean insertChef() {
        return false;
    }

    @Override
    public boolean deleteChef(String name) {
        return false;
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
                System.out.println("您的余额还剩："+rs.getInt("mony"));
                System.out.println("********************");
                System.out.println("  返回\t\t退出");
                System.out.print("您的选择是：");
                Scanner scanner=new Scanner(System.in);
                String fun=scanner.nextLine();
                if(fun.equalsIgnoreCase("返回"))a=true;
                if (fun.equalsIgnoreCase("退出")){
                    System.out.println("谢谢光临");
                    System.exit(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        if (a==false)System.out.println("输入错误");
        return a;
    }

    @Override
    public boolean saveMoney(Map<String, String> userLogin) {
        boolean a=false;
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            String loginname=userLogin.get("loginname");
            conn= LoginUtil.getoCnnetion();
            String sql="select record from record where user_no= ?";
            stat=conn.prepareStatement(sql);
            stat.setString(1,loginname);
            rs=stat.executeQuery();
            while (rs.next()!=false){
                String fun=rs.getNString("record");
                System.out.println(fun);
                a=true;
            } if(a){
                a=false;
                System.out.println("******功能******");
                System.out.println("   返回\t\t退出");
                System.out.println("您的选择是");
                Scanner scanner=new Scanner(System.in);
                String fun=scanner.nextLine();
                if(fun.equalsIgnoreCase("返回"))a=true;
                if (fun.equalsIgnoreCase("退出")){
                    System.out.println("谢谢光临");
                    System.exit(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        if(!a)System.out.println("输入错误");
        return a;
    }
}
