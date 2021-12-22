package com.workshopspringboot.workshopspringboot.domain.enums;

public enum OrderStatusEnum {
    WAITING_PAYMENT(100),
    PAID(200),
    SHIPPED(300),
    DELIVERED(400),
    CANCELED(500);

    private int code;

    private OrderStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatusEnum valueOf(int code) {
        for(OrderStatusEnum value : OrderStatusEnum.values()) {
            if(value.getCode() == code) return value;
        }
        return null;
    }
}
