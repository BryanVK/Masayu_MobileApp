package com.bryan.masayu;

public class Cart {
    String userEmail;
    Integer foodId;

    public Cart(){

    }
    public Cart(String userEmail, Integer foodId) {
        this.userEmail = userEmail;
        this.foodId = foodId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }
}
