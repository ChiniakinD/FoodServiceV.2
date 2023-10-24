package ru.liga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.entity.Courier;
import ru.liga.repository.CourierRepository;
import ru.liga.repository.CustomerRepository;

import java.util.List;

@Service

public class CourierService {
    @Autowired
    private CourierRepository courierRepository;
    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }
}
