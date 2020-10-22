package com.game.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.StockRequest;
import com.game.dtos.response.StockResponse;
import com.game.entities.Stock;
import com.game.exceptions.StockKOStockFinished;
import com.game.helpers.StockServiceHelper;
import com.game.repositories.StockRepository;
import com.game.services.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockServiceHelper stockServiceHelper;
	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private ConversionService cs;

	@Override
	public StockResponse addStock(StockRequest stockDto) {
		Stock stock = stockServiceHelper.checkIfAllParamsAreValid(stockDto);
		stockRepository.save(stock);
		return cs.convert(stock, StockResponse.class);
	}

	@Override
	public StockResponse getStock(String name, String gameTitle) {
		Stock stock = stockServiceHelper.getStockByShopIdAndGameTitle(name, gameTitle);
		return cs.convert(stock, StockResponse.class);
	}

	@Override
	public StockResponse deleteStock(String name, String gameTitle) {
		Stock stock = stockServiceHelper.getStockByShopIdAndGameTitle(name, gameTitle);
		StockResponse sr = cs.convert(stock, StockResponse.class);
		stockRepository.delete(stock);
		return sr;
	}

	@Override
	public StockResponse updateStock(StockRequest stockDto) {
		Stock stock = stockServiceHelper.getStockUpdated(stockDto);
		stockRepository.save(stock);
		return cs.convert(stock, StockResponse.class);
	}

	@Override
	public StockResponse addOneToQuantityStock(String name, String gameTitle) {
		Stock stock = stockServiceHelper.getStockByShopIdAndGameTitle(name, gameTitle);
		stock.setQuantity(stock.getQuantity() + 1);
		stockRepository.save(stock);
		return cs.convert(stock, StockResponse.class);

	}

	@Override
	public StockResponse removeOneToQuantityStock(String name, String gameTitle) {
		Stock stock = stockServiceHelper.getStockByShopIdAndGameTitle(name, gameTitle);
		if (stock.getQuantity() <= 0)
			throw new StockKOStockFinished();
		stock.setQuantity(stock.getQuantity() - 1);
		stockRepository.save(stock);
		return cs.convert(stock, StockResponse.class);

	}

}
