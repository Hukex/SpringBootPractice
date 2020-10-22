package com.game.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.game.dtos.request.ClientRequest;
import com.game.entities.Client;

@Component
public class ClientRequestToClient implements Converter<ClientRequest, Client> {

	@Override
	public Client convert(ClientRequest sr) {
		Client client = new Client();
		client.setCard(sr.getCard());
		client.setName(sr.getName());
		client.setSurname(sr.getSurname());
		return client;
	}

}
