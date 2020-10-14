package com.game.dtos.response;

import java.util.ArrayList;
import java.util.Date;

import com.game.enums.GenreEnum;

import lombok.Data;

@Data
public class GameResponse {

	private String title, description;
	private ArrayList<GenreEnum> genre;
	private Date release;

}
