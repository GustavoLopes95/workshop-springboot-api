package com.workshopspringboot.workshopspringboot.application.services;

import com.workshopspringboot.workshopspringboot.core.exceptions.ResourceNotFoundException;
import com.workshopspringboot.workshopspringboot.data.OrderRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAppService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
