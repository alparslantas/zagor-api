package com.tasalparslan.cardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tasalparslan.cardservice.service.CardClient;

@RestController
public class CardController {

	@Autowired
	private CardClient cardClient;

	@GetMapping(path = "/hi")
	public String sayHello() {
		return "Hello from zagor-card-service => card controller";
	}

	@GetMapping(path = "/card-product")
	public String getCardProducts() {
		return cardClient.getCardsProducts();
	}

	@HystrixCommand
	@GetMapping(path = "/unknown-card-product")
	public String tryToGetUnknownCardProducts() {
		return cardClient.tryToGetUnknownCardProducts();
	}
}
