package com.game.dtos.response;

import java.util.Date;
import java.util.List;

import com.game.enums.GenreEnum;

import lombok.Data;

@Data
public class GameResponse {

	private String title, description;
	private List<GenreEnum> genre;
	private Date release;

}
