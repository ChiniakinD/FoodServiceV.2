package ru.liga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.entity.Order;
import ru.liga.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/feign-orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
