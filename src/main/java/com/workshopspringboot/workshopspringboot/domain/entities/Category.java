package com.workshopspringboot.workshopspringboot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workshopspringboot.workshopspringboot.core.domainObjects.DomainEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Category extends DomainEntity {

    private String name;

    @OneToMany
    @Getter(AccessLevel.NONE)
    private Set<Product> products = new HashSet<>();

    public Category(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }
}
