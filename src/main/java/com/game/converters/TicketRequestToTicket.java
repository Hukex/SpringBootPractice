package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.request.TicketRequest;
import com.game.entities.Ticket;

@Component
public class TicketRequestToTicket implements Converter<TicketRequest, Ticket> {

	@Override
	public Ticket convert(TicketRequest sr) {
		Ticket ticket = new Ticket();
		return ticket;
	}

}
