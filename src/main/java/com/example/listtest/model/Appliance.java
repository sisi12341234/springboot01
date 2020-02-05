package com.example.listtest.model;

public class Appliance {
    private int appliance_id;
    private String appliance_name;
    private String appliance_picture;
    private int appliance_price;
    private String appliance_company;
    private int appliance_quantity;
    private int appliance_amount;

    public int getAppliance_id() {
        return appliance_id;
    }

    public void setAppliance_id(int appliance_id) {
        this.appliance_id = appliance_id;
    }

    public String getAppliance_name() {
        return appliance_name;
    }

    public void setAppliance_name(String appliance_name) {
        this.appliance_name = appliance_name;
    }

    public String getAppliance_picture() {
        return appliance_picture;
    }

    public void setAppliance_picture(String appliance_picture) {
        this.appliance_picture = appliance_picture;
    }

    public int getAppliance_price() {
        return appliance_price;
    }

    public void setAppliance_price(int appliance_price) {
        this.appliance_price = appliance_price;
    }

    public String getAppliance_company() {
        return appliance_company;
    }

    public void setAppliance_company(String appliance_company) {
        this.appliance_company = appliance_company;
    }

    public int getAppliance_quantity() {
        return appliance_quantity;
    }

    public void setAppliance_quantity(int appliance_quantity) {
        this.appliance_quantity = appliance_quantity;
    }

    public int getAppliance_amount() {
        return appliance_amount;
    }

    public void setAppliance_amount(int appliance_amount) {
        this.appliance_amount = appliance_amount;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "appliance_id=" + appliance_id +
                ", appliance_name='" + appliance_name + '\'' +
                ", appliance_picture='" + appliance_picture + '\'' +
                ", appliance_price=" + appliance_price +
                ", appliance_company='" + appliance_company + '\'' +
                ", appliance_quantity=" + appliance_quantity +
                ", appliance_amount=" + appliance_amount +
                '}';
    }
}
