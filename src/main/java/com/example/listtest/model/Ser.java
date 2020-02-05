package com.example.listtest.model;

public class Ser {
    private int service_id;
    private String service_name;
    private int service_price;
    private String service_introduction;

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_price() {
        return service_price;
    }

    public void setService_price(int service_price) {
        this.service_price = service_price;
    }

    public String getService_introduction() {
        return service_introduction;
    }

    public void setService_introduction(String service_introduction) {
        this.service_introduction = service_introduction;
    }

    @Override
    public String toString() {
        return "Ser{" +
                "service_id=" + service_id +
                ", service_name='" + service_name + '\'' +
                ", service_price=" + service_price +
                ", service_introduction='" + service_introduction + '\'' +
                '}';
    }
}
