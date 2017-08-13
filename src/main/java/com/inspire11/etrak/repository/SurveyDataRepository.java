package com.inspire11.etrak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspire11.etrak.domain.SurveyData;

public interface SurveyDataRepository extends JpaRepository<SurveyData, Long> {

}
