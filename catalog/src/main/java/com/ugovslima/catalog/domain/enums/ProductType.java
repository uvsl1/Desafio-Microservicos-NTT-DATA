package com.ugovslima.catalog.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductType {

    ELETRONICOS,
    LIVROS,
    ROUPAS,
    ACESSORIOS,
    MOVEIS;

    @JsonCreator
    public static ProductType fromString(String value) {
        return value == null ? null : ProductType.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
