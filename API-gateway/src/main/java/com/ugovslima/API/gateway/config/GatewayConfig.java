package com.ugovslima.API.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("catalog-microservice", r -> r
                        .path("/produtos/**")
                        .uri("lb://catalog-microservice"))
                .route("order-simulator-microservice", r -> r
                        .path("/simular-pedido/**")
                        .uri("lb://order-simulator-microservice"))
                .build();
    }
}
