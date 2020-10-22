package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.request.StockRequest;
import com.game.entities.Stock;

@Component
public class StockRequestToStock implements Converter<StockRequest, Stock> {

	@Override
	public Stock convert(StockRequest sr) {
		Stock stock = new Stock();
		stock.setQuantity(sr.getQuantity());
		return stock;
	}

}
