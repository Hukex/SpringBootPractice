package com.game.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.dtos.request.TicketRequest;
import com.game.services.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/ticket")
	ResponseEntity<Object> getTicketById(@RequestParam("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicket(id));
	}

	@PostMapping("/ticket")
	ResponseEntity<Object> addTicket(@Valid @RequestBody TicketRequest ticketDto) {
		return ResponseEntity.status(HttpStatus.OK).body("Added correctly \n" + ticketService.addTicket(ticketDto));
	}

	@DeleteMapping("/ticket")
	ResponseEntity<Object> deleteTicket(@RequestParam("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body("Deleted correctly \n" + ticketService.deleteTicket(id));
	}

}
