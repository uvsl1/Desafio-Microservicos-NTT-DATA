package com.ugovslima.order_simulator.controller;

import com.ugovslima.order_simulator.dtos.OrderSimulatorRequestDTO;
import com.ugovslima.order_simulator.dtos.OrderSimulatorResponseDTO;
import com.ugovslima.order_simulator.service.OrderSimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class OrderSimulatorController {

    @Autowired
    private OrderSimulatorService orderSimulatorService;

    @PostMapping("/simular")
    public ResponseEntity<OrderSimulatorResponseDTO> simulateOrder(@RequestBody OrderSimulatorRequestDTO request) {
        OrderSimulatorResponseDTO response = orderSimulatorService.simulateOrder(request);
        return ResponseEntity.ok(response);
    }
}