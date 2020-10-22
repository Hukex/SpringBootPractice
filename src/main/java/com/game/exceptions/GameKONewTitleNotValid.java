package com.game.exceptions;

import com.game.exceptions.generic.GameKOException;

public class GameKONewTitleNotValid extends GameKOException {
	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "newTitle attribute is not valid";

	public GameKONewTitleNotValid(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public GameKONewTitleNotValid() {
		super(DETAIL);
	}
}
