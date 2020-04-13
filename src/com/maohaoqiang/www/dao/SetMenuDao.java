package com.maohaoqiang.www.dao;


import com.maohaoqiang.www.util.LoginUtil;
import com.maohaoqiang.www.view.UserView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Scanner;

public class SetMenuDao {
    private SetMenuDao(){}
    public static boolean set(String fun, Map<String,String> userLogin){
        boolean a=true;
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            conn= LoginUtil.getoCnnetion();
            String sql="select menu from menu where menu=? ";
            stat=conn.prepareStatement(sql);
            stat.setString(1,fun);
            rs=stat.executeQuery();
            if (rs.next()){
                a= StoreDao.loseMenu(conn,stat,fun,userLogin);//库存、资金、和记录消费记录
                //若库存、资金、和记录消费记录的操作完成才能确定下单成功
                if(a) {
                    System.out.println("       下单成功");
                    a=UserView.comment();
                }else System.out.println("下单失败");
            }else System.out.println("下单失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        return a;
    }
}
