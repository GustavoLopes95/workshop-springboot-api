package com.workshopspringboot.workshopspringboot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workshopspringboot.workshopspringboot.core.domainObjects.DomainEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Product extends DomainEntity {

    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    @Column( name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column( name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToMany
    @JoinTable( name = "product_category",
            joinColumns = @JoinColumn( name = "product_id"),
            inverseJoinColumns = @JoinColumn( name = "category_id"))
    @Getter(AccessLevel.NONE)
    private Set<Category> categories = new HashSet<>();


    public Product(Long id, String name, String description, Double price, String imgUrl) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return Collections.unmodifiableSet(categories);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }
}
