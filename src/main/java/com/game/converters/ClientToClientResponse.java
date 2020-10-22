package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.response.ClientResponse;
import com.game.entities.Client;

@Component
public class ClientToClientResponse implements Converter<Client, ClientResponse> {

	@Override
	public ClientResponse convert(Client client) {
		ClientResponse sr = new ClientResponse();
		sr.setCard(client.getCard());
		sr.setName(client.getCard());
		sr.setSurname(client.getSurname());
		sr.setId(client.getId());
		return sr;
	}

}
