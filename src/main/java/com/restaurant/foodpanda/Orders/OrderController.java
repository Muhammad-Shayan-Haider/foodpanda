package com.restaurant.foodpanda.Orders;

import com.restaurant.foodpanda.Orders.DTO.OrderDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public void createOrder(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        orderService.createOrderRequest(orderDetailsDTO);
    }
}
