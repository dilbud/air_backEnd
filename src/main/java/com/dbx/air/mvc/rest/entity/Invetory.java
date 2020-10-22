package com.dbx.air.mvc.rest.entity;

public class Invetory {
    private int id;
    private String brand;
    private String type;
    private String description;
    private String price;
    private String expire;

    public Invetory() {
    }

    public Invetory(int id, String brand, String type, String description, String price, String expire) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.price = price;
        this.expire = expire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }
}
