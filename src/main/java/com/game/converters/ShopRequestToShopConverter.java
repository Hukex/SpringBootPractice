package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.request.ShopRequest;
import com.game.entities.Shop;

@Component
public class ShopRequestToShopConverter implements Converter<ShopRequest, Shop> {

	@Override
	public Shop convert(ShopRequest sr) {
		Shop shop = new Shop();
		shop.setName(sr.getName());
		shop.setLocation(sr.getLocation());
		return shop;
	}

}
