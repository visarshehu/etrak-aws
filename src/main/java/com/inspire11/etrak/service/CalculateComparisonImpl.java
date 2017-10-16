package com.inspire11.etrak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire11.etrak.model.SurveyComparison;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.repository.SurveyDataRepository;

@Service("comparisonService")
public class CalculateComparisonImpl implements CalculateComparison {
	
	@Autowired
	private SurveyDataRepository surveyDataRepository;
	
	SurveyComparison surveyCompare=new SurveyComparison();

	private double movementComparison,strengthComparison,enduranceComparison,powerComparison;

	public void MovementComparison(Long id1,Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient=surveyDataRepository.findOne(id2);
		
		double deepSquat=((firstClient.getSurveyDataResults().getDeepSquatScore()-secondClient.getSurveyDataResults().getDeepSquatScore())/firstClient.getSurveyDataResults().getDeepSquatScore())*100;
		double shoulderFlexionR=((firstClient.getSurveyDataResults().getShoulderFlexionRScore()-secondClient.getSurveyDataResults().getShoulderFlexionRScore())/firstClient.getSurveyDataResults().getShoulderFlexionRScore())*100;
		double shoulderFlexionL=((firstClient.getSurveyDataResults().getShoulderFlexionLScore()-secondClient.getSurveyDataResults().getShoulderFlexionLScore())/firstClient.getSurveyDataResults().getShoulderFlexionLScore())*100;
		double shoulderExtensionR=((firstClient.getSurveyDataResults().getShoulderExtensionRScore()-secondClient.getSurveyDataResults().getShoulderExtensionRScore())/firstClient.getSurveyDataResults().getShoulderExtensionRScore())*100;
		double shoulderExtensionL=((firstClient.getSurveyDataResults().getShoulderExtensionLScore()-secondClient.getSurveyDataResults().getShoulderExtensionLScore())/firstClient.getSurveyDataResults().getShoulderExtensionLScore())*100;
		double trunkRotationR=((firstClient.getSurveyDataResults().getTrunkRotationRScore()-secondClient.getSurveyDataResults().getTrunkRotationRScore())/firstClient.getSurveyDataResults().getTrunkRotationRScore())*100;
		double trunkRotationL=((firstClient.getSurveyDataResults().getTrunkRotationLScore()-secondClient.getSurveyDataResults().getTrunkRotationLScore())/firstClient.getSurveyDataResults().getTrunkRotationLScore())*100;
		double pistolSquatL=((firstClient.getSurveyDataResults().getPistolSquatLScore()-secondClient.getSurveyDataResults().getPistolSquatLScore())/firstClient.getSurveyDataResults().getPistolSquatLScore())*100;
		double pistolSquatR=((firstClient.getSurveyDataResults().getPistolSquatRScore()-secondClient.getSurveyDataResults().getPistolSquatRScore())/firstClient.getSurveyDataResults().getPistolSquatRScore())*100;
		double proneLH_RF=((firstClient.getSurveyDataResults().getProneLH_RFScore()-secondClient.getSurveyDataResults().getProneLH_RFScore())/firstClient.getSurveyDataResults().getProneLH_RFScore())*100;
		double proneRH_LF=((firstClient.getSurveyDataResults().getProneRH_LFScore()-secondClient.getSurveyDataResults().getProneRH_LFScore())/firstClient.getSurveyDataResults().getProneRH_LFScore())*100;
		double v_sit=((firstClient.getSurveyDataResults().getvSitScore()-secondClient.getSurveyDataResults().getvSitScore())/firstClient.getSurveyDataResults().getvSitScore())*100;
		
		movementComparison=(deepSquat+shoulderFlexionR+shoulderFlexionL+shoulderExtensionR+shoulderExtensionL+trunkRotationR+trunkRotationL+pistolSquatL+pistolSquatR+proneRH_LF+proneLH_RF+v_sit);
		surveyCompare.setMovementComparison(movementComparison);
	
	};
	
