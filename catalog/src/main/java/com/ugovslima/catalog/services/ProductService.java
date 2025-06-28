package com.ugovslima.catalog.services;

import com.ugovslima.catalog.domain.Product;
import com.ugovslima.catalog.dtos.ProductDTO;
import com.ugovslima.catalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        return productRepository.save(product);
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

}
