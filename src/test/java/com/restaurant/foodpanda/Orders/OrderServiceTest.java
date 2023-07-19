package com.restaurant.foodpanda.Orders;

import com.restaurant.foodpanda.Orders.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    @Test
    public void testCreateOrderRequest() {
        // Arrange
        OrderService orderService = new OrderService();
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        // Act
        Order order = orderService.createOrderRequest(orderDetailsDTO);

        // Assert
        assertNotNull(order);
    }

    @Test
    public void testGetOrdersAgainstCustomer() {
        // Arrange
        OrderService orderService = new OrderService();
        Long customerId = 1L;

        // Act
        List<Order> orders = orderService.getOrdersAgainstCustomer(customerId);

        // Assert
        assertNotNull(orders);
    }
}