package com.game.converters;

import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.response.GameResponse;
import com.game.entities.Game;
import com.game.entities.Genre;

@Component
public class GameToGameResponseConverter implements Converter<Game, GameResponse> {

	@Override
	public GameResponse convert(Game game) {
		GameResponse gr = new GameResponse();
		gr.setRelease(game.getRelease());
		gr.setTitle(game.getTitle());
		gr.setDescription(game.getDescription());
		gr.setGenre(game.getGenres().stream().map(Genre::getGenre).collect(Collectors.toList()));
		return gr;
	}

}
