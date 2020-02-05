package com.example.listtest.model;

import java.util.Date;

public class Wandering {
    private int wandering_id;
    private String wandering_type;
    private String wandering_picture;
    private Date wandering_date;
    private String wandering_health;
    private Boolean wandering_sign;

    public int getWandering_id() {
        return wandering_id;
    }

    public void setWandering_id(int wandering_id) {
        this.wandering_id = wandering_id;
    }

    public String getWandering_type() {
        return wandering_type;
    }

    public void setWandering_type(String wandering_type) {
        this.wandering_type = wandering_type;
    }

    public String getWandering_picture() {
        return wandering_picture;
    }

    public void setWandering_picture(String wandering_picture) {
        this.wandering_picture = wandering_picture;
    }

    public Date getWandering_date() {
        return wandering_date;
    }

    public void setWandering_date(Date wandering_date) {
        this.wandering_date = wandering_date;
    }

    public String getWandering_health() {
        return wandering_health;
    }

    public void setWandering_health(String wandering_health) {
        this.wandering_health = wandering_health;
    }

    public Boolean getWandering_sign() {
        return wandering_sign;
    }

    public void setWandering_sign(Boolean wandering_sign) {
        this.wandering_sign = wandering_sign;
    }

    @Override
    public String toString() {
        return "Wandering{" +
                "wandering_id=" + wandering_id +
                ", wandering_type='" + wandering_type + '\'' +
                ", wandering_picture='" + wandering_picture + '\'' +
                ", wandering_date=" + wandering_date +
                ", wandering_health='" + wandering_health + '\'' +
                ", wandering_sign=" + wandering_sign +
                '}';
    }
}
