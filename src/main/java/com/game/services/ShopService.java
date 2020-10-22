package com.game.services;

import com.game.dtos.request.ShopRequest;
import com.game.dtos.response.ShopResponse;

public interface ShopService {

	public ShopResponse addShop(ShopRequest shopDto);

	public ShopResponse getShop(String name);

	public ShopResponse deleteShop(String name);

	public ShopResponse updateShop(ShopRequest shopDto);
}
