package com.game.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.GameRequest;
import com.game.dtos.response.GameResponse;
import com.game.entities.Game;
import com.game.helpers.GameServiceHelper;
import com.game.repositories.GameRepository;
import com.game.services.GameService;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private GameServiceHelper gameServiceHelper;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private ConversionService cs;

	@Override
	public GameResponse addGame(GameRequest gameDto) {
		gameServiceHelper.checkIfGameIsAlreadyAdded(gameRepository.findByTitle(gameDto.getTitle()));
		Game game = cs.convert(gameDto, Game.class);
		gameRepository.save(game);
		return cs.convert(game, GameResponse.class);
	}

	@Override
	public void addGames(ArrayList<GameRequest> gameDtos) {
		/*
		 * addGame(gameDtos.get(3)); gameDtos.stream().map(e -> addGame(e));
		 * gameDtos.forEach(e -> addGame(e));
		 */
	}

	@Override
	public GameResponse getGame(String title) {
		Game game = gameRepository.findByTitle(title);
		gameServiceHelper.checkIfGameExists(game);
		GameResponse gameResponse = cs.convert(game, GameResponse.class);

		return gameResponse;
	}

	@Override
	public List<String> getTitlesGames() {
		List<String> titles = new ArrayList<>();
		/*
		 * gamesList.forEach(e -> titles.add(e.getTitle()));
		 */ return titles;
	}

}
