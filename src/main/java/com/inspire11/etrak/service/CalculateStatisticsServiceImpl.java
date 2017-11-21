package com.inspire11.etrak.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire11.etrak.model.Client;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.model.SurveyDataResults;
import com.inspire11.etrak.repository.ClientRepository;
import com.inspire11.etrak.repository.SurveyDataRepository;

@Service("calculateStatistics")
public class CalculateStatisticsServiceImpl implements CalculateStatisticsService{

	@Autowired
	private SurveyDataRepository surveyDataRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public long CalculateStatistics() {
		
		int activeUsersMonth, maleCount, femaleCount;
		maleCount=clientRepository.countByGender('M');
		femaleCount=clientRepository.countByGender('F');		
		Calendar firstDayOfCurrentYear = Calendar.getInstance();
		firstDayOfCurrentYear.set(Calendar.DATE, 1);
		firstDayOfCurrentYear.set(Calendar.MONTH, 0);
		Date firstDay=firstDayOfCurrentYear.getTime();
		Calendar lastDayOfCurrentYear = Calendar.getInstance();
		lastDayOfCurrentYear.set(Calendar.DATE, 31);
		lastDayOfCurrentYear.set(Calendar.MONTH, 11);
		Date lastDay=lastDayOfCurrentYear.getTime();
		long activeUsersYear=surveyDataRepository.yearAverage(firstDay, lastDay);		
		double averageActiveUsersMonth=(surveyDataRepository.yearAverage(firstDay, lastDay))/12;
		double genderRatio=maleCount/femaleCount;;
		return activeUsersYear;
		
	}

	@Override
	public Double CalculateImprovement() {
		List<Client> clients=clientRepository.findAll();
		Double meanDiff=clients.stream().map(client->{
			List<SurveyData> survey=client.getSurvey();
			if(survey.size()>2) {
				SurveyData first=survey.get(0);
				SurveyData last=survey.get(survey.size()-1);
				return last.getSurveyDataResults().getEtrakScore()-first.getSurveyDataResults().getEtrakScore();
				
			} else {
				return 0.0;
			}
			
		}).collect(Collectors.averagingDouble(it->it));
		return meanDiff;
	}
	

}
		
