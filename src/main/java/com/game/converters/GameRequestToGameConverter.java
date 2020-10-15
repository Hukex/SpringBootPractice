package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.request.GameRequest;
import com.game.entities.Game;

@Component
public class GameRequestToGameConverter implements Converter<GameRequest, Game> {

	@Override
	public Game convert(GameRequest gr) {
		Game game = new Game();
		game.setDescription(gr.getDescription());
		game.setRelease(gr.getRelease());
		game.setTitle(gr.getTitle());
		return game;
	}

}
