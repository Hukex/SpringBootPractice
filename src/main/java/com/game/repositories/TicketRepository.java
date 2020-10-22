package com.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.entities.Client;
import com.game.entities.Stock;
import com.game.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	Ticket findByClientAndStock(Client client, Stock stock);

}
