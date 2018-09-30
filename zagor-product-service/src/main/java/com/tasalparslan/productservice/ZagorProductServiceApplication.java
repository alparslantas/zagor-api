package com.tasalparslan.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@SpringBootApplication
public class ZagorProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZagorProductServiceApplication.class, args);
	}
}
