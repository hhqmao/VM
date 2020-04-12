package com.maohaoqiang.www.util;

import java.sql.*;
import java.util.Map;

public class LoginUtil {
    private LoginUtil(){}
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取链接
    public static Connection getoCnnetion()throws Exception{
        return DriverManager.getConnection("jdbc:mysql://192.168.1.5:3306/take_out?serverTimezone=GMT%2B8","root","mhq647");
    }
    //conn:数据库连接对象
    //stat:数据库操作对象
    //rs:结果集

    //释放资源
    public static void close(ResultSet rs,Statement stat,Connection conn){
        if (rs!=null){
            try {
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }if (stat!=null){
            try {
                stat.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }if (conn!=null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}