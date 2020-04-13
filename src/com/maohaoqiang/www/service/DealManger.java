package com.maohaoqiang.www.service;

import com.maohaoqiang.www.dao.UserDaoImpl;
import com.maohaoqiang.www.view.MangerView;
import com.maohaoqiang.www.view.Out;

import java.util.Map;

public class DealManger {
    public static boolean manger(String fun, boolean decide, Map<String,String> userlogin){
        String fun2="";
        UserDaoImpl userDao=new UserDaoImpl();
        if(fun.equalsIgnoreCase("1")||fun.equalsIgnoreCase("管理")
        ||fun.equalsIgnoreCase("2")||fun.equalsIgnoreCase("退出")){
            if(fun.equalsIgnoreCase("1")||fun.equalsIgnoreCase("管理")){
                fun2=MangerView.manageSecond();//获得下一步操作的指令
                while (decide){
                    if(fun2.equalsIgnoreCase("查看用户")||fun2.equalsIgnoreCase("1")||
                            fun2.equalsIgnoreCase("管理厨师")||fun2.equalsIgnoreCase("2")||
                            fun2.equalsIgnoreCase("查看收入")||fun2.equalsIgnoreCase("3")||
                            fun2.equalsIgnoreCase("返回")||fun2.equalsIgnoreCase("4")||
                            fun2.equalsIgnoreCase("退出")||fun2.equalsIgnoreCase("5")){
                        if(fun2.equalsIgnoreCase("查看用户")||fun2.equalsIgnoreCase("1")){
                            decide=userDao.selectUser();
                        }
                        if(fun2.equalsIgnoreCase("管理厨师")||fun2.equalsIgnoreCase("2")){
                            String choice=MangerView.mangeChef();//获得下一步操作的指令
                            if (choice.equalsIgnoreCase("增加厨师")||choice.equalsIgnoreCase("1")||
                                    choice.equalsIgnoreCase("删除厨师")||choice.equalsIgnoreCase("2")||
                                    choice.equalsIgnoreCase("查看厨师")||choice.equalsIgnoreCase("3")||
                                    choice.equalsIgnoreCase("返回")||choice.equalsIgnoreCase("4")||
                                    choice.equalsIgnoreCase("退出")||choice.equalsIgnoreCase("5")){
                                if(choice.equalsIgnoreCase("增加厨师")||choice.equalsIgnoreCase("1")){
                                    decide=userDao.insertChef();
                                }
                                if ( choice.equalsIgnoreCase("删除厨师")||choice.equalsIgnoreCase("2")){
                                    String name=MangerView.deleteChef();
                                    decide=userDao.deleteChef(name);
                                }
                                if(choice.equalsIgnoreCase("查看厨师")||choice.equalsIgnoreCase("3")){
                                    decide=userDao.selectChef();
                                }
                                if (choice.equalsIgnoreCase("返回")||choice.equalsIgnoreCase("4"))decide=false;
                                if (choice.equalsIgnoreCase("退出")||choice.equalsIgnoreCase("5"))Out.exit();
                            }
                        }
                        if (fun2.equalsIgnoreCase("查看收入")||fun2.equalsIgnoreCase("3")){
                            decide=userDao.selectMoney(userlogin);
                        }
                        if(fun2.equalsIgnoreCase("返回")||fun2.equalsIgnoreCase("4"))decide=false;
                        if (fun2.equalsIgnoreCase("退出")||fun2.equalsIgnoreCase("5"))Out.exit();
                    }
                }
            }else Out.exit();
        }else Out.error();
        return decide;
    }
}
