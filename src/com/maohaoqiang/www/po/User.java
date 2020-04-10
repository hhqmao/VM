package com.maohaoqiang.www.po;

public class User {
    private String user_no;
    private String user_paw;
    private String real_name;
    private int power;
    private int view;

    public User() {}

    public User(String user_no, String user_paw, String real_name, int power, int view) {
        this.user_no = user_no;
        this.user_paw = user_paw;
        this.real_name = real_name;
        this.power = power;
        this.view = view;
    }

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getUser_paw() {
        return user_paw;
    }

    public void setUser_paw(String user_paw) {
        this.user_paw = user_paw;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
