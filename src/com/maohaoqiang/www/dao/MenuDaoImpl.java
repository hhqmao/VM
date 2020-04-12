package com.maohaoqiang.www.dao;

import com.maohaoqiang.www.util.LoginUtil;
import com.maohaoqiang.www.service.UserChoice;
import com.maohaoqiang.www.view.MenuView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class MenuDaoImpl implements MenuDao {
    @Override
    public boolean insert(){
        String sql="insert into menu (view,menu,from,cash)"+
                "values (?,?,?,?)";
        Connection conn= null;
        int count=0;
        PreparedStatement stat=null;
        boolean a=false;
        try {
            conn= LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            count=MenuView.insertView(stat);
            if (count>0)a=true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(null,stat,conn);
        }

        return a;
    }

    @Override
    public boolean update(String menu) {
        return false;
    }

    @Override
    public boolean delect(String menu) {
        return false;
    }

    @Override
    public  boolean select(String menu,Map<String,String> userlogin) {
        String sql="select * from (select menu.menu '菜名',menu.from '菜系',view.view_name '店名' from menu join view on menu.view=view.id) a where 菜名 like ?";
        String fun="";
        Connection conn= null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        boolean a=false;
        try {
            //实现模糊查询
            conn= LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,'%'+menu+'%');
            rs=stat.executeQuery();
            if((fun=MenuView.searchView(rs))!=null)a=true;
            else a=false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        if (a){
            a= UserChoice.checkView();//点餐界面功能选择
            if(a)a= SetMenuDao.set(fun,userlogin);//实现点餐
            if(a)a=false;
        }
        return a;
    }

    @Override
    public  void selectAll() {
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            //注册驱动，获取连接
            conn= LoginUtil.getoCnnetion();
            String sql=" select menu.menu '菜名',menu.from '菜系',view.view_name '店名' from menu join view on menu.view=view.id;";
            //预处理sql语句
            stat=conn.prepareStatement(sql);
            rs=stat.executeQuery();
            //若sql语句执行成功，就遍历菜品反之则返回初始界面
            MenuView.menuView(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
    }
}
