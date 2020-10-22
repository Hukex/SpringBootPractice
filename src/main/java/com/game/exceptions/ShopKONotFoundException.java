package com.game.exceptions;

import com.game.exceptions.generic.ShopKOException;

public class ShopKONotFoundException extends ShopKOException {

	private static final long serialVersionUID = 1L;
	private static final String DETAIL = "Shop Not Found";

	public ShopKONotFoundException(String detalle) {
		super(detalle);
		// TODO Auto-generated constructor stub
	}

	public ShopKONotFoundException() {
		super(DETAIL);
	}
}
