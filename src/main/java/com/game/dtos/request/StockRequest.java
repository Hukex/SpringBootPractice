package com.game.dtos.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StockRequest {

	@NotNull(message = "Quantity can not be empty")
	private Long quantity;
	@NotEmpty(message = "Values can not be empties")
	private String game, shop;

}
