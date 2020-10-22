package com.game.services;

import com.game.dtos.request.StockRequest;
import com.game.dtos.response.StockResponse;

public interface StockService {
	public StockResponse addStock(StockRequest stockDto);

	public StockResponse getStock(String name, String gameTitle);

	public StockResponse deleteStock(String name, String gameTitle);

	public StockResponse updateStock(StockRequest stockDto);

	public StockResponse addOneToQuantityStock(String name, String gameTitle);

	public StockResponse removeOneToQuantityStock(String name, String gameTitle);

}
