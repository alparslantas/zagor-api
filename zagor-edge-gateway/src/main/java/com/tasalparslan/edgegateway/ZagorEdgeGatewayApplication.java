package com.tasalparslan.edgegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.tasalparslan.edgegateway.filter.AccessFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZagorEdgeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZagorEdgeGatewayApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	
}
