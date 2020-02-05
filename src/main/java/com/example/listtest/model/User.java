package com.example.listtest.model;

import java.util.Date;

public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_telephone;
    private String user_address;
    private String user_email;
    private int user_power;
    private Date user_date;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_telephone() {
        return user_telephone;
    }

    public void setUser_telephone(String user_telephone) {
        this.user_telephone = user_telephone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getUser_power() {
        return user_power;
    }

    public void setUser_power(int user_power) {
        this.user_power = user_power;
    }

    public Date getUser_date() {
        return user_date;
    }

    public void setUser_date(Date user_date) {
        this.user_date = user_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_telephone='" + user_telephone + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_power=" + user_power +
                ", user_date=" + user_date +
                '}';
    }
}
