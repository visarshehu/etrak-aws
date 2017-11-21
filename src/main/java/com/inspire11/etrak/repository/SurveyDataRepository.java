package com.inspire11.etrak.repository;





import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inspire11.etrak.model.SurveyData;


@Repository("surveyRepository")
public interface SurveyDataRepository extends JpaRepository<SurveyData, Long> {

  SurveyData findOne(Long id);
  //@Query("select u from SurveyData u where u.client= :id")
  SurveyData findByClientId(@Param("id") Long id); 
  List<SurveyData> findByClient_Gender(char gender);
  List<SurveyData> findTop5ByClient_GenderOrderBySurveyDataResults_EtrakScoreDesc(char gender);
  List<SurveyData> findTop5ByOrderBySubmittedDateDesc();
  
  @Query("SELECT COUNT(s) FROM SurveyData s WHERE (s.submittedDate BETWEEN :yearStart AND :yearEnd)")
  Long yearAverage(@Param("yearStart") Date yearStart, @Param("yearEnd") Date yearEnd);
  
   
}
