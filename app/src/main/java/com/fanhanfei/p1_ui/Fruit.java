package com.fanhanfei.p1_ui;

public class Fruit {
    private int image_id;
    private String name;

    public Fruit(String name,int image_id) {
        this.image_id = image_id;
        this.name = name;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
