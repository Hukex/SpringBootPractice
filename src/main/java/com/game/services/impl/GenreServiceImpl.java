package com.game.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.entities.Genre;
import com.game.enums.GenreEnum;
import com.game.exceptions.GenreKONotFoundException;
import com.game.repositories.GenreRepository;
import com.game.services.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreRepository repo;
	@Autowired
	private ConversionService cs;

	@PostConstruct
	@Override
	public void loadGenres() {
		List<Genre> genreList = new ArrayList<>();
		for (int i = 0; i < GenreEnum.values().length; i++) {
			if (repo.findByGenre(GenreEnum.values()[i]) == null)
				genreList.add(cs.convert(GenreEnum.values()[i], Genre.class));
		}
		repo.saveAll(genreList);
	}

	@Override
	public Genre findByGenre(GenreEnum genre) {
		Genre g = repo.findByGenre(genre);
		if (g == null)
			throw new GenreKONotFoundException();
		return g;
	}
}
