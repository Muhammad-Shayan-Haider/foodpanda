package com.restaurant.foodpanda.Orders;

import com.restaurant.foodpanda.Customer.Customer;
import com.restaurant.foodpanda.Customer.CustomerService;
import com.restaurant.foodpanda.Orders.DTO.OrderDetailsDTO;
import com.restaurant.foodpanda.Orders.DTO.OrderItemDTO;
import com.restaurant.foodpanda.OrdersHistory.OrderItem;
import com.restaurant.foodpanda.OrdersHistory.OrderItemRepository;
import com.restaurant.foodpanda.Restaurant.Restaurant;
import com.restaurant.foodpanda.Restaurant.RestaurantMenu.RestaurantMenu;
import com.restaurant.foodpanda.Restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestaurantService restaurantService;


    public Customer getCustomerById(Long id) {
        return customerService.getCustomer(id).get();
    }

    public void createOrderRequest(OrderDetailsDTO orderDetailsDTO) {
        // customer who is placing the order
        Optional<Customer> customer = customerService.getCustomer(orderDetailsDTO
                .getOrderDTO()
                .getCustomerId());

        // restaurant for which order is placed
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(orderDetailsDTO
                .getOrderDTO()
                .getRestaurantId());

        if (customer.isEmpty()) {
            throw new IllegalArgumentException("customer not found");
        }

        if (restaurant.isEmpty()) {
            throw new IllegalArgumentException("restaurant not found");
        }

        // verify the restaurant
        if (isOrderItemsFromSameRestaurant(orderDetailsDTO.getOrderItemDTOList())) {
            // order object creation
            Orders order = createOrder(orderDetailsDTO, customer.get(), restaurant.get());
            orderRepository.save(order);

            // save order history
            List<OrderItem> orderItems = getOrderItems(orderDetailsDTO, order);

            orderItemRepository.saveAll(orderItems);

        } else {
            throw new IllegalArgumentException("meals are not from same restaurant");
        }

    }

    private List<OrderItem> getOrderItems(OrderDetailsDTO orderDetailsDTO, Orders order) {
        List<Long> mealIds = orderDetailsDTO.getOrderItemDTOList().stream().map(OrderItemDTO::getMealId).toList();
        List<RestaurantMenu> meals = restaurantService.getMealsList(mealIds);
        List<OrderItem> orderItems = new ArrayList<>();

        Map<Long, Integer> mealQuantityMap = new HashMap<>();
        for (OrderItemDTO orderItemDTO:
             orderDetailsDTO.getOrderItemDTOList()) {
            mealQuantityMap.put(orderItemDTO.getMealId(), orderItemDTO.getQuantity());
        }

        for (RestaurantMenu meal:
             meals) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrders(order);
            orderItem.setRestaurantMenu(meal);
            orderItem.setQuantity(mealQuantityMap.get(meal.getId()));
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private Orders createOrder(OrderDetailsDTO orderDetailsDTO, Customer customer, Restaurant restaurant) {
        Orders order = new Orders();
        order.setAddress(orderDetailsDTO.getOrderDTO().getAddress());
        order.setTimeOfOrder(Time.valueOf(LocalTime.now()));
        order.setEtaOfDelivery(Time.valueOf(LocalTime.now().plusMinutes(30)));
        Double totalPrice = 0.0;
        for (OrderItemDTO orderItem: orderDetailsDTO.getOrderItemDTOList()) {
            totalPrice += orderItem.getPrice();
        }
        order.setOrderTotal(totalPrice);
        order.setStatus("preparing");
        order.setCustomer(customer);
        order.setRestaurant(restaurant);
        return order;
    }

    private Boolean isOrderItemsFromSameRestaurant(List<OrderItemDTO> orderItemDTOList) {
        List<Long> mealIds = orderItemDTOList.stream().map(OrderItemDTO::getMealId).toList();
        return restaurantService.getRestaurantsByMeals(mealIds).size() == 1;
    }
}
