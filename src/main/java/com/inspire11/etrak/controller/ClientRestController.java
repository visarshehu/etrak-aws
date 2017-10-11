package com.inspire11.etrak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inspire11.etrak.model.Client;
import com.inspire11.etrak.service.ClientService;

@RestController
public class ClientRestController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(path="clients", method=RequestMethod.GET)
	public List<Client> getAllClients(){
		return clientService.getAllClients();
	}
	
    @RequestMapping(value = "clients/{id}", method = RequestMethod.GET)
	public Client getClientById(@PathVariable("id") long id){
		return clientService.getClientById(id);
	}

}
