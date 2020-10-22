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

import com.game.dtos.request.StockRequest;
import com.game.services.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping("/stock")
	ResponseEntity<Object> getStockByGameAndShop(@RequestParam("name") String name,
			@RequestParam("gameTitle") String gameTitle) {
		return ResponseEntity.status(HttpStatus.OK).body(stockService.getStock(name, gameTitle));
	}

	@PostMapping("/stock")
	ResponseEntity<Object> addStock(@Valid @RequestBody StockRequest stockDto) {
		return ResponseEntity.status(HttpStatus.OK).body("Added correctly \n" + stockService.addStock(stockDto));
	}

	@DeleteMapping("/stock")
	ResponseEntity<Object> deleteStock(@RequestParam("name") String name, @RequestParam("gameTitle") String gameTitle) {
		return ResponseEntity.status(HttpStatus.OK)
				.body("Deleted correctly \n" + stockService.deleteStock(name, gameTitle));
	}

	@PutMapping("/stock")
	ResponseEntity<Object> updateStock(@Valid @RequestBody StockRequest stockDto) {
		return ResponseEntity.status(HttpStatus.OK).body("Updated correctly \n" + stockService.updateStock(stockDto));
	}

	@PutMapping("/addOneToQuantityStock")
	ResponseEntity<Object> addOneToQuantityStock(@RequestParam("name") String name,
			@RequestParam("gameTitle") String gameTitle) {
		return ResponseEntity.status(HttpStatus.OK)
				.body("Added +1 to quantity stock \n" + stockService.addOneToQuantityStock(name, gameTitle));
	}

	@PutMapping("/removeOneToQuantityStock")
	ResponseEntity<Object> removeOneToQuantityStock(@RequestParam("name") String name,
			@RequestParam("gameTitle") String gameTitle) {
		return ResponseEntity.status(HttpStatus.OK)
				.body("Removed -1 to quantity stock \n" + stockService.removeOneToQuantityStock(name, gameTitle));
	}

}
