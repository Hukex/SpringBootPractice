package com.game.dtos.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.game.enums.GenreEnum;

import lombok.Data;

@Data
public class GameRequest {

	@NotEmpty(message = "Values can not be empties")
	private String title, description;
	private List<GenreEnum> genre;
	@NotNull(message = "Date can not be empty")
	private Date release;

	private String newTitle;

}
