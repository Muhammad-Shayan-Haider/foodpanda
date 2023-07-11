package com.restaurant.foodpanda.Orders.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderDetailsDTO {

    @JsonProperty("order")
    private OrderDTO orderDTO;

    @JsonProperty("orderItems")
    private List<OrderItemDTO> orderItemDTOList;

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public List<OrderItemDTO> getOrderItemDTOList() {
        return orderItemDTOList;
    }

    public void setOrderItemDTOList(List<OrderItemDTO> orderItemDTOList) {
        this.orderItemDTOList = orderItemDTOList;
    }
}
