package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.response.ShopResponse;
import com.game.entities.Shop;

@Component
public class ShopToShopResponseConverter implements Converter<Shop, ShopResponse> {

	@Override
	public ShopResponse convert(Shop shop) {
		ShopResponse sr = new ShopResponse();
		sr.setLocation(shop.getLocation());
		sr.setName(shop.getName());
		return sr;
	}

}
