package com.workshopspringboot.workshopspringboot.repositories;


import com.workshopspringboot.workshopspringboot.domain.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
