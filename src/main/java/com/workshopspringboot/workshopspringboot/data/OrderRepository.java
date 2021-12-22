package com.workshopspringboot.workshopspringboot.data;


import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
