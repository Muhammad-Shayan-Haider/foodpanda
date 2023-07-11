package com.restaurant.foodpanda.Orders;

import com.restaurant.foodpanda.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByCustomer(Customer customer);
}
