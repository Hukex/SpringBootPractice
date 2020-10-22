package com.game.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.dtos.request.ShopRequest;
import com.game.entities.Shop;
import com.game.exceptions.ShopKOAlreadyAddedException;
import com.game.exceptions.ShopKONotFoundException;
import com.game.repositories.ShopRepository;

@Service
public class ShopServiceHelper {
	@Autowired
	private ShopRepository shopRepository;

	public void checkIfShopIsAlreadyAdded(Shop shop) {
		if (shop != null)
			throw new ShopKOAlreadyAddedException();
	}

	public void checkIfShopExists(Shop shop) {
		if (shop == null)
			throw new ShopKONotFoundException();
	}

	public Shop getShopByName(String name) {
		Shop shop = shopRepository.findByName(name);
		checkIfShopExists(shop);
		return shop;
	}

	public Shop getShopUpdated(ShopRequest shopDto) {
		Shop shop = shopRepository.findByName(shopDto.getName());
		shop.setLocation(shopDto.getLocation());
		shop.setName((shopDto.getName()));
		return shop;
	}

}
