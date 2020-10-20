package com.game.controllers;

import java.util.ArrayList;

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

import com.game.dtos.request.GameRequest;
import com.game.services.GameService;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping("/game")
	ResponseEntity<Long> getGameById(@RequestParam("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@GetMapping("/game/search")
	ResponseEntity<Object> getGameByName(@RequestParam("name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(gameService.getGame(name));
	}

	@PostMapping("/game")
	ResponseEntity<Object> addGame(@Valid @RequestBody GameRequest gameDto) {
		return ResponseEntity.status(HttpStatus.OK).body("Added correctly \n" + gameService.addGame(gameDto));
	}

	@DeleteMapping("/game")
	ResponseEntity<Object> deleteGame(@RequestParam String title) {
		return ResponseEntity.status(HttpStatus.OK).body("Deleted correctly \n" + gameService.deleteGame(title));
	}

	@PutMapping("/game")
	ResponseEntity<Object> updateGame(@Valid @RequestBody GameRequest gameDto) {
		return ResponseEntity.status(HttpStatus.OK).body("Updated correctly" + gameService.updateGame(gameDto));
	}

	@PostMapping("/games")
	ResponseEntity<Object> addGames(@RequestBody ArrayList<GameRequest> gameDtos) {
		gameService.addGames(gameDtos);
		return ResponseEntity.status(HttpStatus.OK).body("All games added correctly");
	}

	@GetMapping("/games")
	ResponseEntity<Object> getGames() {
		return ResponseEntity.status(HttpStatus.OK).body(gameService.getGames());
	}

}
