package com.inspire11.etrak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire11.etrak.model.SurveyComparison;
import com.inspire11.etrak.repository.SurveyComparisonRepository;

@Service("surveyComparisonService")
public class SurveyComparisonServiceImpl implements SurveyComparisonService {

	@Autowired
	private SurveyComparisonRepository surveyComparisonRepository;

	@Override
	public SurveyComparison save(SurveyComparison survey) {
		
		return surveyComparisonRepository.save(survey);
	}

	@Override
	public SurveyComparison getSurveyById(long id) {
		return surveyComparisonRepository.findOne(id);
	}
}
