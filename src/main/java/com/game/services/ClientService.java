package com.game.services;

import com.game.dtos.request.ClientRequest;
import com.game.dtos.response.ClientResponse;

public interface ClientService {

	public ClientResponse addClient(ClientRequest clientDto);

	public ClientResponse getClient(String card);

	public ClientResponse deleteClient(String card);

	public ClientResponse updateClient(ClientRequest clientDto);
}
