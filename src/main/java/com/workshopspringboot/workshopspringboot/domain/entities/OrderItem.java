package com.workshopspringboot.workshopspringboot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workshopspringboot.workshopspringboot.domain.vo.OrderItemId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@NoArgsConstructor
@IdClass(OrderItemId.class)
@Getter
public class OrderItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn( name = "order_id")
    @JsonIgnore
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn( name = "product_id")
    private Product product;

    private Integer quantity;
    private Double price;

    @Column( name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column( name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Double getSubTotal() {
        return quantity * price;
    }

    public void attachOrder(Order order) {
        this.order = order;
    }

    // TODO: implement logic
    public boolean isValid() {
        return true;
    }
}
