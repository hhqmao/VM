package com.maohaoqiang.www.dao;

import com.maohaoqiang.www.util.LoginUtil;
import com.maohaoqiang.www.util.SetMenu;
import com.maohaoqiang.www.util.UserViewUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Scanner;

public class MenuDaoImpl implements MenuDao {
    @Override
    public boolean insert(){
        String sql="insert into menu (view,menu,from,cash)"+
                "values (?,?,?,?)";
        Connection conn= null;
        PreparedStatement stat=null;
        boolean a=false;
        try {
            conn= LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
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
        String sql="select * from (select menu.menu '菜名',menu.from '菜系',view.view_name '店名' from menu join view on menu.view=view.view) a where 菜名 like ?";
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
            System.out.println("菜名\t\t菜系\t\t店名");
            //遍历菜品
            if (rs.next()){
                fun=rs.getNString("菜名");
                System.out.print(rs.getNString("菜名"));
                System.out.print("\t");
                System.out.print(rs.getString("菜系"));
                System.out.print("\t");
                System.out.print(rs.getString("店名"));
                System.out.println();
                a=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        if (a){
            a= UserViewUtil.checkView();//点餐界面功能选择
            if(a)a= SetMenu.set(fun,userlogin);//实现点餐
            if(a)a=false;
        }
        return a;
    }
}
