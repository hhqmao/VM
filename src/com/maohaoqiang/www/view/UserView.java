package com.maohaoqiang.www.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserView {
    //用户的基本页面
    public static String basicUserView(){
        System.out.println("欢迎使用WE外卖系统");
        System.out.println("******功能******");
        System.out.println("  1.查看窗口");
        System.out.println("  2.搜索菜品");
        System.out.println("  3.个人中心");
        System.out.println("    4.退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
    //厨师的初始页面
    public static String basicUnUserView(){
        System.out.println("******功能******");
        System.out.println("    1.管理");
        System.out.println("    2.外卖");
        System.out.println("    3.退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
    //厨师的功能页面
    public static String chefView(){
        System.out.println("******功能******");
        System.out.println("  1.添加菜品");
        System.out.println("  2.下架菜品");
        System.out.println("  3.更新菜品");
        System.out.println("  4.查看菜品");
        System.out.println("    5.返回");
        System.out.println("    6.退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
    //查看账户余额
    public static void selectMoney(ResultSet rs) throws SQLException {
            System.out.println("您的余额还剩："+rs.getInt("mony"));
    }
    //遍历最近五条消费记录
    public static void setMoney(ResultSet rs) throws SQLException {
            String fun=rs.getNString("record");
            System.out.println(fun);
    }
    public static boolean comment(){
        boolean a=false;
        System.out.println("******功能******");
        System.out.println("1.返回\t\t2.退出");
        System.out.print("您的选择是：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        if (fun.equalsIgnoreCase("退出")||fun.equalsIgnoreCase("2"))Out.exit();
        return a;
    }
}
