package com.maohaoqiang.www.po;


public class Menu {
   private int id;
   private int view;
   private String menu;
   private String from;
   private  int cash;
   private  int number;

    public Menu() {
    }

    public Menu( int view, String menu, String from, int cash, int number) {
        this.view = view;
        this.menu = menu;
        this.from = from;
        this.cash = cash;
        this.number = number;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
