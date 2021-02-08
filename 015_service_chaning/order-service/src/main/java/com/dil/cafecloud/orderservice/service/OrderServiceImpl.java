package com.dil.cafecloud.orderservice.service;

import com.dil.cafecloud.model.customer.Customer;
import com.dil.cafecloud.model.order.Order;
import com.dil.cafecloud.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


    @Override
    public Order findById(int id) {
        Optional<Order> customer=orderRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
