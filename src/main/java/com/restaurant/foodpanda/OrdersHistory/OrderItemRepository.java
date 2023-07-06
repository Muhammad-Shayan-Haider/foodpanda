package com.restaurant.foodpanda.OrdersHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItem.OrderItemId> {
}
