package com.restaurant.foodpanda.Restaurant;

import com.restaurant.foodpanda.Restaurant.RestaurantMenu.RestaurantMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return restaurantService.getRestaurant(id).get();
    }

    @PostMapping
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public void updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        restaurant.setId(id);
        restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/{restaurantId}/menu")
    public List<RestaurantMenu> getAllMenusByRestaurant(@PathVariable Long restaurantId) {
        return restaurantService.getMenuListByRestaurant(restaurantId);
    }

    @GetMapping("/menu/{id}")
    public RestaurantMenu getMenuByIdByRestaurant(@PathVariable Long id) {
        return restaurantService.getMenu(id);
    }

    @PostMapping("/{restaurantId}/menu")
    public void addRestaurantMenu(@PathVariable Long restaurantId, @RequestBody RestaurantMenu restaurantMenu) {

        // find that the restaurantId is valid i.e. restaurant exists.
        Optional<Restaurant> optionalRestaurant = restaurantService.getRestaurant(restaurantId);

        if (optionalRestaurant.isPresent()) {
            restaurantMenu.setRestaurant(optionalRestaurant.get());
            // then add the restaurantMenu row in the table.
            restaurantService.addMenu(restaurantMenu);
        } else {
            throw new IllegalArgumentException("Restaurant not found with the id: " + restaurantId);
        }
    }

    @PutMapping("/menu/{id}")
    public void updateRestaurantMenu(@PathVariable Long id, @RequestBody RestaurantMenu restaurantMenu) {
        restaurantMenu.setId(id);
        restaurantService.updateMenu(restaurantMenu);
    }

    @DeleteMapping("/menu/{id}")
    public void deleteRestaurantMenu(@PathVariable Long id) {
        restaurantService.deleteMenu(id);
    }
}

