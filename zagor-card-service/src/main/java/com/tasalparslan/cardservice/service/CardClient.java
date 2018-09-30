package com.tasalparslan.cardservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient("zagor-product-service")
@Service
public interface CardClient {

	@RequestMapping("/product")
	String getCardsProducts();

	@RequestMapping("/unknown-product")
	@HystrixCommand(fallbackMethod = "unknownProductSaver")
	String tryToGetUnknownCardProducts();
	

	public default String unknownProductSaver() {
		return "Hi from unknownProductSaver. Don't worry all is under control :) ";
	}
}
