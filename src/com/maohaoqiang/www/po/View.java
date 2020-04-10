package com.maohaoqiang.www.po;

public class View {
    private int view;
    private String view_name;

    public View() {
    }

    public View(int view, String view_name) {
        this.view = view;
        this.view_name = view_name;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getView_name() {
        return view_name;
    }

    public void setView_name(String view_name) {
        this.view_name = view_name;
    }
}
