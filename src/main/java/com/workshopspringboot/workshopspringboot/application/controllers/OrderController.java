package com.workshopspringboot.workshopspringboot.application.controllers;

import com.workshopspringboot.workshopspringboot.application.services.OrderAppService;
import com.workshopspringboot.workshopspringboot.application.services.UserAppService;
import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderAppService service;
    
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        var orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Order> find(@PathVariable Long id) {
        var order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }
}