package com.workshopspringboot.workshopspringboot.application.controllers;

import com.workshopspringboot.workshopspringboot.application.resourcers.UserFindAllResource;
import com.workshopspringboot.workshopspringboot.application.resourcers.UserGetOrdersResource;
import com.workshopspringboot.workshopspringboot.application.responses.PagingResponse;
import com.workshopspringboot.workshopspringboot.application.responses.ResponsePageable;
import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import com.workshopspringboot.workshopspringboot.services.UserService;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<PagingResponse<User>> findAll(UserFindAllResource spec, Pageable pageable) {
        var pages = service.findAll(spec, pageable);
        return ResponseEntity.ok().body(new PagingResponse(new ResponsePageable(pages.getTotalElements(), pages.getNumber(), pages.getSize(), pageable.getOffset(), pages.getTotalPages()), pages.getContent()));
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<User> find(@PathVariable Long id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping( value = "/{id}/order")
    public ResponseEntity<PagingResponse<Order>> getOrders(@PathVariable Long id, UserGetOrdersResource spec, Pageable pageable) {
        var pages = service.findAllOrders(id, spec, pageable);
        return ResponseEntity.ok().body(new PagingResponse(new ResponsePageable(pages.getTotalElements(), pages.getNumber(), pages.getSize(), pageable.getOffset(), pages.getTotalPages()), pages.getContent()));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User obj) {
        var entity = service.insert(obj);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping( value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        var entity = service.update(id, user);
        return ResponseEntity.ok().body(entity);
    }
}
