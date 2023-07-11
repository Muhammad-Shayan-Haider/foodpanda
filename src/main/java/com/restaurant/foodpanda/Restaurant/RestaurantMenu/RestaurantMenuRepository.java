package com.restaurant.foodpanda.Restaurant.RestaurantMenu;

import com.restaurant.foodpanda.Restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {

    List<RestaurantMenu> findByRestaurantId(Long restaurantId);
    RestaurantMenu findByIdAndRestaurant(Long menuId, Restaurant restaurant);

    @Query("select r from Restaurant r where r.id in (select rm.restaurant.id from RestaurantMenu rm where rm.id in :mealIds)")
    List<Restaurant> findRestaurantsByMenuIds(@Param("mealIds") List<Long> mealIds);
}
