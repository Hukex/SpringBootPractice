package com.game.exceptions.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.game.dtos.ErrorDto;
import com.game.exceptions.generic.GameKOException;
import com.game.exceptions.generic.GenreKOException;
import com.game.exceptions.generic.NoContentException;
import com.game.exceptions.generic.NotFoundException;
import com.game.exceptions.generic.ShopKOException;
import com.game.exceptions.generic.StockKOException;

@ControllerAdvice
public class GameHandlerException extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ GameKOException.class })
	@ResponseBody
	public ErrorDto gameKO(HttpServletRequest request, GameKOException exception) {
		return new ErrorDto("00", exception.getDetalle());
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ GenreKOException.class })
	@ResponseBody
	public ErrorDto genreKO(HttpServletRequest request, GenreKOException exception) {
		return new ErrorDto("00", exception.getDetalle());
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ ShopKOException.class })
	@ResponseBody
	public ErrorDto shopKO(HttpServletRequest request, ShopKOException exception) {
		return new ErrorDto("00", exception.getDetalle());
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ StockKOException.class })
	@ResponseBody
	public ErrorDto stockKO(HttpServletRequest request, StockKOException exception) {
		return new ErrorDto("00", exception.getDetalle());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundException.class })
	@ResponseBody
	public ErrorDto notFoundRequest(HttpServletRequest request, NotFoundException exception) {
		return new ErrorDto("01", exception.getDetalle());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({ NoContentException.class })
	@ResponseBody
	public ErrorDto notContentRequest(HttpServletRequest request, NoContentException exception) {
		return new ErrorDto("01", exception.getDetalle());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage())
				.collect(Collectors.toList());
		return new ResponseEntity<>(new ErrorDto("02", errorMessages.toString()), HttpStatus.BAD_REQUEST);
	}
}
