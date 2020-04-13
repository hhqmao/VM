package com.maohaoqiang.www.dao;

import com.maohaoqiang.www.po.Menu;
import com.maohaoqiang.www.util.JudgeMenu;
import com.maohaoqiang.www.util.LoginUtil;
import com.maohaoqiang.www.service.UserChoice;
import com.maohaoqiang.www.view.DecideView;
import com.maohaoqiang.www.view.MenuView;
import com.maohaoqiang.www.view.Out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class MenuDaoImpl implements MenuDao {
    @Override
    public boolean insert(Map<String,String> userlogin,Menu menu){
        String sql="insert into menu (view,menu,from1,cash,number) values (?,?,?,?,?)";
        Connection conn= null;
        int count=0;
        PreparedStatement stat=null;
        boolean a=true;
        try {
            conn= LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            if(JudgeMenu.judguMenu(userlogin,menu.getView())) {
                stat.setInt(1,menu.getView());
            }
            stat.setString(2,menu.getMenu());
            stat.setString(3,menu.getFrom());
            stat.setInt(4,menu.getCash());
            stat.setInt(5,menu.getNumber());
            count=stat.executeUpdate();
            if (count>0)a=false;
        } catch (Exception e) {
            Out.error();
        }finally {
            LoginUtil.close(null,stat,conn);
        }
        if (!a)Out.noerror();
        return a;
    }

    @Override
    public boolean delect(String menu,Map<String,String> userlogin) {
        String sql="delete from menu where view=(select view from user where user_no=?) and menu=?";
        boolean a=true;
        Connection conn=null;
        PreparedStatement stat=null;
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,userlogin.get("loginname"));
            stat.setString(2,menu);
            if(stat.executeUpdate()!=0){
                Out.deleteSuccess();
                a=false;
            }
        } catch (Exception e) {
            Out.error();
        }finally {
            LoginUtil.close(null,stat,conn);
        }
        return a;
    }

    @Override
    public  boolean select(String menu,Map<String,String> userlogin) {
        String sql="select * from (select menu.menu '菜名',menu.from1 '菜系',view.view_name '店名' from menu join view on menu.view=view.id) a where 菜名 like ?";
        String fun="";
        Connection conn= null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        boolean a=false;
        String[] num=null;
        int i=0;
        try {
            //实现模糊查询
            conn= LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,'%'+menu+'%');
            rs=stat.executeQuery();
            a=MenuView.searchView(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        if (a){
            a= UserChoice.checkView();//点餐界面功能选择
            if(a){
                    fun= DecideView.decideMenu();
                    a=SetMenuDao.set(fun,userlogin);//实现点餐
            }else Out.error();
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
            String sql=" select menu.menu '菜名',menu.from1 '菜系',view.view_name '店名',menu.number '库存' " +
                    "from menu join view on menu.view=view.id";
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

    @Override
    public boolean updatename(String menu,String newnam) {
        boolean succ=false;
        Connection conn=null;
        PreparedStatement stat=null;
        String sql="update menu set menu=? where menu=?";
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,newnam);
            stat.setString(2,menu);
            int count=stat.executeUpdate();
            if(count!=0){
                Out.updateSuccess();
                succ=true;
            }
        } catch (Exception e) {
            Out.error();
        }finally {
            LoginUtil.close(null,stat,conn);
        }
        return succ;
    }

    @Override
    public boolean updatecash(String menu,String newcash) {
        boolean succ=false;
        Connection conn=null;
        PreparedStatement stat=null;
        String sql="update menu set cash=? where menu=?";
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,newcash);
            stat.setString(2,menu);
            int count=stat.executeUpdate();
            if(count!=0){
                Out.updateSuccess();
                succ=true;
            }
        } catch (Exception e) {
            Out.error();
        }finally {
            LoginUtil.close(null,stat,conn);
        }
        return succ;
    }

    @Override
    public boolean updatenumber(String menu,String newnum) {
        boolean succ=false;
        Connection conn=null;
        PreparedStatement stat=null;
        String sql="update menu set number=number+? where menu=?";
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,newnum);
            stat.setString(2,menu);
            int count=stat.executeUpdate();
            if(count!=0){
                Out.updateSuccess();
                succ=true;
            }
        } catch (Exception e) {
            Out.error();
        }finally {
            LoginUtil.close(null,stat,conn);
        }
        return succ;
    }

    @Override
    public boolean selectChefMenu(Map<String, String> userlogin) {
        boolean succ=false;
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        String sql="select menu from user where view=?";
        try {
            conn=LoginUtil.getoCnnetion();
            stat=conn.prepareStatement(sql);
            stat.setString(1,userlogin.get("loginname"));
            rs=stat.executeQuery();
            if(rs.next()){
                Out.outMenu(rs.getNString("menu"));
                succ=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LoginUtil.close(rs,stat,conn);
        }
        return  succ;
    }
}
