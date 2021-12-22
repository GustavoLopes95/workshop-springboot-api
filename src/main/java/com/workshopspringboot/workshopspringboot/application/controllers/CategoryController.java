package com.workshopspringboot.workshopspringboot.application.controllers;

import com.workshopspringboot.workshopspringboot.application.services.CategoryAppService;
import com.workshopspringboot.workshopspringboot.domain.entities.Category;
import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryAppService service;
    
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        var entities = service.findAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Category> find(@PathVariable Long id) {
        var entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }
}
