package com.game.dtos.response;

import lombok.Data;

@Data
public class TicketResponse {

	private String name, surname, card, title;
	private Long id;
}
