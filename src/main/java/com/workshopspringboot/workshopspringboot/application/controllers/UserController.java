package com.workshopspringboot.workshopspringboot.application.controllers;

import com.workshopspringboot.workshopspringboot.application.services.UserAppService;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAppService service;
    
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        var users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<User> find(@PathVariable Long id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(user);
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
