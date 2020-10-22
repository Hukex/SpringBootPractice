package com.game.exceptions.generic;

public class ClientKOException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String detalle;

	public ClientKOException(String detalle) {
		this.detalle = detalle;
	}

	public String getDetalle() {
		return detalle;
	}
}
