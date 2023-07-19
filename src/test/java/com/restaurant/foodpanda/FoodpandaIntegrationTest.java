package com.restaurant.foodpanda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FoodpandaIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateOrderRequest() {
        // Arrange
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        // Act
        Order order = this.restTemplate.postForObject("/createOrderRequest", orderDetailsDTO, Order.class);

        // Assert
        assertNotNull(order);
    }

    // Similar test methods for getOrdersAgainstCustomer, addMenu, addRestaurant, and deleteMenu endpoints
}