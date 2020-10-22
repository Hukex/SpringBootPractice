package com.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.entities.Game;
import com.game.entities.Shop;
import com.game.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	Stock findByShopAndGame(Shop shop, Game game);
}
