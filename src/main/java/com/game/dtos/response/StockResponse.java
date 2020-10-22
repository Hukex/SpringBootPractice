package com.game.dtos.response;

import lombok.Data;

@Data
public class StockResponse {

	private Long quantity;
	private String game, shop;

}
