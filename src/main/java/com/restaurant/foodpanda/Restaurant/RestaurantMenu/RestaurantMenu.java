package com.restaurant.foodpanda.Restaurant.RestaurantMenu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurant.foodpanda.Restaurant.Restaurant;
import jakarta.persistence.*;

@Entity
public class RestaurantMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String meal;
    private Double mealPrice;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    public RestaurantMenu() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Double getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(Double mealPrice) {
        this.mealPrice = mealPrice;
    }

}
