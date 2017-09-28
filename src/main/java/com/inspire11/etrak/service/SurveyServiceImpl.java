package com.inspire11.etrak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.repository.SurveyDataRepository;


@Service("surveyData")
public class SurveyServiceImpl {
	@Autowired
	private SurveyDataRepository surveyRepository;
	

	public void saveSurvey(SurveyData survey) {
		surveyRepository.save(survey);
	}
}
