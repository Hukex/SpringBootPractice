package com.game.helpers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.TicketRequest;
import com.game.entities.Client;
import com.game.entities.Stock;
import com.game.entities.Ticket;
import com.game.exceptions.TicketKOAlreadyAddedException;
import com.game.exceptions.TicketKONotFoundException;
import com.game.repositories.ClientRepository;
import com.game.repositories.TicketRepository;
import com.game.services.StockService;

@Service
public class TicketServiceHelper {
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientServiceHelper clientServiceHelper;
	@Autowired
	private StockServiceHelper stockServiceHelper;
	@Autowired
	private StockService stockService;
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
		Stock stock = stockServiceHelper.getStockByShopIdAndGameTitle(ticketDto.getShop(), ticketDto.getGame());
		Client client = clientRepository.findByCard(ticketDto.getClient());
		clientServiceHelper.checkIfClientExists(client);
		checkIfTicketIsAlreadyAdded(ticketRepository.findByClientAndStock(client, stock));
		Ticket ticket = cs.convert(ticketDto, Ticket.class);
		ticket.setStock(stock);
		ticket.setClient(client);
		stockService.removeOneToQuantityStock(ticketDto.getShop(), ticketDto.getGame());
		return ticket;
	}

}
