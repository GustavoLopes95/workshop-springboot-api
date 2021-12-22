package com.workshopspringboot.workshopspringboot.application.services;

import com.workshopspringboot.workshopspringboot.core.exceptions.ResourceNotFoundException;
import com.workshopspringboot.workshopspringboot.data.CategoryRepository;
import com.workshopspringboot.workshopspringboot.data.OrderRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.Category;
import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryAppService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
