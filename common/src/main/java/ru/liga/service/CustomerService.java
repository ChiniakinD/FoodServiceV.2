package ru.liga.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.Timestamp;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.converters.OrderConverter;
import ru.liga.dto.OrderDTO;
import ru.liga.entity.Customer;
import ru.liga.entity.Order;
import ru.liga.enums.OrderStatus;
import ru.liga.repository.CustomerRepository;
import ru.liga.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    private Customer getCustomerById(Long customer_id) {
        return customerRepository.findById(customer_id).orElse(null);
    }


    public Long createOrder(Long customer_id, OrderDTO orderDTO) {
        Order order = OrderConverter.dtoToEntity(orderDTO);
        order.setCustomer(getCustomerById(customer_id));
        order.setCourier(null);
        order.setStatus(OrderStatus.CREATED);
        Order orderRabbit = orderRepository.save(order);
        try {
            String rabbitString = objectMapper.writeValueAsString(orderRabbit);
            rabbitTemplate.convertAndSend("Order-queue", rabbitString);
            return orderRabbit.getId();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<OrderDTO> getHistoryOfOrders(Long customer_id) {
        return orderRepository.findAllByCustomerId(customer_id).stream()
                .map(OrderConverter::entityToDto)
                .collect(Collectors.toList());
    }

    public void acceptOrder(Long order_id) {
        OrderService orderService = new OrderService();
        orderService.getOrderById(order_id).setStatus(OrderStatus.PAID);
    }
}
