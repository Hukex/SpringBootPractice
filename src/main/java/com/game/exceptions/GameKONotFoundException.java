package com.game.exceptions;

import com.game.exceptions.generic.GameKOException;

public class GameKONotFoundException extends GameKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Game Not Found";

	public GameKONotFoundException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public GameKONotFoundException() {
		super(DETAIL);
	}

}
