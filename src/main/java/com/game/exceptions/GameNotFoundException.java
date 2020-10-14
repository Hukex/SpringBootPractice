package com.game.exceptions;

import com.game.exceptions.generic.NotFoundException;

public class GameNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 1L;

	private static final String DETAIL = "Not Found";

	public GameNotFoundException(String detalle) {
		super(detalle);
	}

	public GameNotFoundException() {
		super(DETAIL);
	}
}
