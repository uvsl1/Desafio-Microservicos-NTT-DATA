package com.ugovslima.order_simulator.client;

import com.ugovslima.order_simulator.dtos.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "catalog-microservice")
public interface ProductClient {

    @GetMapping("/produtos")
    List<ProductDTO> getProducts();

    @GetMapping("/produtos/id/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);
}
