package com.bryan.masayu;

public class Recomendation {
    String name;
    Integer image, price;

    public Recomendation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Recomendation(String name, Integer image, Integer price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }
}
