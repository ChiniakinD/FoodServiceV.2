package ru.liga.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class OrderList {
    private List<Order> listOfOrder;

    private static OrderList OrderResponse;
    private OrderList() {
        listOfOrder = new ArrayList<>();
        listOfOrder.add(new Order()
                .setId(1L)
                .setStatus("active")
                .setTimestamp("now")
                .setName("pizza")
                .setUser("123")
                .setPassword("1234"));
        listOfOrder.add(new Order()
                .setId(2L)
                .setStatus("denied")
                .setTimestamp("now")
                .setName("burger")
                .setUser("123")
                .setPassword("1234532423"));
        listOfOrder.add(new Order()
                .setId(3L)
                .setStatus("active")
                .setTimestamp("now")
                .setName("shaurma")
                .setUser("keker")
                .setPassword("1234532423"));
        listOfOrder.add(new Order()
                .setId(4L)
                .setStatus("denied")
                .setTimestamp("now")
                .setName("meat")
                .setUser("reterse")
                .setPassword("1234532423"));
        listOfOrder.add(new Order()
                .setId(5L)
                .setStatus("active")
                .setTimestamp("now")
                .setName("chiken")
                .setUser("retasewqw")
                .setPassword("rewtarewfg423"));
    }

    public static OrderList getOrderResponse() {
        if(OrderResponse == null) {
            OrderResponse = new OrderList();
        }
        return OrderResponse;
    }
}
