package com.game.helpers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.TicketRequest;
import com.game.entities.Client;
import com.game.entities.Game;
import com.game.entities.Ticket;
import com.game.exceptions.TicketKOAlreadyAddedException;
import com.game.exceptions.TicketKONotFoundException;
import com.game.repositories.ClientRepository;
import com.game.repositories.GameRepository;
import com.game.repositories.TicketRepository;

@Service
public class TicketServiceHelper {
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private GameServiceHelper gameServiceHelper;
	@Autowired
	private ClientServiceHelper clientServiceHelper;
	@Autowired
	private ConversionService cs;

	public void checkIfTicketIsAlreadyAdded(Ticket ticket) {
		if (ticket != null)
			throw new TicketKOAlreadyAddedException();
	}

	public void checkIfTicketExists(Optional<Ticket> ticket) {
		if (!ticket.isPresent())
			throw new TicketKONotFoundException();
	}

	public Ticket getTicketById(Long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		checkIfTicketExists(ticket);
		return ticket.get();
	}

	public Ticket checkIfAllParamsAreValid(TicketRequest ticketDto) {
		Game game = gameRepository.findByTitle(ticketDto.getGame());
		gameServiceHelper.checkIfGameExists(game);
		Client client = clientRepository.findByCard(ticketDto.getClient());
		clientServiceHelper.checkIfClientExists(client);
		checkIfTicketIsAlreadyAdded(ticketRepository.findByClientAndGame(client, game));
		Ticket ticket = cs.convert(ticketDto, Ticket.class);
		ticket.setGame(game);
		ticket.setClient(client);
		return ticket;
	}

}
