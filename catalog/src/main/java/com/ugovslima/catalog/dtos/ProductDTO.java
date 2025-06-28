package com.ugovslima.catalog.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDTO(
        Long id,
        @JsonProperty("nome")String name,
        @JsonProperty("descricao") String description,
        @JsonProperty("preco") Double price
) {}
