package com.tasalparslan.productservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	public String getProducts() {
		logger.info("getting products...");
		return "hi from zagor-product-service products";
	}

	@HystrixCommand(fallbackMethod = "unknownProductSaver")
	public String tryToGetUnknownProducts() {
		logger.info("trying to get products...");
		try {
			Thread.sleep(11000);
		}
		catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
		return "Got it, you are a brave..!";
	}

	public String unknownProductSaver() {
		return "Hi from unknownProductSaver. Don't worry all is under control :) ";
	}
}
