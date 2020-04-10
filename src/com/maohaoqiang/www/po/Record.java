package com.maohaoqiang.www.po;

public class Record {
    private int id;
    private String user_no;
    private String record;
    public Record(){}

    public Record(int id, String user_no, String record) {
        this.id = id;
        this.user_no = user_no;
        this.record = record;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
