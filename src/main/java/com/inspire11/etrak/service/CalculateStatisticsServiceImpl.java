 package com.inspire11.etrak.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.inspire11.etrak.model.Client;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.model.SurveyDataResults;
import com.inspire11.etrak.repository.ClientRepository;
import com.inspire11.etrak.repository.SurveyDataRepository;

public class CalculateStatisticsServiceImpl implements CalculateStatisticsService{

	@Autowired
	private SurveyDataRepository surveyDataRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public long CalculateStatistics() {
		int  maleCount, femaleCount;
		maleCount=clientRepository.countByGender('M');
		femaleCount=clientRepository.countByGender('F');
		Calendar firstDayOfCurrentYear=Calendar.getInstance();
		firstDayOfCurrentYear.set(Calendar.DATE, 1);
		firstDayOfCurrentYear.set(Calendar.MONTH,0);
		Date firstDay=firstDayOfCurrentYear.getTime();
		Calendar lastDayOfCurrentYear=Calendar.getInstance();
		lastDayOfCurrentYear.set(Calendar.DATE, 31);
		lastDayOfCurrentYear.set(Calendar.MONTH,11);
		Date lastDay=lastDayOfCurrentYear.getTime();
		long activeUsersYear=surveyDataRepository.yearAverage(firstDay,lastDay);
		long activeUsersMonth=(surveyDataRepository.yearAverage(firstDay,lastDay))/12;
		double genderRatio=maleCount/femaleCount;
		return 0;
	}

	@Override
	public Double CalculateImprovement(char gender) {
		
		List<Client> clients=clientRepository.findByGender(gender);
	/*	List<Client> clients=clientRepository.findAll();*/
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

	@Override
	public Double AverageAge() {
		 Calendar now = Calendar.getInstance();
		 now.add(Calendar.YEAR,-19);
		 Date firstDate=now.getTime();
		 Calendar secondNow=Calendar.getInstance();
		 secondNow.add(Calendar.YEAR, -39);
		 Date secondDate=secondNow.getTime();
		 
		 int ageBetween=clientRepository.countByBirthDateBetween(firstDate, secondDate);
		 
		 Calendar under18=Calendar.getInstance();
		 under18.add(Calendar.YEAR,-18);
		 Date under=under18.getTime();
		 
		 int ageUnder=clientRepository.countByBirthDateLessThanEqual(under);
		 
		 Calendar above40=Calendar.getInstance();
		 above40.add(Calendar.YEAR, -40);
		 Date above=above40.getTime();
		 
		 int ageAbove=clientRepository.countByBirthDateGreaterThanEqual(above);
		 
		 
		return null;
	}
	
	@Override
	public Double top10(char gender) {
		long number=surveyDataRepository.countByClient_Gender(gender);		
		int top10= (int) (0.10*number);		
		List<SurveyData> surveys=surveyDataRepository.findByClient_GenderOrderBySurveyDataResults_EtrakScoreDesc(gender);
	    SurveyData lastSurvey=surveys.get(top10);
	    double top10Min= lastSurvey.getSurveyDataResults().getEtrakScore();	    
	    return top10Min;
	}
	
	
	public double activeScore() {
		Calendar prev=Calendar.getInstance();
		prev.add(Calendar.MONTH, -1);
		prev.add(Calendar.DATE, 1);
		Date firstDateofPreviousMonth=prev.getTime();
		
		prev.set(Calendar.DATE, prev.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		Date lastDateofPreviousMonth=prev.getTime();
		
		List<SurveyData> surveys=surveyDataRepository.findBySubmittedDateBetween(firstDateofPreviousMonth, lastDateofPreviousMonth);
		
		Double meanDiff=surveys.stream().map(survey->{
		
			SurveyDataResults score=survey.getSurveyDataResults();
				return score.getEtrakScore();
		
		}).collect(Collectors.averagingDouble(it->it));
		return meanDiff;
	
	}
	
	public double activeRange() {
		Calendar prev=Calendar.getInstance();
		prev.add(Calendar.MONTH, -1);
		prev.add(Calendar.DATE, 1);
		Date firstDateofPreviousMonth=prev.getTime();
		
		prev.set(Calendar.DATE, prev.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		Date lastDateofPreviousMonth=prev.getTime();
		
		List<SurveyData> surveys=surveyDataRepository.findBySubmittedDateBetween(firstDateofPreviousMonth, lastDateofPreviousMonth);

		
		return 0.0;
		
	}
	}
	