	public void StrengthComparison(Long id1,Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient=surveyDataRepository.findOne(id2);
		
		double lowerAbsForce=((firstClient.getSurveyDataResults().getLowerAbsoluteForce()-secondClient.getSurveyDataResults().getLowerAbsoluteForce())/firstClient.getSurveyDataResults().getLowerAbsoluteForce())*100;
		double pushAbsForce=((firstClient.getSurveyDataResults().getPushAbsoluteForce()-secondClient.getSurveyDataResults().getPushAbsoluteForce())/firstClient.getSurveyDataResults().getPushAbsoluteForce())*100;
		double pullAbsForce=((firstClient.getSurveyDataResults().getPullAbsoluteForce()-secondClient.getSurveyDataResults().getPullAbsoluteForce())/firstClient.getSurveyDataResults().getPullAbsoluteForce())*100;
		double lowerRelForce=((firstClient.getSurveyDataResults().getLowerRelativeForce()-secondClient.getSurveyDataResults().getLowerRelativeForce())/firstClient.getSurveyDataResults().getLowerRelativeForce())*100;
		double pushRelForce=((firstClient.getSurveyDataResults().getPushRelativeForce()-secondClient.getSurveyDataResults().getPushRelativeForce())/firstClient.getSurveyDataResults().getPushRelativeForce())*100;
		double pullRelForce=((firstClient.getSurveyDataResults().getPullRelativeForce()-secondClient.getSurveyDataResults().getPullRelativeForce())/firstClient.getSurveyDataResults().getPullRelativeForce())*100;
		
		strengthComparison=(lowerAbsForce+pushAbsForce+pullAbsForce+lowerRelForce+pushRelForce+pullRelForce);
		surveyCompare.setStrengthComparison(strengthComparison);
	};
	
	public void PowerComparison(Long id1,Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient=surveyDataRepository.findOne(id2);
		
		double s10Power=((firstClient.getSurveyDataResults().getS10PowerOutputResults()-secondClient.getSurveyDataResults().getS10PowerOutputResults())/firstClient.getSurveyDataResults().getS10PowerOutputResults())*100;
		double s60Power=((firstClient.getSurveyDataResults().getS60PowerOutputResults()-secondClient.getSurveyDataResults().getS60PowerOutputResults())/firstClient.getSurveyDataResults().getS60PowerOutputResults())*100;
		double s10RelativePower=((firstClient.getSurveyDataResults().getS10RelativePowerResults()-secondClient.getSurveyDataResults().getS10RelativePowerResults())/firstClient.getSurveyDataResults().getS10RelativePowerResults())*100;
		double s60RelativePower=((firstClient.getSurveyDataResults().getS60RelativePower()-secondClient.getSurveyDataResults().getS60RelativePower())/firstClient.getSurveyDataResults().getS60RelativePower())*100;
		
		powerComparison=(s10Power+s60Power+s10RelativePower+s60RelativePower);
		surveyCompare.setPowerComparison(powerComparison);
	};
	
	public void EnduranceComparison(Long id1,Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient=surveyDataRepository.findOne(id2);
		
		double vo2Max=((firstClient.getSurveyDataResults().getVo2Score()-secondClient.getSurveyDataResults().getVo2Score())/firstClient.getSurveyDataResults().getVo2Score())*100;
		double min4Power=((firstClient.getSurveyDataResults().getMin4powerOutput()-secondClient.getSurveyDataResults().getMin4powerOutput())/firstClient.getSurveyDataResults().getMin4powerOutput())*100;
		double min4RelativePower=((firstClient.getSurveyDataResults().getMin4RelativePower()-secondClient.getSurveyDataResults().getMin4RelativePower())/firstClient.getSurveyDataResults().getMin4RelativePower())*100;
		
		enduranceComparison=(vo2Max+min4Power+min4RelativePower);
		surveyCompare.setEnduranceComparison(enduranceComparison);
		double overrallDifference=movementComparison+powerComparison+strengthComparison+enduranceComparison;
		surveyCompare.setOverrallDifference(overrallDifference);
	};
}
