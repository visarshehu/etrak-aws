package com.inspire11.etrak.service;

import java.util.List;

import com.inspire11.etrak.model.Client;


public interface ClientService {
	
	public List<Client> getAllClients();
	public Client getClientById(long id);
	public Client findClientByEmail(String email);
	public void saveClient(Client client);
	public List<Client> findByNameContainsOrLastNameContainsAllIgnoreCase(String query,String query1);
	public List<Client> findTop5ByGenderOrderBySurvey_SurveyDataResults_EtrakScoreDesc(char gender);

}
