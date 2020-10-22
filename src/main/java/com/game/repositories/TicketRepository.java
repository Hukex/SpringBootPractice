package com.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.entities.Client;
import com.game.entities.Game;
import com.game.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	Ticket findByClientAndGame(Client client, Game game);

}
