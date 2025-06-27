package com.ugovslima.catalog.dtos;

import com.ugovslima.catalog.domain.enums.ProductType;

public record ProductDTO(String name, String description, Double price, ProductType type) {


}
