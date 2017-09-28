package com.inspire11.etrak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspire11.etrak.model.Client;


@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client,Long> {
	 Client findByEmail(String email);
	 
}