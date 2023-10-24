package ru.liga.entity;

import lombok.Data;
import ru.liga.enums.CourierStatus;

import javax.persistence.*;

@Data
@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CourierStatus status;

    @Column(name = "address")
    private String address;
}
