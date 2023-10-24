package ru.liga.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.liga.entity.Order;
import ru.liga.entity.OrderList;

import java.util.List;

public class OrderSupport {
    public static Order getOrder() {
        return new Order();
    }

    public static OrderList getOrders() {
        return OrderList.getOrderResponse();
    }

    public static Order getOrderById(Long id) {
        return OrderList.getOrderResponse()
                .getListOfOrder()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public static void createOrder(Order order) {
        OrderList.getOrderResponse().getListOfOrder().add(order);
    }
    public static void deleteOrderById(Long id) {
        OrderList.getOrderResponse().getListOfOrder().removeIf(order -> order.getId().equals(id));
    }
    public static void updateOrderById(@PathVariable Long id, @RequestBody Order order) {
        Order existingOrder = OrderSupport.getOrderById(id);
        existingOrder.setTimestamp(order.getTimestamp());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setName(order.getName());
    }
}
