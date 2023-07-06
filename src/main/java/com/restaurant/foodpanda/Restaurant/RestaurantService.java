package com.restaurant.foodpanda.Restaurant;

import com.restaurant.foodpanda.Restaurant.RestaurantMenu.RestaurantMenu;
import com.restaurant.foodpanda.Restaurant.RestaurantMenu.RestaurantMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    public List<RestaurantMenu> getMenuListByRestaurant(Long restaurantId) {
        return restaurantMenuRepository.findByRestaurantId(restaurantId);
    }

    public RestaurantMenu getMenu(Long menuId) {
        return restaurantMenuRepository.findById(menuId).get();
    }

    public void addMenu(RestaurantMenu restaurantMenu) {
        restaurantMenuRepository.save(restaurantMenu);
    }

    public void updateMenu(RestaurantMenu restaurantMenu) {
        restaurantMenuRepository.save(restaurantMenu);
    }

    public void deleteMenu(Long id) {
        restaurantMenuRepository.deleteById(id);
    }
}
