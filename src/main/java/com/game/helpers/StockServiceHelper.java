package com.game.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.StockRequest;
import com.game.entities.Game;
import com.game.entities.Shop;
import com.game.entities.Stock;
import com.game.exceptions.StockKOAlreadyAddedException;
import com.game.exceptions.StockKONotFoundException;
import com.game.repositories.GameRepository;
import com.game.repositories.ShopRepository;
import com.game.repositories.StockRepository;

@Service
public class StockServiceHelper {
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private ConversionService cs;

	@Autowired
	private GameServiceHelper gameServiceHelper;
	@Autowired
	private ShopServiceHelper shopServiceHelper;

	public void checkIfStockExists(Stock stock) {
		if (stock == null)
			throw new StockKONotFoundException();
	}

	public void checkIfStockIsAlreadyAdded(Stock stock) {
		if (stock != null)
			throw new StockKOAlreadyAddedException();
	}

	public Stock checkIfAllParamsAreValid(StockRequest stockDto) {
		Game game = gameRepository.findByTitle(stockDto.getGame());
		gameServiceHelper.checkIfGameExists(game);
		Shop shop = shopRepository.findByName(stockDto.getShop());
		shopServiceHelper.checkIfShopExists(shop);
		checkIfStockIsAlreadyAdded(stockRepository.findByShopAndGame(shop, game));
		Stock stock = cs.convert(stockDto, Stock.class);
		stock.setGame(game);
		stock.setShop(shop);
		return stock;
	}

	public Stock getStockByShopIdAndGameTitle(String name, String gameTitle) {
		Game game = gameRepository.findByTitle(gameTitle);
		gameServiceHelper.checkIfGameExists(game);
		Shop shop = shopRepository.findByName(name);
		shopServiceHelper.checkIfShopExists(shop);
		Stock stock = stockRepository.findByShopAndGame(shop, game);
		checkIfStockExists(stock);
		return stock;
	}

	public Stock getStockUpdated(StockRequest stockDto) {
		Game game = gameRepository.findByTitle(stockDto.getGame());
		gameServiceHelper.checkIfGameExists(game);
		Shop shop = shopRepository.findByName(stockDto.getShop());
		shopServiceHelper.checkIfShopExists(shop);
		Stock stock = stockRepository.findByShopAndGame(shop, game);
		checkIfStockExists(stock);
		stock.setQuantity(stockDto.getQuantity());
		return stock;
	}
}
