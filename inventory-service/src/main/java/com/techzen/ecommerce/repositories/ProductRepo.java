package com.techzen.ecommerce.repositories;

import com.techzen.ecommerce.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

}
