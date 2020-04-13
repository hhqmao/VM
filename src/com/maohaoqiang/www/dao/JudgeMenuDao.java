package com.maohaoqiang.www.dao;

import com.maohaoqiang.www.util.LoginUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JudgeMenuDao {
    public boolean jdugeMenu(String loginname,int view) {
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        boolean jduge=false;
        try {
            conn= LoginUtil.getoCnnetion();
            String sql="select *from user where user_no=? and view=?";
            stat=conn.prepareStatement(sql);
            stat.setString(1,loginname);
            stat.setInt(2,view);
            rs=stat.executeQuery();
            if (rs.next())jduge= true;
        } catch (Exception e) {
            jduge=false;
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        return jduge;
    }
}
