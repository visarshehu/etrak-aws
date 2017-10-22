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

	@Autowired
	private SurveyComparisonService surveyComparisonService;

	SurveyComparison surveyCompare = new SurveyComparison();

	private double movementComparison, strengthComparison, enduranceComparison, powerComparison;
	private Long clientId, secondId;

	public void MovementComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);
		clientId = firstClient.getClient().getId();
		secondId = secondClient.getClient().getId();
		double firstSquat = (firstClient.getSurveyDataResults().getDeepSquatScore());
		double secondSquat = (secondClient.getSurveyDataResults().getDeepSquatScore());

		double deepSquat = ((firstSquat - secondSquat) / firstSquat) * 100;

		double firstShoulderFlexion = (firstClient.getSurveyDataResults().getShoulderFlexionRScore());
		double secondShoulderFlexion = (secondClient.getSurveyDataResults().getShoulderFlexionRScore());

		double shoulderFlexionR = ((firstShoulderFlexion - secondShoulderFlexion) / firstShoulderFlexion) * 100;

		double firstShoulderL = (firstClient.getSurveyDataResults().getShoulderFlexionLScore());
		double secondShoulderL = (secondClient.getSurveyDataResults().getShoulderFlexionLScore());

		double shoulderFlexionL = ((firstShoulderL - secondShoulderL) / firstShoulderL) * 100;

		double firstShoulderExtension = (firstClient.getSurveyDataResults().getShoulderExtensionRScore());
		double secondShoulderExtension = (secondClient.getSurveyDataResults().getShoulderExtensionRScore());

		double shoulderExtensionR = ((firstShoulderExtension - secondShoulderExtension) / firstShoulderExtension) * 100;

		double firstShoulderExtensionL = (firstClient.getSurveyDataResults().getShoulderExtensionLScore());
		double secondShoulderExtensionL = (secondClient.getSurveyDataResults().getShoulderExtensionLScore());

		double shoulderExtensionL = ((firstShoulderExtensionL - secondShoulderExtensionL) / firstShoulderExtensionL)
				* 100;

		double firstTrunkRotationR = (firstClient.getSurveyDataResults().getTrunkRotationRScore());
		double secondTrunkRotationR = (secondClient.getSurveyDataResults().getTrunkRotationRScore());

		double trunkRotationR = ((firstTrunkRotationR - secondTrunkRotationR) / firstTrunkRotationR) * 100;

		double firstTrunkRotationL = (firstClient.getSurveyDataResults().getTrunkRotationLScore());
		double secondTrunkRotationL = (secondClient.getSurveyDataResults().getTrunkRotationLScore());

		double trunkRotationL = ((firstTrunkRotationL - secondTrunkRotationL) / firstTrunkRotationL) * 100;

		double firstPistolSquatL = (firstClient.getSurveyDataResults().getPistolSquatLScore());
		double secondPistolSquatL = (secondClient.getSurveyDataResults().getPistolSquatLScore());
		double pistolSquatL;
		if (firstPistolSquatL == 0) {
			pistolSquatL = 100;
		} else {
			pistolSquatL = ((firstPistolSquatL - secondPistolSquatL) / firstPistolSquatL) * 100;
		}

		double firstPistolSquatR = (firstClient.getSurveyDataResults().getPistolSquatRScore());
		double secondPistolSquatR = (secondClient.getSurveyDataResults().getPistolSquatRScore());
		double pistolSquatR;
		if (firstPistolSquatR == 0) {
			pistolSquatR = 100;
		} else {
			pistolSquatR = ((firstPistolSquatR - secondPistolSquatR) / firstPistolSquatR) * 100;
		}

		double firstproneLH_RF = (firstClient.getSurveyDataResults().getProneLH_RFScore());
		double secondproneLH_RF = (secondClient.getSurveyDataResults().getProneLH_RFScore());
		double proneLH_RF;
		if (firstproneLH_RF == 0) {
			proneLH_RF = 100;
		} else {
			proneLH_RF = ((firstproneLH_RF - secondproneLH_RF) / firstproneLH_RF) * 100;
		}

		double firstproneRH_LF = (firstClient.getSurveyDataResults().getProneRH_LFScore());
		double secondproneRH_LF = (secondClient.getSurveyDataResults().getProneRH_LFScore());
		double proneRH_LF;
		if (firstproneRH_LF == 0) {
			proneRH_LF = 100;
		} else {
			proneRH_LF = ((firstproneRH_LF - secondproneRH_LF) / firstproneRH_LF) * 100;
		}

		double firstVsit = (firstClient.getSurveyDataResults().getvSitScore());
		double secondVsit = (secondClient.getSurveyDataResults().getvSitScore());
		double v_sit;
		if (firstVsit == 0) {
			v_sit = 100;
		} else {
			v_sit = ((firstVsit - secondVsit) / firstVsit) * 100;
		}

		movementComparison = (deepSquat + shoulderFlexionR + shoulderFlexionL + shoulderExtensionR + shoulderExtensionL
				+ trunkRotationR + trunkRotationL + pistolSquatL + pistolSquatR + proneRH_LF + proneLH_RF + v_sit);
		surveyCompare.setMovementComparison(movementComparison);

	};

	public void StrengthComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);

		double firstLowerAbs = (firstClient.getSurveyDataResults().getLowerAbsoluteForce());
		double secondLowerAbs = (secondClient.getSurveyDataResults().getLowerAbsoluteForce());

		double lowerAbsForce = ((firstLowerAbs - secondLowerAbs) / firstLowerAbs) * 100;

		double firstPushAbs = (firstClient.getSurveyDataResults().getPushAbsoluteForce());
		double secondPushAbs = (secondClient.getSurveyDataResults().getPushAbsoluteForce());

		double pushAbsForce = ((firstPushAbs - secondPushAbs) / firstPushAbs) * 100;

		double firstPullAbs = (firstClient.getSurveyDataResults().getPullAbsoluteForce());
		double secondPullAbs = (secondClient.getSurveyDataResults().getPullAbsoluteForce());

		double pullAbsForce = ((firstPullAbs - secondPullAbs) / firstPullAbs) * 100;

		double firstLowerRel = (firstClient.getSurveyDataResults().getLowerRelativeForce());
		double secondLowerRel = (secondClient.getSurveyDataResults().getLowerRelativeForce());

		double lowerRelForce = ((firstLowerRel - secondLowerRel) / firstLowerRel) * 100;

		double firstPushRel = (firstClient.getSurveyDataResults().getPushRelativeForce());
		double secondPushRel = (secondClient.getSurveyDataResults().getPushRelativeForce());

		double pushRelForce = ((firstPushRel - secondPushRel) / firstPushRel) * 100;

		double firstPullRel = (firstClient.getSurveyDataResults().getPullRelativeForce());
		double secondPullRel = (secondClient.getSurveyDataResults().getPullRelativeForce());

		double pullRelForce = ((firstPullRel - secondPullRel) / firstPullRel) * 100;

		strengthComparison = (lowerAbsForce + pushAbsForce + pullAbsForce + lowerRelForce + pushRelForce
				+ pullRelForce);
		surveyCompare.setStrengthComparison(strengthComparison);
	};

	public void PowerComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);

		double firsts10Power = (firstClient.getSurveyDataResults().getS10PowerOutputResults());
		double seconds10Power = (secondClient.getSurveyDataResults().getS10PowerOutputResults());

		double s10Power = ((firsts10Power - seconds10Power) / firsts10Power) * 100;

		double firsts60Power = (firstClient.getSurveyDataResults().getS60PowerOutputResults());
		double seconds60Power = (secondClient.getSurveyDataResults().getS60PowerOutputResults());

		double s60Power = ((firsts60Power - seconds60Power) / firsts60Power) * 100;

		double firsts10Rel = (firstClient.getSurveyDataResults().getS10RelativePowerResults());
		double seconds10Rel = (secondClient.getSurveyDataResults().getS10RelativePowerResults());

		double s10RelativePower = ((firsts10Rel - seconds10Rel) / firsts10Rel) * 100;

		double firsts60Rel = (firstClient.getSurveyDataResults().getS60RelativePower());
		double seconds60Rel = (secondClient.getSurveyDataResults().getS60RelativePower());

		double s60RelativePower = ((firsts60Rel - seconds60Rel) / firsts60Rel) * 100;

		powerComparison = (s10Power + s60Power + s10RelativePower + s60RelativePower);
		surveyCompare.setPowerComparison(powerComparison);
	};

	public Long EnduranceComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);

		double firstVo2 = (firstClient.getSurveyDataResults().getVo2Score());
		double secondVo2 = (secondClient.getSurveyDataResults().getVo2Score());

		double vo2Max = ((firstVo2 - secondVo2) / firstVo2) * 100;

		double firstMin4 = (firstClient.getSurveyDataResults().getMin4powerOutput());
		double secondMin4 = (secondClient.getSurveyDataResults().getMin4powerOutput());

		double min4Power = ((firstMin4 - secondMin4) / firstMin4) * 100;

		double firstMin4Rel = (firstClient.getSurveyDataResults().getMin4RelativePower());
		double secondMin4Rel = (secondClient.getSurveyDataResults().getMin4RelativePower());

		double min4RelativePower = ((firstMin4Rel - secondMin4Rel) / firstMin4Rel) * 100;

		enduranceComparison = (vo2Max + min4Power + min4RelativePower);
		surveyCompare.setEnduranceComparison(enduranceComparison);
		double overrallDifference = movementComparison + powerComparison + strengthComparison + enduranceComparison;
		surveyCompare.setOverrallDifference(overrallDifference);
		surveyCompare.setFirstClient(clientId);
		surveyCompare.setSecondClient(secondId);
		SurveyComparison survey =surveyComparisonService.save(surveyCompare);
		return survey.getId();

	};
}
