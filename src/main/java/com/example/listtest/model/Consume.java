package com.example.listtest.model;

public class Consume {
    private int consume_id;
    private String consume_name;
    private int consume_user_id;
    private int consume_money;

    public int getConsume_id() {
        return consume_id;
    }

    public void setConsume_id(int consume_id) {
        this.consume_id = consume_id;
    }

    public String getConsume_name() {
        return consume_name;
    }

    public void setConsume_name(String consume_name) {
        this.consume_name = consume_name;
    }

    public int getConsume_user_id() {
        return consume_user_id;
    }

    public void setConsume_user_id(int consume_user_id) {
        this.consume_user_id = consume_user_id;
    }

    public int getConsume_money() {
        return consume_money;
    }

    public void setConsume_money(int consume_money) {
        this.consume_money = consume_money;
    }

    @Override
    public String toString() {
        return "Consume{" +
                "consume_id=" + consume_id +
                ", consume_name='" + consume_name + '\'' +
                ", consume_user_id=" + consume_user_id +
                ", consume_money=" + consume_money +
                '}';
    }
}
