package com.inspire11.etrak.service;




import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.repository.SurveyDataRepository;


@Service("surveyService")
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyDataRepository surveyRepository;
	

	@Override
	public SurveyData saveSurvey(SurveyData survey) {
		return surveyRepository.save(survey);
	}


	@Override
	public SurveyData getSurveyById(long id) {
		return surveyRepository.findOne(id);
	}



	@Override
	public List<SurveyData> findByClient_GenderOrderBySurveyDataResults_EtrakScoreDesc(char gender) {
		// TODO Auto-generated method stub
		List<SurveyData> survey= surveyRepository.findTop5ByClient_GenderOrderBySurveyDataResults_EtrakScoreDesc(gender);
	return survey;
	}


	@Override
	public List<SurveyData> findAll() {
		// TODO Auto-generated method stub
		return surveyRepository.findAll();
	}


	@Override
	public List<SurveyData> findTop5ByOrderBySubmittedDateDesc() {
		// TODO Auto-generated method stub
		return surveyRepository.findTop5ByOrderBySubmittedDateDesc();
	}



	


	}

