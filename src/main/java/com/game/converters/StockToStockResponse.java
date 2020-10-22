package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.response.StockResponse;
import com.game.entities.Stock;

@Component
public class StockToStockResponse implements Converter<Stock, StockResponse> {

	@Override
	public StockResponse convert(Stock stock) {
		StockResponse sr = new StockResponse();
		sr.setQuantity(stock.getQuantity());
		sr.setGame(stock.getGame().getTitle());
		sr.setShop(stock.getShop().getName());
		return sr;
	}

}
