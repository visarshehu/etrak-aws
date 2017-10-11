package com.inspire11.etrak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire11.etrak.model.SurveyDataResults;
import com.inspire11.etrak.repository.SurveyDataResultsRepository;


@Service("surveyServiceResults")
public class SurveyServiceResultsImpl implements SurveyServiceResults {

	@Autowired
	private SurveyDataResultsRepository surveyDataResultsRepository;
	
	@Override
	public void saveSurveyResults(SurveyDataResults surveyresults) {
		surveyDataResultsRepository.save(surveyresults);
	}
}
