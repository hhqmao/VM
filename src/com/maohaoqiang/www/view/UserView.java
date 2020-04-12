package com.maohaoqiang.www.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserView {
    public static void BasicUserView(){
        System.out.println("欢迎使用WE外卖系统");
        System.out.println("******功能******");
        System.out.println("    查看窗口");
        System.out.println("    搜索菜品");
        System.out.println("    个人中心");
        System.out.println("      退出");
        System.out.print("您选择的功能：");
    }
    public static boolean selectMoney(ResultSet rs) throws SQLException {
        if (rs.next()){
            System.out.println("您的余额还剩："+rs.getInt("mony"));
            return comment();
        }else return false;
    }
    public static boolean setMoney(ResultSet rs) throws SQLException {
        boolean a=false;
        while (rs.next()!=false){
            String fun=rs.getNString("record");
            System.out.println(fun);
            a=true;
        } if(a){
            a=comment();
        }else return a;
        return a;
    }
    public static boolean comment(){
        boolean a;
        System.out.println("******功能******");
        System.out.println("   返回\t\t退出");
        System.out.print("您的选择是：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        if(fun.equalsIgnoreCase("返回")){
            a=true;
        }else {
            a=false;
        }
        if (fun.equalsIgnoreCase("退出")){
            System.out.println("谢谢光临");
            System.exit(1);
        }
        return a;
    }
}
