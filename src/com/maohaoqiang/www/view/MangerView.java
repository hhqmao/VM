package com.maohaoqiang.www.view;

import com.maohaoqiang.www.po.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MangerView {
    public static String manageSecond(){
        System.out.println("********************");
        System.out.println("     1.查看用户");
        System.out.println("     2.管理厨师");
        System.out.println("     3.查看收入");
        System.out.println("       4.返回");
        System.out.println("       5.退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
    public static String mangerFrist(){
        System.out.println("******功能******");
        System.out.println("    1.管理");
        System.out.println("    2.退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
    public static void selectUser(ResultSet rs) throws SQLException {
        String name=rs.getString("real_name");
        String emil=rs.getNString("emil");
        String phone_num=rs.getNString("phone_num");
        System.out.println(name+"|\t\t\t\t"+emil+"|\t\t\t\t"+phone_num);
    }
    public static String mangeChef(){
        System.out.println("******功能******");
        System.out.println("  1.增加厨师");
        System.out.println("  2.删除厨师");
        System.out.println("  3.查看厨师");
        System.out.println("    4.返回");
        System.out.println("    5.退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
    public static User getChef(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("********************");
        System.out.print("输入初始账号：");
        String no=scanner.nextLine();
        System.out.print("输入初始密码：");
        String paw=scanner.nextLine();
        System.out.print("输入姓名：");
        String name=scanner.nextLine();
        System.out.print("输入邮箱：");
        String emil=scanner.nextLine();
        System.out.print("输入手机号码：");
        String phone_num=scanner.nextLine();
        System.out.print("输入窗口：");
        int view=scanner.nextInt();
        User user=new User(no,paw,name,2,view,0,emil,phone_num);
        return user;
    }
    public static String deleteChef(){
        System.out.println("********************");
        System.out.print("输入账号：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
    public static void selectChef(ResultSet rs) throws SQLException {
        System.out.println(rs.getNString("real_name")+"\t\t"+rs.getString("窗口"));
    }
}
