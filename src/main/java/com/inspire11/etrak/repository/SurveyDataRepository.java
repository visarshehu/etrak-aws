package com.inspire11.etrak.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspire11.etrak.model.SurveyData;

@Repository("surveyRepository")
public interface SurveyDataRepository extends JpaRepository<SurveyData, Long> {



}
