package com.game.services;

import com.game.dtos.request.TicketRequest;
import com.game.dtos.response.TicketResponse;

public interface TicketService {

	public TicketResponse addTicket(TicketRequest ticketDto);

	public TicketResponse getTicket(Long id);

	public TicketResponse deleteTicket(Long id);

}
