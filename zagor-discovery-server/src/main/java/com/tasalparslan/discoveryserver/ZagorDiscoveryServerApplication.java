package com.tasalparslan.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ZagorDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZagorDiscoveryServerApplication.class, args);
	}
}
