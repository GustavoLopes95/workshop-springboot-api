package com.workshopspringboot.workshopspringboot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.workshopspringboot.workshopspringboot.core.domainObjects.DomainEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends DomainEntity {

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
    private String password;

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany( mappedBy = "client", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @Column( name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column( name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(this.orders);
    }

    public void replaceName(String newName) {
        name = newName;
    }

    public void replacePhone(String newPhone) {
        phone = newPhone;
    }
}
