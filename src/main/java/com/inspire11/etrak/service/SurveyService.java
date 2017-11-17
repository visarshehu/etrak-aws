package com.inspire11.etrak.service;




import java.util.List;

import com.inspire11.etrak.model.SurveyData;


public interface SurveyService {

	public SurveyData saveSurvey(SurveyData survey);
	public SurveyData getSurveyById(long id);
	public List<SurveyData> findAll();
	public List<SurveyData> findByClient_GenderOrderBySurveyDataResults_EtrakScoreDesc(char gender);
	public List<SurveyData> findTop5ByOrderBySubmittedDateDesc();


}
