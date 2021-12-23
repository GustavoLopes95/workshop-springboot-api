package com.workshopspringboot.workshopspringboot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workshopspringboot.workshopspringboot.core.domainObjects.DomainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
public class Payment extends DomainEntity {

    @OneToOne
    @JoinColumn( name = "order_id")
    @JsonIgnore
    private Order order;

    @Column( name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column( name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;


    public Payment(Long id, Order order) {
        this.id = id;
        this.order = order;
    }
}
