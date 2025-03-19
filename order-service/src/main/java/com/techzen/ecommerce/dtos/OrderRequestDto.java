package com.techzen.ecommerce.dtos;

import com.techzen.ecommerce.entities.OrderItemsEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private Long id;

    private List<OrderItemsEntity> items;

    private Double totalPrice;
}

