package com.inspire11.etrak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspire11.etrak.model.SurveyComparison;

@Repository
public interface SurveyComparisonRepository extends JpaRepository<SurveyComparison, Long> {

}
