package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.response.TicketResponse;
import com.game.entities.Ticket;

@Component
public class TicketToTicketResponse implements Converter<Ticket, TicketResponse> {

	@Override
	public TicketResponse convert(Ticket ticket) {
		TicketResponse sr = new TicketResponse();
		sr.setCard(ticket.getClient().getCard());
		sr.setName(ticket.getClient().getName());
		sr.setSurname(ticket.getClient().getSurname());
		sr.setTitle(ticket.getStock().getGame().getTitle());
		sr.setShopName(ticket.getStock().getShop().getName());
		sr.setId(ticket.getId());
		return sr;
	}

}
