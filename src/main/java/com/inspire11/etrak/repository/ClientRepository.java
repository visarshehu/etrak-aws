package com.inspire11.etrak.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspire11.etrak.model.Client;
import com.inspire11.etrak.model.SurveyData;


@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client,Long> {
	 Client findByEmail(String email);
	 List<Client> findByNameContainsOrLastNameContainsAllIgnoreCase(String query,String query1);
	 List<Client> findTop5ByGenderOrderBySurvey_SurveyDataResults_EtrakScoreDesc(char gender);
	 int countByGender(char gender);
	 List <Client> findByGender(char gender);
	 
	 int countByBirthDateBetween(Date firstDate, Date secondDate);
	 int countByBirthDateGreaterThanEqual(Date under18);
	 int countByBirthDateLessThanEqual(Date above);

}
