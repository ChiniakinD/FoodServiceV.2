package ru.liga.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Column(name = "status")
    private String status;

    @Column(name = "timestamp")
    private Timestamp timestamp;
}
