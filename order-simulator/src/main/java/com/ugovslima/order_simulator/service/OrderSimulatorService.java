package com.ugovslima.order_simulator.service;

import com.ugovslima.order_simulator.dtos.OrderSimulatorRequestDTO;
import com.ugovslima.order_simulator.dtos.OrderSimulatorResponseDTO;
import com.ugovslima.order_simulator.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderSimulatorService {

    @Autowired
    private ProductService productService;

    public OrderSimulatorResponseDTO simulateOrder(OrderSimulatorRequestDTO request) {
        List<ProductDTO> products = request.productsId().stream()
                .map(productService::getProductById)
                .collect(Collectors.toList());

        BigDecimal total = products.stream()
                .map(ProductDTO::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new OrderSimulatorResponseDTO(products, total);
    }
}
