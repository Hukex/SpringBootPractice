package com.game.exceptions;

import com.game.exceptions.generic.StockKOException;

public class StockKOAlreadyAddedException extends StockKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Stock Already Added for that game and shop";

	public StockKOAlreadyAddedException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public StockKOAlreadyAddedException() {
		super(DETAIL);
	}
}
