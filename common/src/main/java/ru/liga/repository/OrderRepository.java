package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.dto.OrderDTO;
import ru.liga.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findAllByCustomerId(Long customer_id);
}
