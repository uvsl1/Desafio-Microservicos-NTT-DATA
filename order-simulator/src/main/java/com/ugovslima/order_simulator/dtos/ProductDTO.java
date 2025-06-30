package com.ugovslima.order_simulator.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         @JsonProperty("nome") String name,
                         @JsonProperty("descricao") String description,
                         @JsonProperty("preco") BigDecimal price
) {}
