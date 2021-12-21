package com.workshopspringboot.workshopspringboot.controllers;

import com.workshopspringboot.workshopspringboot.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @RequestMapping("/")
    public ResponseEntity<User> get() {
        var user = new User(1L, "test","user@gmail.com", "99999999", "123456");
        return ResponseEntity.ok().body(user);
    }
}
