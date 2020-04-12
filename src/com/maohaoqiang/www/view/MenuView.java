package com.maohaoqiang.www.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuView {
    public static void menuView(ResultSet rs) throws SQLException {
        System.out.println("菜名\t\t菜系\t\t店名");
        while (rs.next()){
            String menu=rs.getNString("菜名");
            String from=rs.getNString("菜系");
            String view_name=rs.getNString("店名");
            System.out.println("————————————————————————————————————————");
            System.out.println(menu+"|\t"+from+"|\t"+view_name);
        }
    }
    public static String searchView(ResultSet rs) throws SQLException {
        System.out.println("菜名\t\t菜系\t\t店名");
        //遍历菜品
        if (rs.next()){
            String fun=rs.getNString("菜名");
            System.out.print(rs.getNString("菜名"));
            System.out.print("\t");
            System.out.print(rs.getString("菜系"));
            System.out.print("\t");
            System.out.print(rs.getString("店名"));
            System.out.println();
            return fun;
        }else {
            return null;
        }
    }
    public static int insertView(PreparedStatement stat) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入窗口:");
        stat.setInt(1,scanner.nextInt());
        System.out.print("输入菜名：");
        stat.setString(2,scanner.nextLine());
        System.out.print("输入菜系：");
        stat.setString(3,scanner.nextLine());
        System.out.print("输入价格：");
        stat.setInt(4,scanner.nextInt());
        int count=stat.executeUpdate();
        return count;
    }
}
