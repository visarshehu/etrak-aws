package com.inspire11.etrak.service;

import com.inspire11.etrak.model.SurveyComparison;


public interface SurveyComparisonService {

	public SurveyComparison save(SurveyComparison survey);
	public SurveyComparison getSurveyById(long id);
}
