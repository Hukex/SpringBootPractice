package com.game.exceptions;

import com.game.exceptions.generic.StockKOException;

public class ClientKOAlreadyAddedException extends StockKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Client already added with that card and name";

	public ClientKOAlreadyAddedException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public ClientKOAlreadyAddedException() {
		super(DETAIL);
	}
}
