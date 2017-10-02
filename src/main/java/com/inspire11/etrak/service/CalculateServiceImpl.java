package com.inspire11.etrak.service;

import org.springframework.stereotype.Service;

import com.inspire11.etrak.lookup.LookUp;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.repository.SurveyDataRepository;

@Service("calculateService")
public class CalculateServiceImpl implements CalculateService {
	
	private SurveyDataRepository surveyDataRepository;
	private LookUp lookupTable;
	
	public void CalculateMovement(Long id) {
		SurveyData survey=surveyDataRepository.findOne(id);
		
		int deepSquat=lookupTable.getScore("",survey.getDeepSquatHipFlexion());
		
		int shoulderFlexionR=lookupTable.getScore("",survey.getShoulderExtensionR());
		
		int shoulderFlexionL=lookupTable.getScore("",survey.getShoulderExtensionL());
		
		int shoulderExtensionR=lookupTable.getScore("",survey.getShoulderExtensionR());
		
		int shoulderExtensionL=lookupTable.getScore("",survey.getShoulderExtensionL());
		
		int trunkRotationR=lookupTable.getScore("",survey.getTrunkRotationR());
		
		int trunkRotationL=lookupTable.getScore("",survey.getTrunkRotationL());
		
		double rangeScore=(deepSquat+shoulderFlexionR+shoulderFlexionL+shoulderExtensionR+shoulderExtensionL+trunkRotationL+trunkRotationR)/7;
		
		
		
		
	}
	
	public void CalculateStrength(Long id) {
		
	}
	
	public void CalculatePower(Long id) {
		
	}
	
	public void CalculateEndurance(Long id) {
		
	}

}
