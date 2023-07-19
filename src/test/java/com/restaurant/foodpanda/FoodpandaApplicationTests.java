package com.restaurant.foodpanda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodpandaApplicationTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderController orderController;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantController restaurantController;

    @Test
    void contextLoads() {
    }

    @Test
    void orderServiceBeanLoads() {
        assertNotNull(orderService);
    }

    @Test
    void orderControllerBeanLoads() {
        assertNotNull(orderController);
    }

    @Test
    void restaurantServiceBeanLoads() {
        assertNotNull(restaurantService);
    }

    @Test
    void restaurantControllerBeanLoads() {
        assertNotNull(restaurantController);
    }
}
