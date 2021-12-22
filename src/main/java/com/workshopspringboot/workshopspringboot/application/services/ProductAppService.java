package com.workshopspringboot.workshopspringboot.application.services;

import com.workshopspringboot.workshopspringboot.core.exceptions.ResourceNotFoundException;
import com.workshopspringboot.workshopspringboot.data.CategoryRepository;
import com.workshopspringboot.workshopspringboot.data.ProductRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.Category;
import com.workshopspringboot.workshopspringboot.domain.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAppService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
