package com.restaurant.foodpanda.Restaurant.RestaurantMenu;

import com.restaurant.foodpanda.Restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {

    List<RestaurantMenu> findByRestaurantId(Long restaurantId);
    RestaurantMenu findByIdAndRestaurant(Long menuId, Restaurant restaurant);
}
