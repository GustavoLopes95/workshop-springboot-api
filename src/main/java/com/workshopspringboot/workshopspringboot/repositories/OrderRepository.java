package com.workshopspringboot.workshopspringboot.repositories;

import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    List<Order> findByClientId(Long id, Specification<Order> spec, Pageable pageable);
}
