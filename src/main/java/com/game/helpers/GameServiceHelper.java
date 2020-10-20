package com.game.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.entities.Game;
import com.game.exceptions.GameKOAlreadyAddedException;
import com.game.exceptions.GameKONewTitleNotValid;
import com.game.exceptions.GameKONotFoundException;
import com.game.repositories.GameRepository;

@Service
public class GameServiceHelper {

	@Autowired
	private GameRepository gameRepository;

	public void checkIfGameExists(Game game) {
		if (game == null)
			throw new GameKONotFoundException();
	}

	public void checkIfGameIsAlreadyAdded(Game game) {
		if (game != null)
			throw new GameKOAlreadyAddedException();
	}

	public void checkIfNewTitleIsValid(String title) {
		if (title == null)
			throw new GameKONewTitleNotValid();
		Game game = gameRepository.findByTitle(title);
		checkIfGameIsAlreadyAdded(game);

	}
}
