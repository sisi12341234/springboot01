package com.example.listtest.model;

public class Pet {
    private int pet_id;//自增
    private String pet_type;
    private int pet_age;
    private String pet_picture;
    private String pet_introduction;
    private int pet_price;

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getPet_type() {
        return pet_type;
    }

    public void setPet_type(String pet_type) {
        this.pet_type = pet_type;
    }

    public int getPet_age() {
        return pet_age;
    }

    public void setPet_age(int pet_age) {
        this.pet_age = pet_age;
    }

    public String getPet_picture() {
        return pet_picture;
    }

    public void setPet_picture(String pet_picture) {
        this.pet_picture = pet_picture;
    }

    public String getPet_introduction() {
        return pet_introduction;
    }

    public void setPet_introduction(String pet_introduction) {
        this.pet_introduction = pet_introduction;
    }

    public int getPet_price() {
        return pet_price;
    }

    public void setPet_price(int pet_price) {
        this.pet_price = pet_price;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "pet_id=" + pet_id +
                ", pet_type='" + pet_type + '\'' +
                ", pet_age=" + pet_age +
                ", pet_picture='" + pet_picture + '\'' +
                ", pet_introduction='" + pet_introduction + '\'' +
                ", pet_price=" + pet_price +
                '}';
    }
}
