package com.techzen.ecommerce.controller;

import com.techzen.ecommerce.dtos.OrderRequestDto;
import com.techzen.ecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/helloOrders")
    public String helloOrders(){
        return "Hello from OrderService";
    }

    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrders(){
        log.info("Fetching all orders via controller");
        List<OrderRequestDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id){
        log.info("Fetching order by id via controller");
        OrderRequestDto order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

}