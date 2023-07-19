package com.restaurant.foodpanda.Restaurant;

import com.restaurant.foodpanda.Restaurant.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RestaurantServiceTest {

    @Test
    public void testAddMenu() {
        // Arrange
        RestaurantService restaurantService = new RestaurantService();
        RestaurantMenu restaurantMenu = new RestaurantMenu();

        // Act
        RestaurantMenu addedMenu = restaurantService.addMenu(restaurantMenu);

        // Assert
        assertNotNull(addedMenu);
    }

    @Test
    public void testAddRestaurant() {
        // Arrange
        RestaurantService restaurantService = new RestaurantService();
        Restaurant restaurant = new Restaurant();

        // Act
        Restaurant addedRestaurant = restaurantService.addRestaurant(restaurant);

        // Assert
        assertNotNull(addedRestaurant);
    }

    @Test
    public void testDeleteMenu() {
        // Arrange
        RestaurantService restaurantService = new RestaurantService();
        Long id = 1L;

        // Act
        restaurantService.deleteMenu(id);

        // Assert
        // Check if the menu is deleted
    }
}