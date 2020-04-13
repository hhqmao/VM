package com.maohaoqiang.www.dao;


import com.maohaoqiang.www.util.LoginUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class StoreDao {
    public static boolean loseMenu(Connection conn, PreparedStatement stat, String fun, Map<String,String> userLogin){
        boolean a=false;
        try {
            conn.setAutoCommit(false);//关闭自动提交
            //库存操作
            String sql ="update menu set number=number-1 where menu=?";
            stat=conn.prepareStatement(sql);
            stat.setString(1,fun);
            int count=stat.executeUpdate();
            //资金操作
            sql="update user set mony=mony-(select cash from menu where menu=?) where user_no=?";
            stat=conn.prepareStatement(sql);
            stat.setString(1,fun);
            String s=userLogin.get("loginname");
            stat.setString(2,s);
            count+=stat.executeUpdate();
            //资金加到经理账号上
            sql="update user set mony=mony+(select cash from menu where menu=?) where power=3";
            stat=conn.prepareStatement(sql);
            stat.setString(1,fun);
            count+=stat.executeUpdate();
            //记录消费记录
            sql="insert into record (user_no,record) values (?,?)";
            stat=conn.prepareStatement(sql);
            stat.setString(1,s);
            stat.setString(2,fun);
            count+=stat.executeUpdate();
            if(count==4){
                //若以上都实现，就提交事务
                conn.commit();
                a=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(null,stat,conn);
        }
        return a;
    }
}
