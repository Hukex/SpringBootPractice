package com.game.exceptions;

import com.game.exceptions.generic.StockKOException;

public class ClientKONotFoundException extends StockKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Client Not Found";

	public ClientKONotFoundException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public ClientKONotFoundException() {
		super(DETAIL);
	}
}
