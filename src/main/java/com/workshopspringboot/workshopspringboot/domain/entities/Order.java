package com.workshopspringboot.workshopspringboot.domain.entities;

import com.workshopspringboot.workshopspringboot.core.domainObjects.DomainEntity;
import com.workshopspringboot.workshopspringboot.domain.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table( name = "orders")
@Getter
@NoArgsConstructor
public class Order extends DomainEntity {

    @ManyToOne
    @JoinColumn( name = "client_id")
    private User client;

    private Integer status;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public Order(Long id, User client) {
        this.id = id;
        this.client = client;
        this.status = OrderStatusEnum.WAITING_PAYMENT.getCode();
    }

    public Order(Long id, User client, OrderStatusEnum status) {
        this.id = id;
        this.client = client;
        this.status = status.getCode();
    }

    public OrderStatusEnum getStatus() {
        return OrderStatusEnum.valueOf(status);
    }

    public void pay() {
        status = OrderStatusEnum.PAID.getCode();
    }

    public void toShipping() {
        status = OrderStatusEnum.SHIPPED.getCode();
    }

    public void toDelivery() {
        status = OrderStatusEnum.DELIVERED.getCode();
    }

    public void cancel() {
        status = OrderStatusEnum.CANCELED.getCode();
    }
}
