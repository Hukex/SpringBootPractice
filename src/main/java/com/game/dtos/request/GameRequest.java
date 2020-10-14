package com.game.dtos.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.game.enums.GenreEnum;

import lombok.Data;

@Data
public class GameRequest {

	@NotEmpty(message = "Los valores no pueden estar vacio")
	private String title, description;
	private List<GenreEnum> genre;
	@NotNull(message = "La fecha no puede estar vacia")
	private Date release;

}
