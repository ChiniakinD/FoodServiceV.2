package ru.liga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.converters.OrderConverter;
import ru.liga.dto.OrderDTO;
import ru.liga.entity.Customer;
import ru.liga.repository.OrderRepository;
import ru.liga.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/feign-customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customer_id}/history")
    public List<OrderDTO> getAllByCustomerId(@PathVariable("customer_id") Long customer_id) {
        return customerService.getHistoryOfOrders(customer_id);
    }


    @PostMapping("/{customer_id}/create")
    public String createOrder(@PathVariable("customer_id") Long customer_id, @RequestBody OrderDTO orderDTO) {
        return "заказ создан c id " + customerService.createOrder(customer_id, orderDTO);
    }
}
