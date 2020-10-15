package com.game.services;

import com.game.entities.Genre;
import com.game.enums.GenreEnum;

public interface GenreService {
	public void loadGenres();

	public Genre findByGenre(GenreEnum g);
}
