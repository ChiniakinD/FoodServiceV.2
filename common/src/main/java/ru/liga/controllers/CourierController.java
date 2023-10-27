package ru.liga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.entity.Courier;
import ru.liga.service.CourierService;

import java.util.List;
@RestController
@RequestMapping("/feign-couriers")

public class CourierController {
    @Autowired
    private CourierService courierService;

    @GetMapping("/{courier_id}")
    public Courier getCourierById(@PathVariable("courier_id") Long id) {
        return courierService.getCourierById(id);
    }
    @GetMapping("/all")
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }
}
