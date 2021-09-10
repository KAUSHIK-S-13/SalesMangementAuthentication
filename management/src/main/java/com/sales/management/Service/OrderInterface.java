package com.sales.management.Service;

import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.OrderDTO;
import com.sales.management.Model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderInterface {
    Order addOrder(OrderDTO orderDTO);

    Optional<Order> updateOrder(OrderDTO orderDTO);

    List<Order> getAllOrder();

    Optional<Order> deleteOrder(OrderDTO orderDTO);
}
