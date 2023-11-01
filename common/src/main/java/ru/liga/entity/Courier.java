package ru.liga.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.liga.enums.CourierStatus;

import javax.persistence.*;

@Data
@Entity
@Table(name = "couriers")
@Accessors(chain = true)
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CourierStatus status;

    @Column(name = "address")
    private String address;
}
