package com.inspire11.etrak.service;

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





	
}
