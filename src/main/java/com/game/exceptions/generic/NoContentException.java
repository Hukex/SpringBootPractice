package com.game.exceptions.generic;

public class NoContentException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private final String detalle;
	
	public NoContentException(String detalle) {
		this.detalle = detalle;
	}

	public String getDetalle() {
		return detalle;
	}

}
