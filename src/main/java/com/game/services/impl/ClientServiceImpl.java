package com.game.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.game.dtos.request.ClientRequest;
import com.game.dtos.response.ClientResponse;
import com.game.entities.Client;
import com.game.helpers.ClientServiceHelper;
import com.game.repositories.ClientRepository;
import com.game.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientServiceHelper clientServiceHelper;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ConversionService cs;

	@Override
	public ClientResponse addClient(ClientRequest clientDto) {
		clientServiceHelper.checkIfClientIsAlreadyAdded(clientRepository.findByCard(clientDto.getCard()));
		Client client = cs.convert(clientDto, Client.class);
		clientRepository.save(client);
		return cs.convert(client, ClientResponse.class);
	}

	@Override
	public ClientResponse getClient(String name) {
		Client client = clientServiceHelper.getClientByCard(name);
		return cs.convert(client, ClientResponse.class);
	}

	@Override
	public ClientResponse deleteClient(String name) {
		Client client = clientServiceHelper.getClientByCard(name);
		ClientResponse sr = cs.convert(client, ClientResponse.class);
		clientRepository.delete(client);
		return sr;
	}

	@Override
	public ClientResponse updateClient(ClientRequest clientDto) {
		Client client = clientServiceHelper.getClientUpdated(clientDto);
		clientRepository.save(client);
		return cs.convert(client, ClientResponse.class);
	}

}
