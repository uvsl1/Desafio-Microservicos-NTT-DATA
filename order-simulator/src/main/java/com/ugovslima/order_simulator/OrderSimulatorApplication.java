package com.ugovslima.order_simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSimulatorApplication.class, args);}
}
