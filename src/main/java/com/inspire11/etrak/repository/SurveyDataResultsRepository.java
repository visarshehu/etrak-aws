package com.inspire11.etrak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspire11.etrak.model.SurveyDataResults;


@Repository("surveyDataResults")
public interface SurveyDataResultsRepository  extends JpaRepository<SurveyDataResults, Long>{
	List<SurveyDataResults> findTop5ByOrderByEtrakScoreDesc();
	


}
