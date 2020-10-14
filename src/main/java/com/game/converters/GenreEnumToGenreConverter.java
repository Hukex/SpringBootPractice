package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.entities.Genre;
import com.game.enums.GenreEnum;

@Component
public class GenreEnumToGenreConverter implements Converter<GenreEnum, Genre> {

	@Override
	public Genre convert(GenreEnum ge) {
		Genre genre = new Genre();
		genre.setGenre(ge);
		return genre;
	}

}
