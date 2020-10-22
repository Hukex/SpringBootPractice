package com.game.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.GameRequest;
import com.game.dtos.response.GameResponse;
import com.game.entities.Game;
import com.game.entities.Genre;
import com.game.helpers.GameServiceHelper;
import com.game.repositories.GameRepository;
import com.game.services.GameService;
import com.game.services.GenreService;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private GameServiceHelper gameServiceHelper;
	@Autowired
	private GenreService genreService;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private ConversionService cs;

	@Override
	public GameResponse addGame(GameRequest gameDto) {
		gameServiceHelper.checkIfGameIsAlreadyAdded(gameRepository.findByTitle(gameDto.getTitle()));
		Game game = cs.convert(gameDto, Game.class);
		List<Genre> genres = gameDto.getGenre().stream().map(e -> genreService.findByGenre(e))
				.collect(Collectors.toList());
		game.setGenres(genres);
		gameRepository.save(game);
		return cs.convert(game, GameResponse.class);
	}

	@Override
	public void addGames(ArrayList<GameRequest> gameDtos) {
		gameDtos.forEach(e -> addGame(e)); // When the array get a game that exists next ones are not add. Just for dev
	}

	@Override
	public GameResponse getGame(String title) {
		Game game = gameRepository.findByTitle(title);
		gameServiceHelper.checkIfGameExists(game);
		return cs.convert(game, GameResponse.class);
	}

	@Override
	public List<GameResponse> getGames() {
		return gameRepository.findAll().stream().map(g -> cs.convert(g, GameResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GameResponse deleteGame(String title) {
		Game game = gameRepository.findByTitle(title);
		gameServiceHelper.checkIfGameExists(game);
		GameResponse gr = cs.convert(game, GameResponse.class);
		gameRepository.delete(game);
		return gr;
	}

	@Override
	public GameResponse updateGame(GameRequest gameDto) {
		gameServiceHelper.checkIfNewTitleIsValid(gameDto.getNewTitle());
		Game game = gameRepository.findByTitle(gameDto.getTitle());
		gameServiceHelper.checkIfGameExists(game);
		List<Genre> genres = gameDto.getGenre().stream().map(e -> genreService.findByGenre(e))
				.collect(Collectors.toList());
		if (!gameDto.getNewTitle().isEmpty())
			game.setTitle(gameDto.getNewTitle());
		game.setGenres(genres);
		game.setDescription(gameDto.getDescription());
		game.setRelease(gameDto.getRelease());
		gameRepository.save(game);
		return cs.convert(game, GameResponse.class);
	}

}
