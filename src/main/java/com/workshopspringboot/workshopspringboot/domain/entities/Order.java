package com.workshopspringboot.workshopspringboot.domain.entities;

import com.workshopspringboot.workshopspringboot.core.domainObjects.DomainEntity;
import com.workshopspringboot.workshopspringboot.domain.enums.OrderStatusEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
@Table( name = "orders")
@Getter
@NoArgsConstructor
public class Order extends DomainEntity {

    @ManyToOne
    @JoinColumn( name = "client_id")
    private User client;

    private Integer status;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "order")
    @Getter(AccessLevel.NONE)
    private Set<OrderItem> items = new HashSet<>();

    @Column( name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column( name = "updated_at")
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

    public Set<OrderItem> getItems() {
        return Collections.unmodifiableSet(items);
    }

    public void addItem(final OrderItem orderItem) {
        if(!orderItem.isValid()) return;

        orderItem.attachOrder(this);

        this.items.add(orderItem);
    }

    public boolean orderItemExists(OrderItem orderItem) {
        return this.items.contains(orderItem);
    }

    public void pay(Payment payment) {
        this.payment = payment;
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

    public Double getTotal() {
        return items.stream().reduce(0.0 , (total, item) -> total + item.getSubTotal(), Double::sum);
    }
}
