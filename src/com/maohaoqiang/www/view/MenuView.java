package com.maohaoqiang.www.view;

import com.maohaoqiang.www.po.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuView {
    //遍历菜单
    public static void menuView(ResultSet rs) throws SQLException {
        System.out.println("菜名\t\t菜系\t库存\t店名");
        while (rs.next()){
            String menu=rs.getNString("菜名");
            String from=rs.getNString("菜系");
            String view_name=rs.getNString("店名");
            int num=rs.getInt("库存");
            System.out.println("————————————————————————————————————————");
            System.out.println(menu+"|\t"+from+"|\t"+num+"|\t"+view_name);
        }
    }
    //遍历模糊查询得到的菜单
    public static boolean searchView(ResultSet rs) throws SQLException {
        System.out.println("菜名\t菜系\t数量\t店名");
        boolean a=false;
        //遍历菜品
        while (rs.next()){
            String fun=rs.getNString("菜名");
            System.out.print(rs.getNString("菜名"));
            System.out.print("|\t");
            System.out.print(rs.getString("菜系"));
            System.out.print("|\t");
            System.out.print(rs.getString("库存"));
            System.out.print("|\t");
            System.out.print(rs.getString("店名"));
            System.out.println();
            a=true;
        }
        return a;
    }
    //厨师添加新菜品的界面
    public static Menu insertView() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入菜名：");
        String name=scanner.nextLine();
        System.out.print("输入菜系：");
        String from=scanner.nextLine();
        System.out.print("输入价格：");
        int cash=scanner.nextInt();
        System.out.print("输入数量：");
        int num=scanner.nextInt();
        Menu menu=new Menu(name,from,cash,num);
        return menu;
    }
    //厨师删除菜品的界面
    public static String deleteView(){
        System.out.println("********************");
        System.out.print("输入你想要删除的菜名:");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    //厨师选择对菜品操作的界面
    public static String updateView(){
        System.out.println("********************");
        System.out.println("    1.更新菜名");
        System.out.println("    2.更新价格");
        System.out.println("    3.补充数量");
        System.out.println("      4.返回");
        System.out.println("      5.退出");
        System.out.print("您选择的功能：");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    //厨师更新菜品的界面
    //获得厨师需要操作菜品的名字
    public static String updateChoice(){
        System.out.println("********************");
        System.out.print("输入现有菜名：");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    //厨师更新菜品名字
    public static String getMenuNam(){
        System.out.println("********************");
        System.out.print("输入新菜名：");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    //厨师更新菜品价格
    public static String getMenuCash(){
        System.out.println("********************");
        System.out.print("输入新价格：");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    //厨师补充菜品数量
    public static String getMenuNum(){
        System.out.println("********************");
        System.out.print("输入补充数量：");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
}
