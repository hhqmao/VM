package com.maohaoqiang.www.util;

import com.maohaoqiang.www.dao.UserDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Scanner;

public class UserViewUtil {
    private UserViewUtil(){}
    public static void selectView(){
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            //注册驱动，获取连接
            conn= LoginUtil.getoCnnetion();
            String sql=" select menu.menu '菜名',menu.from '菜系',view.view_name '店名' from menu join view on menu.view=view.view;";
            //预处理sql语句
            stat=conn.prepareStatement(sql);
            rs=stat.executeQuery();
            System.out.println("菜名\t\t菜系\t\t店名");
            //若sql语句执行成功，就遍历菜品反之则返回初始界面
            while (rs.next()){
                String menu=rs.getNString("菜名");
                String from=rs.getNString("菜系");
                String view_name=rs.getNString("店名");
                System.out.println("————————————————————————————————————————");
                System.out.println(menu+"|\t"+from+"|\t"+view_name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
    }

    public static boolean checkView(){
        boolean a=false;
            System.out.println("********************");
            System.out.println("         点餐");
            System.out.println("         返回");
            System.out.println("         退出");
            System.out.print("您选择：");
            Scanner scanner=new Scanner(System.in);
            String fun=scanner.nextLine();
            if (fun.equalsIgnoreCase("点餐")||fun.equalsIgnoreCase("返回")||fun.equalsIgnoreCase("退出")){
                if(fun.equalsIgnoreCase("点餐"))a=true;
                if (fun.equalsIgnoreCase("返回"))a=false;
                if (fun.equalsIgnoreCase("退出")){
                    System.out.println("谢谢光临");
                    System.exit(1);
            }
        }else System.out.println("输入错误");
        return a;
    }
    public static boolean personalCenter(Map<String,String> userLogin){
        boolean a=false;
        System.out.println("******功能******");
        System.out.println("    查询余额");
        System.out.println("  查询历史记录");
        System.out.println("      返回");
        System.out.println("      退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        UserDaoImpl userDao=new UserDaoImpl();
        String fun=scanner.nextLine();
        if (fun.equalsIgnoreCase("查询余额")||fun.equalsIgnoreCase("查询历史记录")
        ||fun.equalsIgnoreCase("返回")||fun.equalsIgnoreCase("退出")){
            if (fun.equalsIgnoreCase("查询余额")){
                a=userDao.selectMoney(userLogin);
            }
            if(fun.equalsIgnoreCase("查询历史记录")){
                a=userDao.saveMoney(userLogin);
            }
            if (fun.equalsIgnoreCase("返回"))a=false;
            if(fun.equalsIgnoreCase("退出")){
                System.out.println("谢谢光临");
            }
        }else System.out.println("输入错误");
        return a;
    }
}
