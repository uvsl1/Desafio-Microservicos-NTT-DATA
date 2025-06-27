package com.ugovslima.catalog.repositories;

import com.ugovslima.catalog.domain.Product;
import com.ugovslima.catalog.domain.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByType(ProductType type);
}
