package com.dil.cafecloud.orderservice.service;

import com.dil.cafecloud.model.order.Order;


import java.util.List;

public interface OrderService {
    Order save(Order order);
    Order findById(int id);

    List<Order> findAll();
}
