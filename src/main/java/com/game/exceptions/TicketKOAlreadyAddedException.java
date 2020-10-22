package com.game.exceptions;

import com.game.exceptions.generic.StockKOException;

public class TicketKOAlreadyAddedException extends StockKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Ticket Already created for that game and client";

	public TicketKOAlreadyAddedException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public TicketKOAlreadyAddedException() {
		super(DETAIL);
	}
}
