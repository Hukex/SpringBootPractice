package com.game.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.ShopRequest;
import com.game.dtos.response.ShopResponse;
import com.game.entities.Shop;
import com.game.helpers.ShopServiceHelper;
import com.game.repositories.ShopRepository;
import com.game.services.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopServiceHelper shopServiceHelper;
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private ConversionService cs;

	@Override
	public ShopResponse addShop(ShopRequest shopDto) {
		shopServiceHelper.checkIfShopIsAlreadyAdded(shopRepository.findByName(shopDto.getName()));
		Shop shop = cs.convert(shopDto, Shop.class);
		shopRepository.save(shop);
		return cs.convert(shop, ShopResponse.class);
	}

	@Override
	public ShopResponse getShop(String name) {
		Shop shop = shopServiceHelper.getShopByName(name);
		return cs.convert(shop, ShopResponse.class);
	}

	@Override
	public ShopResponse deleteShop(String name) {
		Shop shop = shopServiceHelper.getShopByName(name);
		ShopResponse sr = cs.convert(shop, ShopResponse.class);
		shopRepository.delete(shop);
		return sr;
	}

	@Override
	public ShopResponse updateShop(ShopRequest shopDto) {
		Shop shop = shopServiceHelper.getShopUpdated(shopDto);
		shopRepository.save(shop);
		return cs.convert(shop, ShopResponse.class);
	}

}
