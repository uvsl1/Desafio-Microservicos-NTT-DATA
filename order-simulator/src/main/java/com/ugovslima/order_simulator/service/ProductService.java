package com.ugovslima.order_simulator.service;

import com.ugovslima.order_simulator.client.ProductClient;
import com.ugovslima.order_simulator.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductClient productClient;

    public List<ProductDTO> getProducts() {
        return productClient.getProducts();
    }

    public ProductDTO getProductById(Long id) {
        return productClient.getProductById(id);
    }
}
