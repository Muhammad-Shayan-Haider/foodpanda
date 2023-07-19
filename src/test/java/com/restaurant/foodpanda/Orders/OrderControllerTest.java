package com.restaurant.foodpanda.Orders;

import com.restaurant.foodpanda.Orders.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderControllerTest {

    @Test
    public void testCreateOrderRequest() {
        // Arrange
        OrderController orderController = new OrderController();
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        // Act
        Order order = orderController.createOrderRequest(orderDetailsDTO);

        // Assert
        assertNotNull(order);
    }

    @Test
    public void testGetOrdersAgainstCustomer() {
        // Arrange
        OrderController orderController = new OrderController();
        Long customerId = 1L;

        // Act
        List<Order> orders = orderController.getOrdersAgainstCustomer(customerId);

        // Assert
        assertNotNull(orders);
    }
}