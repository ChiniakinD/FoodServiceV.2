package ru.liga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.entity.Order;
import ru.liga.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
