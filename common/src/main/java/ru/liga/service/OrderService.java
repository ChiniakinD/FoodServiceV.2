package ru.liga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.entity.Order;
import ru.liga.enums.OrderStatus;
import ru.liga.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order getOrderById(Long order_id) {
        return orderRepository.findById(order_id).orElse(null);
    }
    public void updateOrderById(Long order_id) {
        Order order = getOrderById(order_id);
        order.setStatus(OrderStatus.PAID);
        order = orderRepository.save(order);
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
