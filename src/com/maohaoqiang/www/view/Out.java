package com.maohaoqiang.www.view;

import java.util.concurrent.SubmissionPublisher;

public class Out {
    public static void error(){
        System.out.println("输入错误");
    }
    public static void noerror(){
        System.out.println("添加成功");
    }
    public static void deleteSuccess(){
        System.out.println("删除成功");
    }
    public static void updateSuccess(){
        System.out.println("更新成功");
    }
    //退出程序
    public static void exit(){
        System.out.println("谢谢光临");
        System.exit(1);
    }
    public static void outMenu(String menu){
        System.out.println(menu);
    }
    public static void loginError(){
        System.out.println("账号或者密码错误");
    }
    public static void outUser(){
        System.out.println("姓名\t\t\t\t邮箱\t\t\t\t电话号码");
    }
    public static void outChef(){
        System.out.println("姓名\t\t窗口");
    }
    public static void selectSuccess(){
        System.out.println("查找成功");
    }
    public static void selectChefMenu(){System.out.println("|菜品|");}
}
