package com.techzen.ecommerce.controller;

import com.techzen.ecommerce.dtos.ProductDto;
import com.techzen.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    @GetMapping("/fetchOrder")
    public String fetchFromOrderService() {
        ServiceInstance orderService = discoveryClient.getInstances("order-service").get(0);

        return restClient.get()
                .uri(orderService.getUri()+"/api/v1/orders/helloOrders")
                .retrieve()
                .body(String.class);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        log.info("Fetching all products via controller");
        List<ProductDto> inventories = productService.getAllProducts();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        log.info("Fetching product by id via controller");
        ProductDto inventory = productService.getProductById(id);
        return ResponseEntity.ok(inventory);
    }
}
