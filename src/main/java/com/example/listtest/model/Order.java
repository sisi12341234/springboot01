package com.example.listtest.model;

import java.util.Date;

public class Order {
    private int order_id;
    private int order_user_id;
    private String order_date;
    private String order_event;
    private String order_telephone;
    private Boolean order_sign;
    private String name;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_user_id() {
        return order_user_id;
    }

    public void setOrder_user_id(int order_user_id) {
        this.order_user_id = order_user_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_event() {
        return order_event;
    }

    public void setOrder_event(String order_event) {
        this.order_event = order_event;
    }

    public String getOrder_telephone() {
        return order_telephone;
    }

    public void setOrder_telephone(String order_telephone) {
        this.order_telephone = order_telephone;
    }

    public Boolean getOrder_sign() {
        return order_sign;
    }

    public void setOrder_sign(Boolean order_sign) {
        this.order_sign = order_sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_user_id=" + order_user_id +
                ", order_date='" + order_date + '\'' +
                ", order_event='" + order_event + '\'' +
                ", order_telephone='" + order_telephone + '\'' +
                ", order_sign=" + order_sign +
                ", name='" + name + '\'' +
                '}';
    }
}
