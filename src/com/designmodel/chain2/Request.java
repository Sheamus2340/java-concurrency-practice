package com.designmodel.chain2;

/**
 * Created by Sheamus on 2018/6/26.
 */
public class Request {

    private String name;
    private int days;
    private String reason;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Request(String name, int days, String reason) {
        this.name = name;
        this.days = days;
        this.reason = reason;
    }
}
