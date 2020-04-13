package com.maohaoqiang.www.view;

import java.util.Scanner;

public class DecideView {
    public static String decideView(){
        System.out.println("********************");
        System.out.println("       1.点餐");
        System.out.println("       2.返回");
        System.out.println("       3.退出");
        System.out.print("您选择：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
    public static String decideMenu(){
        System.out.println("********************");
        System.out.print("菜品：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
}
