package com.maohaoqiang.www.dao;

import java.util.Map;

public interface UserDao {
    public boolean selectUser();
    public boolean selectChef();
    public boolean selectFu_Manger();
    public boolean selectAll();
    public boolean insertUser();
    public boolean insertChef();
    public boolean deleteChef(String name);
    public boolean insertFu_Manger();
    public boolean deleteFu_Manger(String name);
    public boolean selectMoney(Map<String, String> userLogin);
    public boolean saveMoney(Map<String, String> userLogin);
}