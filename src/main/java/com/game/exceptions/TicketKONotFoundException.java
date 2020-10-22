package com.game.exceptions;

import com.game.exceptions.generic.StockKOException;

public class TicketKONotFoundException extends StockKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Ticket Not Found";

	public TicketKONotFoundException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public TicketKONotFoundException() {
		super(DETAIL);
	}
}
