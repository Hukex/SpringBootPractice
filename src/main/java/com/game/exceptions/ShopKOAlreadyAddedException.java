package com.game.exceptions;

import com.game.exceptions.generic.ShopKOException;

public class ShopKOAlreadyAddedException extends ShopKOException {
	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Shop Already Added with that shopId";

	public ShopKOAlreadyAddedException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public ShopKOAlreadyAddedException() {
		super(DETAIL);
	}
}
