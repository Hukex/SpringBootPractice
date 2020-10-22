package com.game.dtos.request;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TicketRequest {

	@NotEmpty(message = "Values can not be empties")
	private String client, game;

	private Long id;

}
