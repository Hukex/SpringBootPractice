package com.game.dtos.request;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ClientRequest {

	@NotEmpty(message = "Values can not be empties")
	private String name, surname, card;

}
