package com.game.exceptions;

import com.game.exceptions.generic.GenreKOException;

public class GenreKONotFoundException extends GenreKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Genre Not Found";

	public GenreKONotFoundException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public GenreKONotFoundException() {
		super(DETAIL);
	}

}
