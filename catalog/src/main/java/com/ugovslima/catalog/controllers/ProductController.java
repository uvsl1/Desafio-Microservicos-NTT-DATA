package com.ugovslima.catalog.controllers;


import com.ugovslima.catalog.domain.Product;
import com.ugovslima.catalog.domain.enums.ProductType;
import com.ugovslima.catalog.dtos.ProductDTO;
import com.ugovslima.catalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        Product savedProduct = productService.addProduct(productDTO);
        ProductDTO responseDTO = new ProductDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getType()
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> listProducts() {
        List<ProductDTO> dtos = productService.listProducts().stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getType()
                ))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getType()
                ))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ProductDTO>> getProductsByType(@PathVariable ProductType tipo) {
        List<ProductDTO> dtos = productService.getProductsByType(tipo).stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getType()
                ))
                .toList();
        return ResponseEntity.ok(dtos);

    }
}
