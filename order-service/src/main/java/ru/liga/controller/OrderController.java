package ru.liga.controller;

import org.springframework.web.bind.annotation.*;
import ru.liga.entity.Order;
import ru.liga.entity.OrderList;
import ru.liga.service.OrderSupport;

@RestController
public class OrderController {
    @GetMapping
    public String greeting() {
        return "Hello world";
    }

    @GetMapping("/all")
    public OrderList information() {
        return OrderList.getOrderResponse();
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return OrderSupport.getOrderById(id);
    }

    @PostMapping("/create-order")
    public void createOrder(@RequestBody Order order) {
        OrderSupport.createOrder(order);
    }

    @DeleteMapping("/delete-order/{id}")
    public void deleteOrderById(@PathVariable("id") Long id) {
        OrderSupport.deleteOrderById(id);
    }

    @PutMapping("/put-order/{id}")
    public void updateOrderById(@PathVariable("id") Long id, @RequestBody Order order) {
        OrderSupport.updateOrderById(id, order);
    }
}
