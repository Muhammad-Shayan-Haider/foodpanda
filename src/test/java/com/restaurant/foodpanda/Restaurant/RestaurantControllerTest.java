package com.restaurant.foodpanda.Restaurant;

import com.restaurant.foodpanda.Restaurant.RestaurantController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RestaurantControllerTest {

    @Test
    public void testAddMenu() {
        // Arrange
        RestaurantController restaurantController = new RestaurantController();
        RestaurantMenu restaurantMenu = new RestaurantMenu();

        // Act
        RestaurantMenu addedMenu = restaurantController.addMenu(restaurantMenu);

        // Assert
        assertNotNull(addedMenu);
    }

    @Test
    public void testAddRestaurant() {
        // Arrange
        RestaurantController restaurantController = new RestaurantController();
        Restaurant restaurant = new Restaurant();

        // Act
        Restaurant addedRestaurant = restaurantController.addRestaurant(restaurant);

        // Assert
        assertNotNull(addedRestaurant);
    }

    @Test
    public void testDeleteMenu() {
        // Arrange
        RestaurantController restaurantController = new RestaurantController();
        Long id = 1L;

        // Act
        restaurantController.deleteMenu(id);

        // Assert
        // Check if the menu is deleted
    }
}