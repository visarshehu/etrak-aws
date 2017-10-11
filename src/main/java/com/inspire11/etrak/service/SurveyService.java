package com.inspire11.etrak.service;



import com.inspire11.etrak.model.SurveyData;


public interface SurveyService {

	public SurveyData saveSurvey(SurveyData survey);
	public SurveyData getSurveyById(long id);
}
