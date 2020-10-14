package com.game.exceptions;

import com.game.exceptions.generic.GameKOException;

public class GameKOAlreadyAddedException extends GameKOException {
	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Game Already Added with that Title";

	public GameKOAlreadyAddedException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public GameKOAlreadyAddedException() {
		super(DETAIL);
	}
}
