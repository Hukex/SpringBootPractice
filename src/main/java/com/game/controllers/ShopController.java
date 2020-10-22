package com.game.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.dtos.request.ShopRequest;
import com.game.services.ShopService;

@RestController
public class ShopController {

	@Autowired
	private ShopService shopService;

	@GetMapping("/shop")
	ResponseEntity<Object> getShopById(@RequestParam("name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(shopService.getShop(name));
	}

	@PostMapping("/shop")
	ResponseEntity<Object> addShop(@Valid @RequestBody ShopRequest shopDto) {
		return ResponseEntity.status(HttpStatus.OK).body("Added correctly \n" + shopService.addShop(shopDto));
	}

	@DeleteMapping("/shop")
	ResponseEntity<Object> deleteShop(@RequestParam("name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body("Deleted correctly \n" + shopService.deleteShop(name));
	}

	@PutMapping("/shop")
	ResponseEntity<Object> updateShop(@Valid @RequestBody ShopRequest shopDto) {
		return ResponseEntity.status(HttpStatus.OK).body("Updated correctly \n" + shopService.updateShop(shopDto));
	}
}
