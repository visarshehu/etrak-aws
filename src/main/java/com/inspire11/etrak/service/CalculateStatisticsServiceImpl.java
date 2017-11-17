package com.inspire11.etrak.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.inspire11.etrak.repository.ClientRepository;
import com.inspire11.etrak.repository.SurveyDataRepository;

public class CalculateStatisticsServiceImpl implements CalculateStatisticsService{

	@Autowired
	private SurveyDataRepository surveyDataRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public void CalculateStatistics(Date submittedDate) {
		
		int activeUsersMonth, activeUsersYear, maleCount, femaleCount;
		maleCount=clientRepository.countByGender('M');
		femaleCount=clientRepository.countByGender('F');
		
	}

}
