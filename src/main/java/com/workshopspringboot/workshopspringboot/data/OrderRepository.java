package com.workshopspringboot.workshopspringboot.data;


import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import com.workshopspringboot.workshopspringboot.domain.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
