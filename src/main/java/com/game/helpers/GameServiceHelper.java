package com.game.helpers;

import org.springframework.stereotype.Service;

import com.game.entities.Game;
import com.game.exceptions.GameKOAlreadyAddedException;
import com.game.exceptions.GameKONotFoundException;

@Service
public class GameServiceHelper {

	public void checkIfGameExists(Game game) {
		if (game == null)
			throw new GameKONotFoundException();
	}

	public void checkIfGameIsAlreadyAdded(Game game) {
		if (game != null)
			throw new GameKOAlreadyAddedException();
	}

}
