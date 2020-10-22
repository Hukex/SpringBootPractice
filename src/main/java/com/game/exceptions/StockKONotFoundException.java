package com.game.exceptions;

import com.game.exceptions.generic.StockKOException;

public class StockKONotFoundException extends StockKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Stock Not Found";

	public StockKONotFoundException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public StockKONotFoundException() {
		super(DETAIL);
	}
}
