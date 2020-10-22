package com.game.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.TicketRequest;
import com.game.dtos.response.TicketResponse;
import com.game.entities.Ticket;
import com.game.helpers.TicketServiceHelper;
import com.game.repositories.TicketRepository;
import com.game.services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketServiceHelper ticketServiceHelper;
	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private ConversionService cs;

	@Override
	public TicketResponse addTicket(TicketRequest ticketDto) {
		Ticket ticket = ticketServiceHelper.checkIfAllParamsAreValid(ticketDto);
		ticketRepository.save(ticket);
		return cs.convert(ticket, TicketResponse.class);
	}

	@Override
	public TicketResponse getTicket(Long id) {
		Ticket ticket = ticketServiceHelper.getTicketById(id);
		return cs.convert(ticket, TicketResponse.class);
	}

	@Override
	public TicketResponse deleteTicket(Long id) {
		Ticket ticket = ticketServiceHelper.getTicketById(id);
		TicketResponse sr = cs.convert(ticket, TicketResponse.class);
		ticketRepository.delete(ticket);
		return sr;
	}

}
