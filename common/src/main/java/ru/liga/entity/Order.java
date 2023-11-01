package ru.liga.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.liga.enums.OrderStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@Accessors(chain = true)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;


    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "timestamp")
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis()
    );
}
