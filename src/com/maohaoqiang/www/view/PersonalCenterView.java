package com.maohaoqiang.www.view;

import java.util.Scanner;

public class PersonalCenterView {
    public static String view(){
        System.out.println("******功能******");
        System.out.println("    查询余额");
        System.out.println("  查询历史记录");
        System.out.println("      返回");
        System.out.println("      退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        String fun=scanner.nextLine();
        return fun;
    }
}
