package com.maohaoqiang.www.view;

import java.util.Scanner;

public class DecideView {
    public static String decideView(){
        System.out.println("********************");
        System.out.println("         点餐");
        System.out.println("         返回");
        System.out.println("         退出");
        System.out.print("您选择：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
}
