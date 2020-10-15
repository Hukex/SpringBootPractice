package com.game.exceptions.generic;

public class GenreKOException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String detalle;

	public GenreKOException(String detalle) {
		this.detalle = detalle;
	}

	public String getDetalle() {
		return detalle;
	}
}
