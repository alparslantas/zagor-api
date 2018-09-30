package com.tasalparslan.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tasalparslan.productservice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/hi")
	public String hi() {
		return "hi from zagor-product-service => product controller";
	}

	@GetMapping(path = "/product")
	public String getProducts() {
		return productService.getProducts();
	}

	@HystrixCommand(fallbackMethod = "unknownProductSaverController")
	@GetMapping(path = "/unknown-product")
	public String tryToGetProducts() {
		return productService.tryToGetUnknownProducts();
	}

	public String unknownProductSaverController() {
		return "unknownProductSaverController";
	}
}
