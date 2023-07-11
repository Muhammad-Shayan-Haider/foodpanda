package com.restaurant.foodpanda.Orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurant.foodpanda.Customer.Customer;
import com.restaurant.foodpanda.Restaurant.Restaurant;
import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

import java.sql.Time;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time timeOfOrder;
    private Time etaOfDelivery;

    @ManyToOne
    @Lazy
    @JsonIgnore
    private Customer customer;

    private String status;
    private String address;

    @ManyToOne
    @Lazy
    @JsonIgnore
    private Restaurant restaurant;

    private Double orderTotal;

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Orders() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(Time timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    public Time getEtaOfDelivery() {
        return etaOfDelivery;
    }

    public void setEtaOfDelivery(Time etaOfDelivery) {
        this.etaOfDelivery = etaOfDelivery;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
