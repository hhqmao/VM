package com.maohaoqiang.www.service;

import com.maohaoqiang.www.dao.MenuDaoImpl;
import com.maohaoqiang.www.util.SetMenu;
import com.maohaoqiang.www.util.UserViewUtil;

import java.util.Map;
import java.util.Scanner;

public class UserView {
    private UserView(){}
    public static  int userWatch(int judge, Map<String,String> userlogin){
        //a是进行返回功能实现的关键
        boolean a=false;
        while(!a){
            if (judge==1){
                System.out.println("欢迎使用WE外卖系统");
                System.out.println("******功能******");
                System.out.println("    查看窗口");
                System.out.println("    搜索菜品");
                System.out.println("    个人中心");
                System.out.println("      退出");
                System.out.print("您选择的功能：");
                Scanner scanner=new Scanner(System.in);
                String fun=scanner.nextLine();
                a=true;
                while (a){
                    if (fun.equalsIgnoreCase("查看窗口")||fun.equalsIgnoreCase("搜索菜品")
                            ||fun.equalsIgnoreCase("退出")||fun.equalsIgnoreCase("个人中心")){
                        if (fun.equalsIgnoreCase("查看窗口")){
                            UserViewUtil.selectView();//遍历输出菜品
                            a= UserViewUtil.checkView();//点餐界面功能选择
                            if (a){
                                System.out.print("菜品：");
                                String s=scanner.nextLine();
                                a= SetMenu.set(s,userlogin);//传入菜名和账号信息，实现点餐功能
                            }
                        }
                        if (fun.equalsIgnoreCase("搜索菜品")){
                            System.out.println("————————————————————————————");
                            System.out.print("请输入您要搜索的菜名：");
                            MenuDaoImpl menuDao=new MenuDaoImpl();
                            String s=scanner.nextLine();
                            a=menuDao.select(s,userlogin);//实现查询功能并且可以实现点餐
                        }
                        if(fun.equalsIgnoreCase("个人中心")){
                            a= UserViewUtil.personalCenter(userlogin);//进入个人中心界面
                        }
                        if (fun.equalsIgnoreCase("退出")){
                            System.out.println("谢谢光临");
                            System.exit(1);
                        }
                    }else{
                        System.out.println("输入错误");
                        a=false;
                    }
                }
            }
            if (judge==2){

            }
            if (judge==3){

            }
            if (judge==4){

            }
        }
        return 0;
    }

}