package com.bryan.masayu;

public class Food {
    String nameFood, image, description, ingredients, step;
    Integer price;

    public Food(){

    }
    public Food(String nameFood, String image, String description, String ingredients, String step, Integer price) {
        this.nameFood = nameFood;
        this.image = image;
        this.description = description;
        this.ingredients = ingredients;
        this.step = step;
        this.price = price;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

