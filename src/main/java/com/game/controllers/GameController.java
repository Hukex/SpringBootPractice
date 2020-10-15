package com.game.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	/*
	 * @PostMapping("/games") ResponseEntity<Object> addGames(@RequestBody
	 * ArrayList<GameRequest> gameDtos) { gameServiceImpl.addGames(gameDtos); return
	 * ResponseEntity.status(HttpStatus.OK).body("All games added correctly"); }
	 * 
	 * @GetMapping("/games") ResponseEntity<Object> getGames() { return
	 * ResponseEntity.status(HttpStatus.OK).body(gameServiceImpl.getTitlesGames());
	 * }
	 */

}
