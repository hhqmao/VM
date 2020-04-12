package com.maohaoqiang.www.po;

public class Power {
    private int id;
    private String power_nam;

    public Power() {}

    public Power(int id, String power_nam) {
        this.id = id;
        this.power_nam = power_nam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPower_nam() {
        return power_nam;
    }

    public void setPower_nam(String power_nam) {
        this.power_nam = power_nam;
    }
}
