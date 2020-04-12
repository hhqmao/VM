package com.maohaoqiang.www.po;

public class View {
    private int id;
    private String view_name;

    public View() {
    }

    public View(int id, String view_name) {
        this.id = id;
        this.view_name = view_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getView_name() {
        return view_name;
    }

    public void setView_name(String view_name) {
        this.view_name = view_name;
    }
}
