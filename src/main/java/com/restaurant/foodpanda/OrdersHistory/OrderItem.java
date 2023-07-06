package com.restaurant.foodpanda.OrdersHistory;

import com.restaurant.foodpanda.Orders.Orders;
import com.restaurant.foodpanda.Restaurant.RestaurantMenu.RestaurantMenu;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(OrderItem.OrderItemId.class)
public class OrderItem {

    private Integer quantity;

    @Id
    @ManyToOne
    private Orders orders;

    @Id
    @ManyToOne
    private RestaurantMenu restaurantMenu;

    public OrderItem() {

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public static class OrderItemId implements Serializable {
        private Long orders;
        private Long restaurantMenu;

        public OrderItemId() {

        }

        public OrderItemId(Long order, Long restaurantMenu) {
            this.orders = order;
            this.restaurantMenu = restaurantMenu;
        }

        public Long getOrders() {
            return orders;
        }

        public void setOrders(Long order) {
            this.orders = order;
        }

        public Long getRestaurantMenu() {
            return restaurantMenu;
        }

        public void setRestaurantMenu(Long restaurantMenu) {
            this.restaurantMenu = restaurantMenu;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof OrderItemId that)) return false;
            return Objects.equals(orders, that.orders) && Objects.equals(restaurantMenu, that.restaurantMenu);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orders, restaurantMenu);
        }
    }
}
