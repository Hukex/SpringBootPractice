package com.game.services;

import java.util.ArrayList;
import java.util.List;

import com.game.dtos.request.GameRequest;
import com.game.dtos.response.GameResponse;

public interface GameService {

	public GameResponse addGame(GameRequest gameDto);

	public void addGames(ArrayList<GameRequest> gameDtos);

	public GameResponse getGame(String title);

	public List<String> getTitlesGames();
}
