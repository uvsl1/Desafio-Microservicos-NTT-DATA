package com.ugovslima.catalog.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ugovslima.catalog.domain.enums.ProductType;

public record ProductDTO(
        Long id,
        @JsonProperty("nome")String name,
        @JsonProperty("descricao") String description,
        @JsonProperty("preco") Double price,
        @JsonProperty("tipo") ProductType type
) {}
