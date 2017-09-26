package com.inspire11.etrak.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inspire11.etrak.model.Client;
import com.inspire11.etrak.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(long id) {
		return clientRepository.findOne(id);
	}

	@Override
	public Client findClientByEmail(String email) {
		return clientRepository.findByEmail(email);
	}

	@Override
	public void saveClient(Client client) {
		clientRepository.save(client);
	}
}
