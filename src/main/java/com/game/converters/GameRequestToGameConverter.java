package com.game.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.request.GameRequest;
import com.game.entities.Game;
import com.game.entities.Genre;
import com.game.repositories.GenreRepository;

@Component
public class GameRequestToGameConverter implements Converter<GameRequest, Game> {

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Game convert(GameRequest gr) {
		Game game = new Game();
		game.setDescription(gr.getDescription());
		game.setRelease(gr.getRelease());
		game.setTitle(gr.getTitle());
		List<Genre> genres = new ArrayList<>();
		gr.getGenre().forEach(e -> genres.add(genreRepository.findByGenre(e)));
		game.setGenres(genres);
		return game;
	}

}
