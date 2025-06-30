package com.ugovslima.order_simulator.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public record OrderSimulatorResponseDTO(
    @JsonProperty("produtos") List<ProductDTO> products,
    BigDecimal total
) {}
