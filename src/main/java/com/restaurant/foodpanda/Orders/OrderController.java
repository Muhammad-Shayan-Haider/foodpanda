package com.restaurant.foodpanda.Orders;

import com.restaurant.foodpanda.Orders.DTO.OrderDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public void createOrder(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        orderService.createOrderRequest(orderDetailsDTO);
    }

    @GetMapping("/orders/customer/{customerId}/history")
    public List<Orders> getOrdersHistoryForCustomer(@PathVariable Long customerId) {
        return orderService.getOrdersAgainstCustomer(customerId);
    }
}
