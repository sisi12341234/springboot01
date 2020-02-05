package com.example.listtest.model;

import java.util.Date;

public class Adopt {
    private int adopt_id;
    private int adopt_pet_id;
    private int adopt_user_id;
    private String adopt_user_name;
    private String adopt_user_telephone;
    private Date adopt_date;

    public int getAdopt_id() {
        return adopt_id;
    }

    public void setAdopt_id(int adopt_id) {
        this.adopt_id = adopt_id;
    }

    public int getAdopt_pet_id() {
        return adopt_pet_id;
    }

    public void setAdopt_pet_id(int adopt_pet_id) {
        this.adopt_pet_id = adopt_pet_id;
    }

    public int getAdopt_user_id() {
        return adopt_user_id;
    }

    public void setAdopt_user_id(int adopt_user_id) {
        this.adopt_user_id = adopt_user_id;
    }

    public String getAdopt_user_name() {
        return adopt_user_name;
    }

    public void setAdopt_user_name(String adopt_user_name) {
        this.adopt_user_name = adopt_user_name;
    }

    public String getAdopt_user_telephone() {
        return adopt_user_telephone;
    }

    public void setAdopt_user_telephone(String adopt_user_telephone) {
        this.adopt_user_telephone = adopt_user_telephone;
    }

    public Date getAdopt_date() {
        return adopt_date;
    }

    public void setAdopt_date(Date adopt_date) {
        this.adopt_date = adopt_date;
    }

    @Override
    public String toString() {
        return "Adopt{" +
                "adopt_id=" + adopt_id +
                ", adopt_pet_id=" + adopt_pet_id +
                ", adopt_user_id=" + adopt_user_id +
                ", adopt_user_name='" + adopt_user_name + '\'' +
                ", adopt_user_telephone='" + adopt_user_telephone + '\'' +
                ", adopt_date=" + adopt_date +
                '}';
    }
}
