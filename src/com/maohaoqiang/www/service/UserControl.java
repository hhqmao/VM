package com.maohaoqiang.www.service;

import com.maohaoqiang.www.dao.MenuDaoImpl;
import com.maohaoqiang.www.dao.SetMenuDao;
import com.maohaoqiang.www.view.UserView;

import java.util.Map;
import java.util.Scanner;

public class UserControl {
    private UserControl(){}
    public static  int userWatch(int judge, Map<String,String> userlogin){
        //a是进行返回功能实现的关键
        boolean decide=false;
        while(!decide){
            if (judge==1){
                UserView.BasicUserView();
                Scanner scanner=new Scanner(System.in);
                String fun=scanner.nextLine();
                decide=true;
                while (decide){
                    if (fun.equalsIgnoreCase("查看窗口")||fun.equalsIgnoreCase("搜索菜品")
                            ||fun.equalsIgnoreCase("退出")||fun.equalsIgnoreCase("个人中心")){
                        if (fun.equalsIgnoreCase("查看窗口")){
                            MenuDaoImpl menuDao=new MenuDaoImpl();
                            menuDao.selectAll();//遍历输出菜品
                            decide= UserChoice.checkView();//点餐界面功能选择
                            if (decide){
                                System.out.print("菜品：");
                                String s=scanner.nextLine();
                                decide= SetMenuDao.set(s,userlogin);//传入菜名和账号信息，实现点餐功能
                            }
                        }
                        if (fun.equalsIgnoreCase("搜索菜品")){
                            System.out.println("————————————————————————————");
                            System.out.print("请输入您要搜索的菜名：");
                            MenuDaoImpl menuDao=new MenuDaoImpl();
                            String s=scanner.nextLine();
                            decide=menuDao.select(s,userlogin);//实现查询功能并且可以实现点餐
                        }
                        if(fun.equalsIgnoreCase("个人中心")){
                            decide= UserChoice.personalCenter(userlogin);//进入个人中心界面
                        }
                        if (fun.equalsIgnoreCase("退出")){
                            System.out.println("谢谢光临");
                            System.exit(1);
                        }
                    }else{
                        System.out.println("输入错误");
                        decide=false;
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