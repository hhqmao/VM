package com.maohaoqiang.www.po;

public class Power {
    private int power;
    private String power_nam;

    public Power() {}

    public Power(int power, String power_nam) {
        this.power = power;
        this.power_nam = power_nam;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getPower_nam() {
        return power_nam;
    }

    public void setPower_nam(String power_nam) {
        this.power_nam = power_nam;
    }
}
