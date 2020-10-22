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

import com.game.dtos.request.ClientRequest;
import com.game.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/client")
	ResponseEntity<Object> getClientById(@RequestParam("card") String card) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.getClient(card));
	}

	@PostMapping("/client")
	ResponseEntity<Object> addClient(@Valid @RequestBody ClientRequest clientDto) {
		return ResponseEntity.status(HttpStatus.OK).body("Added correctly \n" + clientService.addClient(clientDto));
	}

	@DeleteMapping("/client")
	ResponseEntity<Object> deleteClient(@RequestParam("card") String card) {
		return ResponseEntity.status(HttpStatus.OK).body("Deleted correctly \n" + clientService.deleteClient(card));
	}

	@PutMapping("/client")
	ResponseEntity<Object> updateClient(@Valid @RequestBody ClientRequest clientDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body("Updated correctly \n" + clientService.updateClient(clientDto));
	}
}
