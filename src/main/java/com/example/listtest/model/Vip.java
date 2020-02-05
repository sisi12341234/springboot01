package com.example.listtest.model;

import java.util.Date;

public class Vip {
    private int vip_id;
    private String vip_name;
    private String vip_password;
    private String vip_telephone;
    private String vip_address;
    private String vip_email;
    private Date vip_date;
    private String vip_time;

    public int getVip_id() {
        return vip_id;
    }

    public void setVip_id(int vip_id) {
        this.vip_id = vip_id;
    }

    public String getVip_name() {
        return vip_name;
    }

    public void setVip_name(String vip_name) {
        this.vip_name = vip_name;
    }

    public String getVip_password() {
        return vip_password;
    }

    public void setVip_password(String vip_password) {
        this.vip_password = vip_password;
    }

    public String getVip_telephone() {
        return vip_telephone;
    }

    public void setVip_telephone(String vip_telephone) {
        this.vip_telephone = vip_telephone;
    }

    public String getVip_address() {
        return vip_address;
    }

    public void setVip_address(String vip_address) {
        this.vip_address = vip_address;
    }

    public String getVip_email() {
        return vip_email;
    }

    public void setVip_email(String vip_email) {
        this.vip_email = vip_email;
    }

    public Date getVip_date() {
        return vip_date;
    }

    public void setVip_date(Date vip_date) {
        this.vip_date = vip_date;
    }

    public String getVip_time() {
        return vip_time;
    }

    public void setVip_time(String vip_time) {
        this.vip_time = vip_time;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "vip_id=" + vip_id +
                ", vip_name='" + vip_name + '\'' +
                ", vip_password='" + vip_password + '\'' +
                ", vip_telephone='" + vip_telephone + '\'' +
                ", vip_address='" + vip_address + '\'' +
                ", vip_email='" + vip_email + '\'' +
                ", vip_date=" + vip_date +
                ", vip_time='" + vip_time + '\'' +
                '}';
    }
}
