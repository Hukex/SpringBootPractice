package com.game.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.dtos.request.ClientRequest;
import com.game.entities.Client;
import com.game.exceptions.ClientKOAlreadyAddedException;
import com.game.exceptions.ClientKONotFoundException;
import com.game.repositories.ClientRepository;

@Service
public class ClientServiceHelper {
	@Autowired
	private ClientRepository ClientRepository;

	public void checkIfClientIsAlreadyAdded(Client client) {
		if (client != null)
			throw new ClientKOAlreadyAddedException();
	}

	public void checkIfClientExists(Client client) {
		if (client == null)
			throw new ClientKONotFoundException();
	}

	public Client getClientByCard(String card) {
		Client Client = ClientRepository.findByCard(card);
		checkIfClientExists(Client);
		return Client;
	}

	public Client getClientUpdated(ClientRequest clientDto) {
		Client Client = ClientRepository.findByCard((clientDto.getCard()));
		checkIfClientExists(Client);
		Client.setName((clientDto.getName()));
		Client.setSurname(clientDto.getSurname());
		return Client;
	}

}
