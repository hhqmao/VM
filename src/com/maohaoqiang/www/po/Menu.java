package com.maohaoqiang.www.po;


public class Menu {
    private int view;
    private String menu;
    private int menu_id;
    private String from;

    public Menu() {}

    public Menu(int view, String menu, int menu_id, String from) {
        this.view = view;
        this.menu = menu;
        this.menu_id = menu_id;
        this.from = from;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

}
