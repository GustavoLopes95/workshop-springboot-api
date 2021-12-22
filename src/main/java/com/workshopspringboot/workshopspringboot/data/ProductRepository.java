package com.workshopspringboot.workshopspringboot.data;


import com.workshopspringboot.workshopspringboot.domain.entities.Category;
import com.workshopspringboot.workshopspringboot.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
