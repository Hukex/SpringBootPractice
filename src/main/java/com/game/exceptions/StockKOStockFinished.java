package com.game.exceptions;

import com.game.exceptions.generic.StockKOException;

public class StockKOStockFinished extends StockKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Stock Finished(0)";

	public StockKOStockFinished(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public StockKOStockFinished() {
		super(DETAIL);
	}
}
