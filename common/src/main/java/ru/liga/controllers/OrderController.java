package ru.liga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.converters.OrderConverter;
import ru.liga.entity.Order;
import ru.liga.entity.Restaurant;
import ru.liga.enums.OrderStatus;
import ru.liga.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/feign-orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/accept/{order_id}")
    public void acceptOrder(@PathVariable("order_id") Long order_id) {
        orderService.updateOrderById(order_id);
        System.out.println("статус поменялся");
    }
    @GetMapping("/{order_id}")
    public Order getOrderById(@PathVariable("order_id") Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
