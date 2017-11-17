package com.inspire11.etrak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire11.etrak.model.SurveyComparison;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.repository.SurveyComparisonRepository;
import com.inspire11.etrak.repository.SurveyDataRepository;

@Service("comparisonService")
public class CalculateComparisonImpl implements CalculateComparison {

	@Autowired
	private SurveyDataRepository surveyDataRepository;

	@Autowired
	private SurveyComparisonService surveyComparisonService;
	
	@Autowired
	private SurveyComparisonRepository surveyComparisonRepository;
	



	private double movementComparison, strengthComparison, enduranceComparison, powerComparison;
	private Long clientId, secondId;

	public void MovementComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);
		clientId = firstClient.getClient().getId();
		secondId = secondClient.getClient().getId();
		
		double firstSquat = (firstClient.getSurveyDataResults().getDeepSquatScore());
		double secondSquat = (secondClient.getSurveyDataResults().getDeepSquatScore());

		double deepSquat = ((secondSquat - firstSquat) / firstSquat) * 100;

		double firstShoulderFlexion = (firstClient.getSurveyDataResults().getShoulderFlexionRScore());
		double secondShoulderFlexion = (secondClient.getSurveyDataResults().getShoulderFlexionRScore());

		double shoulderFlexionR = ((secondShoulderFlexion - firstShoulderFlexion) / firstShoulderFlexion) * 100;

		double firstShoulderL = (firstClient.getSurveyDataResults().getShoulderFlexionLScore());
		double secondShoulderL = (secondClient.getSurveyDataResults().getShoulderFlexionLScore());

		double shoulderFlexionL = ((secondShoulderL - firstShoulderL) / firstShoulderL) * 100;

		double firstShoulderExtension = (firstClient.getSurveyDataResults().getShoulderExtensionRScore());
		double secondShoulderExtension = (secondClient.getSurveyDataResults().getShoulderExtensionRScore());

		double shoulderExtensionR = ((secondShoulderExtension - firstShoulderExtension) / firstShoulderExtension) * 100;

		double firstShoulderExtensionL = (firstClient.getSurveyDataResults().getShoulderExtensionLScore());
		double secondShoulderExtensionL = (secondClient.getSurveyDataResults().getShoulderExtensionLScore());

		double shoulderExtensionL = ((secondShoulderExtensionL - firstShoulderExtensionL) / firstShoulderExtensionL)
				* 100;

		double firstTrunkRotationR = (firstClient.getSurveyDataResults().getTrunkRotationRScore());
		double secondTrunkRotationR = (secondClient.getSurveyDataResults().getTrunkRotationRScore());

		double trunkRotationR = ((secondTrunkRotationR - firstTrunkRotationR) / firstTrunkRotationR) * 100;

		double firstTrunkRotationL = (firstClient.getSurveyDataResults().getTrunkRotationLScore());
		double secondTrunkRotationL = (secondClient.getSurveyDataResults().getTrunkRotationLScore());

		double trunkRotationL = ((secondTrunkRotationL - firstTrunkRotationL) / firstTrunkRotationL) * 100;

		double firstPistolSquatL = (firstClient.getSurveyDataResults().getPistolSquatLScore());
		double secondPistolSquatL = (secondClient.getSurveyDataResults().getPistolSquatLScore());
		double pistolSquatL;
		if (firstPistolSquatL == 0) {
			pistolSquatL = 100;
		} else {
			pistolSquatL = ((secondPistolSquatL - firstPistolSquatL) / firstPistolSquatL) * 100;
		}

		double firstPistolSquatR = (firstClient.getSurveyDataResults().getPistolSquatRScore());
		double secondPistolSquatR = (secondClient.getSurveyDataResults().getPistolSquatRScore());
		double pistolSquatR;
		if (firstPistolSquatR == 0 && secondPistolSquatR !=0) {
			pistolSquatR = 100;
		} else if((firstPistolSquatR == 0 && secondPistolSquatR ==0)){
			pistolSquatR=0;
		}
		else{
			pistolSquatR = ((secondPistolSquatR - firstPistolSquatR) / firstPistolSquatR) * 100;
		}

		double firstproneLH_RF = (firstClient.getSurveyDataResults().getProneLH_RFScore());
		double secondproneLH_RF = (secondClient.getSurveyDataResults().getProneLH_RFScore());
		double proneLH_RF;
		if (firstproneLH_RF == 0 && secondproneLH_RF != 0){
			proneLH_RF = 100;
		} else if(firstproneLH_RF == 0 && secondproneLH_RF == 0) {
			proneLH_RF = 0;
		} else {
			proneLH_RF = ((secondproneLH_RF - firstproneLH_RF) / firstproneLH_RF) * 100;
		}

		double firstproneRH_LF = (firstClient.getSurveyDataResults().getProneRH_LFScore());
		double secondproneRH_LF = (secondClient.getSurveyDataResults().getProneRH_LFScore());
		double proneRH_LF;
		if (firstproneRH_LF == 0 && secondproneRH_LF != 0) {
			proneRH_LF = 100;
		} else if (firstproneRH_LF == 0 && secondproneRH_LF == 0){
			proneRH_LF = 0;
		}else {
			proneRH_LF = ((secondproneRH_LF - firstproneRH_LF) / firstproneRH_LF) * 100;
		}

		double firstVsit = (firstClient.getSurveyDataResults().getvSitScore());
		double secondVsit = (secondClient.getSurveyDataResults().getvSitScore());
		double v_sit;
		if (firstVsit == 0 && secondVsit !=0) {
			v_sit = 100;
		} else if(firstVsit == 0 && secondVsit ==0){
			v_sit = 0;
		} else{
			v_sit = ((secondVsit - firstVsit) / firstVsit) * 100;
		}

		movementComparison = (deepSquat + shoulderFlexionR + shoulderFlexionL + shoulderExtensionR + shoulderExtensionL
				+ trunkRotationR + trunkRotationL + pistolSquatL + pistolSquatR + proneRH_LF + proneLH_RF + v_sit);
		
		SurveyComparison surveyCompare=surveyComparisonService.findByFirstSurveyIdAndSecondSurveyId(id1, id2);

		if(surveyCompare==null) {
			surveyCompare= new SurveyComparison();
			surveyCompare.setFirstSurveyId(id1);
			surveyCompare.setSecondSurveyId(id2);
		
		}
		
		surveyCompare.setMovementComparison(movementComparison);
		surveyComparisonService.save(surveyCompare);

		
	};

	public void StrengthComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);

		double firstLowerAbs = (firstClient.getSurveyDataResults().getLowerAbsoluteForce());
		double secondLowerAbs = (secondClient.getSurveyDataResults().getLowerAbsoluteForce());
		double lowerAbsForce;
		if(firstLowerAbs==0 && secondLowerAbs != 0) {
			lowerAbsForce=100;
		}
		else if(firstLowerAbs==0 && secondLowerAbs == 0) {
			lowerAbsForce=0;
		}
		else {
		lowerAbsForce= ((secondLowerAbs - firstLowerAbs) / firstLowerAbs) * 100;
		}
		
		double firstPushAbs = (firstClient.getSurveyDataResults().getPushAbsoluteForce());
		double secondPushAbs = (secondClient.getSurveyDataResults().getPushAbsoluteForce());
		double pushAbsForce;
		if(firstPushAbs==0 && secondPushAbs!= 0) {
			pushAbsForce=100;
		}
		else if(firstPushAbs==0 && secondPushAbs== 0) {
			pushAbsForce=0;
		}
		else {
			pushAbsForce= ((secondPushAbs - firstPushAbs) / firstPushAbs) * 100;
		}
		
		double firstPullAbs = (firstClient.getSurveyDataResults().getPullAbsoluteForce());
		double secondPullAbs = (secondClient.getSurveyDataResults().getPullAbsoluteForce());
		double pullAbsForce;
		if(firstPullAbs==0 && secondPullAbs !=0) {
			pullAbsForce=100;
		}
		else if(firstPullAbs==0 && secondPullAbs ==0) {
			pullAbsForce=0;
		}
		else {
			pullAbsForce= ((secondPullAbs - firstPullAbs) / firstPullAbs) * 100;
		}
		double firstLowerRel = (firstClient.getSurveyDataResults().getLowerRelativeForce());
		double secondLowerRel = (secondClient.getSurveyDataResults().getLowerRelativeForce());
		double lowerRelForce;
		if(firstLowerRel==0 && secondLowerRel !=0 ) {
			lowerRelForce=100;
		}
		else if(firstLowerRel==0 && secondLowerRel ==0 ) {
			lowerRelForce=0;
		}
		else {
		
			lowerRelForce= ((secondLowerRel - firstLowerRel) / firstLowerRel) * 100;
		}
		double firstPushRel = (firstClient.getSurveyDataResults().getPushRelativeForce());
		double secondPushRel = (secondClient.getSurveyDataResults().getPushRelativeForce());

		double pushRelForce;
		if(firstPushRel==0 && secondPushRel != 0) {
			pushRelForce=100;
		}
		else if(firstPushRel==0 && secondPushRel == 0) {
			pushRelForce=0;
		}
		else {
			pushRelForce= ((secondPushRel - firstPushRel) / firstPushRel) * 100;
		}
		double firstPullRel = (firstClient.getSurveyDataResults().getPullRelativeForce());
		double secondPullRel = (secondClient.getSurveyDataResults().getPullRelativeForce());

		double pullRelForce;
		if(firstPullRel==0 && secondPullRel != 0) {
			pullRelForce=100;
		}
		else if(firstPullRel==0 && secondPullRel == 0) {
			pullRelForce=0;
		}
		else {
			pullRelForce= ((secondPullRel - firstPullRel) / firstPullRel) * 100;
		}
		strengthComparison = (lowerAbsForce + pushAbsForce + pullAbsForce + lowerRelForce + pushRelForce
				+ pullRelForce);
		SurveyComparison surveyCompare=surveyComparisonService.findByFirstSurveyIdAndSecondSurveyId(id1, id2);
		if(surveyCompare==null) {
			surveyCompare= new SurveyComparison();
			surveyCompare.setFirstSurveyId(id1);
			surveyCompare.setSecondSurveyId(id2);
			
		}
		
		surveyCompare.setStrengthComparison(strengthComparison);
		surveyComparisonService.save(surveyCompare);
	};

	public void PowerComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);

		double firsts10Power = (firstClient.getSurveyDataResults().getS10PowerOutputResults());
		double seconds10Power = (secondClient.getSurveyDataResults().getS10PowerOutputResults());

		double s10Power;
		
		if(firsts10Power==0 && seconds10Power != 0) {
			s10Power=100;
		}
		else if(firsts10Power==0 && seconds10Power == 0) {
			s10Power=0;
		}
		else {
			s10Power= ((seconds10Power - firsts10Power) / firsts10Power) * 100;
		}
		double firsts60Power = (firstClient.getSurveyDataResults().getS60PowerOutputResults());
		double seconds60Power = (secondClient.getSurveyDataResults().getS60PowerOutputResults());

		double s60Power;
		if(firsts60Power==0 && seconds60Power != 0) {
			s60Power=100;
		}
		else if(firsts60Power==0 && seconds60Power == 0) {
			s60Power=0;
		} else {			
			s60Power= ((seconds60Power - firsts60Power) / firsts60Power) * 100;
		}
		double firsts10Rel = (firstClient.getSurveyDataResults().getS10RelativePowerResults());
		double seconds10Rel = (secondClient.getSurveyDataResults().getS10RelativePowerResults());

		double s10RelativePower;
		if(firsts10Rel==0 && seconds10Rel !=0) {
			s10RelativePower=100;
		}
		else if(firsts10Rel==0 && seconds10Rel ==0) {
			s10RelativePower=0;
		}
		else {
			s10RelativePower= ((seconds10Rel - firsts10Rel) / firsts10Rel) * 100;
		}
		double firsts60Rel = (firstClient.getSurveyDataResults().getS60RelativePower());
		double seconds60Rel = (secondClient.getSurveyDataResults().getS60RelativePower());

		double s60RelativePower;
		if(firsts60Rel==0 && seconds60Rel !=0) {
			s60RelativePower=100;
		}
		else if(firsts60Rel==0 && seconds60Rel ==0) {
			s60RelativePower=0;
		}
		else {
			s60RelativePower= ((seconds60Rel - firsts60Rel) / firsts60Rel) * 100;
		}
		powerComparison = (s10Power + s60Power + s10RelativePower + s60RelativePower);
		SurveyComparison surveyCompare=surveyComparisonService.findByFirstSurveyIdAndSecondSurveyId(id1, id2);
		if(surveyCompare==null) {
			surveyCompare= new SurveyComparison();
			surveyCompare.setFirstSurveyId(id1);
			surveyCompare.setSecondSurveyId(id2);
			
			
		}
		
		surveyCompare.setPowerComparison(powerComparison);
		surveyComparisonService.save(surveyCompare);
	};

	public Long EnduranceComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);

		double firstVo2 = (firstClient.getSurveyDataResults().getVo2Score());
		double secondVo2 = (secondClient.getSurveyDataResults().getVo2Score());

		double vo2Max;
		if(firstVo2==0 && secondVo2 !=0) {
			vo2Max=100;
		}
		else if(firstVo2==0 && secondVo2 ==0) {
			vo2Max=0;
		}
		else {
			vo2Max= ((secondVo2 - firstVo2) / firstVo2) * 100;
			}

		double firstMin4 = (firstClient.getSurveyDataResults().getMin4powerOutput());
		double secondMin4 = (secondClient.getSurveyDataResults().getMin4powerOutput());

		double min4Power;
		if(firstMin4==0 && secondMin4 != 0 ) {
			min4Power=100;
		}
		else if(firstMin4==0 && secondMin4 == 0 ) {
			min4Power=0;
		}
		else {
			min4Power= ((secondMin4 - firstMin4) / firstMin4) * 100;
		}
		double firstMin4Rel = (firstClient.getSurveyDataResults().getMin4RelativePower());
		double secondMin4Rel = (secondClient.getSurveyDataResults().getMin4RelativePower());

		double min4RelativePower;
		if(firstMin4Rel==0 && secondMin4Rel != 0) 
		{
			min4RelativePower=100;
		}
		else if(firstMin4Rel==0 && secondMin4Rel == 0) {
			min4RelativePower=0;
		}
		else {
			min4RelativePower= ((secondMin4Rel - firstMin4Rel) / firstMin4Rel) * 100;
		}
		enduranceComparison = (vo2Max + min4Power + min4RelativePower);
		SurveyComparison surveyCompare=surveyComparisonService.findByFirstSurveyIdAndSecondSurveyId(id1, id2);
		if(surveyCompare==null) {
			surveyCompare= new SurveyComparison();
			surveyCompare.setFirstSurveyId(id1);
			surveyCompare.setSecondSurveyId(id2);
		
		}
		
		surveyCompare.setEnduranceComparison(enduranceComparison);
		double overrallDifference = movementComparison + powerComparison + strengthComparison + enduranceComparison;
		surveyCompare.setOverrallDifference(overrallDifference);
		surveyCompare.setFirstClient(clientId);
		surveyCompare.setSecondClient(secondId);
		surveyCompare.setFirstSurveyId(id1);
		surveyCompare.setSecondSurveyId(id2);
		SurveyComparison survey = surveyComparisonService.save(surveyCompare);
		return survey.getId();

	}

	@Override
	public void NutritionComparison(Long id1, Long id2) {
		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);
		Double Height = 0.0, Weight = 0.0;
		if (firstClient.getUnit() == 'I' && secondClient.getUnit() == 'I') {
			Height = (secondClient.getHeightFeet() * 12 + secondClient.getHeightInches())
					- (firstClient.getHeightFeet() * 12 + firstClient.getHeightInches());
			Weight = (secondClient.getWeight() - firstClient.getWeight());
		} else if (firstClient.getUnit() == 'M' && secondClient.getUnit() == 'M') {
			Height = (secondClient.getHeightCm() - firstClient.getHeightCm());
			Weight = (secondClient.getWeightKg() - firstClient.getWeightKg());
		}

		Double SBP = (double) (secondClient.getSBP() - firstClient.getSBP());
		Double DBP = (double) (secondClient.getDBP() - firstClient.getDBP());
		Double RHR = (double) (secondClient.getRHR() - firstClient.getRHR());
		Double BodyFat = secondClient.getBodyFat() - firstClient.getBodyFat();
		Double BMI = secondClient.getBMI() - firstClient.getBMI();
		Double RMR = secondClient.getRestingMetabolicRateNutrition() - firstClient.getRestingMetabolicRateNutrition();
		Double TotalDailyEnergy = secondClient.getTotalEnergyIntakeNutrition()
				- firstClient.getTotalEnergyIntakeNutrition();
		Double Protein = secondClient.getProteinNutrition() - firstClient.getProteinNutrition();
		Double Carbohydrates = secondClient.getCarbohydratesNutrition() - firstClient.getCarbohydratesNutrition();
		Double TotalFat = secondClient.getTotalFatNutrition() - firstClient.getTotalFatNutrition();
		SurveyComparison surveyCompare=surveyComparisonService.findByFirstSurveyIdAndSecondSurveyId(id1, id2);
		if(surveyCompare==null) {
			surveyCompare= new SurveyComparison();
			surveyCompare.setFirstSurveyId(id1);
			surveyCompare.setSecondSurveyId(id2);			
		
		}
		surveyCompare.setHeightComparison(Height);
		surveyCompare.setWeightComparison(Weight);
		surveyCompare.setRhrComparison(RHR);
		surveyCompare.setSbpComparison(SBP);
		surveyCompare.setDbpComparison(DBP);
		surveyCompare.setBodyFatComparison(BodyFat);
		surveyCompare.setBmiComparison(BMI);
		surveyCompare.setRmrComparison(RMR);
		surveyCompare.setTotalEnergyComparison(TotalDailyEnergy);
		surveyCompare.setProteinComparison(Protein);
		surveyCompare.setCarbohydratesComparison(Carbohydrates);
		surveyCompare.setTotalFatComparison(TotalFat);
		surveyComparisonService.save(surveyCompare);

	};

	@Override
	public void EveryComparison(Long id1, Long id2) {

		SurveyData firstClient = surveyDataRepository.findOne(id1);
		SurveyData secondClient = surveyDataRepository.findOne(id2);

		Double firstSquat = (double)firstClient.getDeepSquatHipFlexion();
		Double secondSquat = (double)secondClient.getDeepSquatHipFlexion();

		Double squat;
		if (firstSquat == 0 && secondSquat != 0) {
			squat = 100.0;
		} else if (firstSquat == 0 && secondSquat == 0){
			squat=0.0;
		}
		else{
			squat = (double) (((secondSquat - firstSquat) / firstSquat) * 100);
		}
		;

		Double shoulderFlexionComparisonL =(double) firstClient.getShoulderFlexionL();
		Double secondshoulderFlexionComparisonL =(double) secondClient.getShoulderFlexionL();
		Double shoulderFlexion;
		if (shoulderFlexionComparisonL == 0 && secondshoulderFlexionComparisonL !=0 ) {
			shoulderFlexion = 100.0;
		} else if (shoulderFlexionComparisonL == 0 && secondshoulderFlexionComparisonL ==0 )
			{shoulderFlexion=0.0;}
		else
		{
			shoulderFlexion = (double) (((secondshoulderFlexionComparisonL - shoulderFlexionComparisonL)
					/ shoulderFlexionComparisonL) * 100);
		}

		Double shoulderFlexionComparisonR =(double) firstClient.getShoulderFlexionR();
		Double secondshoulderFlexionComparisonR =(double) secondClient.getShoulderFlexionR();
		Double shoulderFlexionR;
		if (shoulderFlexionComparisonR == 0 && secondshoulderFlexionComparisonR !=0) {
			shoulderFlexionR = 100.0;
		} else if (shoulderFlexionComparisonR == 0 && secondshoulderFlexionComparisonR ==0) {
			shoulderFlexionR = 0.0;
		}
		
		else{
			shoulderFlexionR = (double) (((secondshoulderFlexionComparisonR - shoulderFlexionComparisonR)
					/ shoulderFlexionComparisonR) * 100);
		}

		Double shoulderExensionComparisonR =(double) firstClient.getShoulderExtensionR();
		Double secondshoulderExensionComparisonR =(double) secondClient.getShoulderExtensionR();
		Double shoulderExtension;
		if (shoulderExensionComparisonR == 0 && secondshoulderExensionComparisonR !=0) {
			shoulderExtension = 100.0;
		} else if(shoulderExensionComparisonR == 0 && secondshoulderExensionComparisonR ==0) {
			shoulderExtension = 0.0;
		}
		
		else {
			shoulderExtension = (double) (((secondshoulderExensionComparisonR - shoulderExensionComparisonR)
					/ shoulderExensionComparisonR) * 100);
		}

		Double shoulderExtensionComparisonL =(double) firstClient.getShoulderExtensionL();
		Double secondshoulderExtensionComparison =(double) secondClient.getShoulderExtensionL();

		Double shoulderExtensionL;
		if (shoulderExtensionComparisonL == 0 && secondshoulderExtensionComparison != 0) {
			shoulderExtensionL = 100.0;
		} else if (shoulderExtensionComparisonL == 0 && secondshoulderExtensionComparison == 0) {
			shoulderExtensionL = 0.0;
		}		
		else {
			shoulderExtensionL = (double) (((secondshoulderExtensionComparison - shoulderExtensionComparisonL)
					/ shoulderExtensionComparisonL) * 100);
		}

		Double trunkRotationComparisonR = (double)firstClient.getTrunkRotationR();
		Double secondtrunkRotationComparisonR = (double)secondClient.getTrunkRotationR();
		Double trunkRotation;
		if (trunkRotationComparisonR == 0 && secondtrunkRotationComparisonR !=0) {
			trunkRotation = 100.0;
		} else if (trunkRotationComparisonR == 0 && secondtrunkRotationComparisonR ==0) {
			trunkRotation = 0.0;
		}
		
		else {
			trunkRotation = (double) (((secondtrunkRotationComparisonR - trunkRotationComparisonR)
					/ trunkRotationComparisonR) * 100);
		}

		Double trunkRotationComparisonL =(double) firstClient.getTrunkRotationL();
		Double secondtrunkRotationComparisonL = (double)secondClient.getTrunkRotationL();
		Double trunkRotationL;
		if (trunkRotationComparisonL == 0 && secondtrunkRotationComparisonL !=0) {
			trunkRotationL = 100.0;
		} else  if (trunkRotationComparisonL == 0 && secondtrunkRotationComparisonL ==0) {
			trunkRotationL = 0.0;
		}else{
			trunkRotationL = (double) (((secondtrunkRotationComparisonL - trunkRotationComparisonL)
					/ trunkRotationComparisonL) * 100);
		}

		Double pistolSquatComparisonR = firstClient.getPistolR();
		Double secondpistolSquatComparisonR = secondClient.getPistolR();
		Double pistolSquat;
		if (pistolSquatComparisonR == 0 && secondpistolSquatComparisonR !=0) {
			pistolSquat = 100.0;
		}else if(pistolSquatComparisonR == 0 && secondpistolSquatComparisonR ==0) {
			pistolSquat = 0.0;
		}
		else {
			pistolSquat = (double) (((secondpistolSquatComparisonR - pistolSquatComparisonR) / pistolSquatComparisonR)
					* 100);
		}

		Double pistolSquatComparisonL = firstClient.getPistolL();
		Double secondpistolSquatComparisonL = secondClient.getPistolL();
		Double pistolSquatL;
		if (pistolSquatComparisonL == 0 && secondpistolSquatComparisonL !=0 ) {
			pistolSquatL = 100.0;
		} else if (pistolSquatComparisonL == 0 && secondpistolSquatComparisonL ==0 ) {
			pistolSquatL = 0.0;
		} else {
			pistolSquatL = (double) (((secondpistolSquatComparisonL - pistolSquatComparisonL) / pistolSquatComparisonL)
					* 100);
		}

		Double proneRHComparison = firstClient.getProneRH_LF();
		Double secondproneRHComparison = secondClient.getProneRH_LF();
		Double proneRH;
		if (proneRHComparison == 0 && secondproneRHComparison != 0) {
			proneRH = 100.0;
		} else if (proneRHComparison == 0 && secondproneRHComparison == 0) {
			proneRH = 0.0;
		} 
		else{
			proneRH = (double) (((secondproneRHComparison - proneRHComparison) / proneRHComparison) * 100);
		}

		Double proneLHComparison = firstClient.getProneRF_RH();
		Double secondproneLHComparison = secondClient.getProneRF_RH();

		Double proneLH;
		if (proneLHComparison == 0 && secondproneLHComparison !=0) {
			proneLH = 100.0;
		} else if(proneLHComparison == 0 && secondproneLHComparison ==0) {
			proneLH = 0.0;
		}
		else		
		{
			proneLH = (double) (((secondproneLHComparison - proneLHComparison) / proneLHComparison) * 100);
		}

		Double VSitComparison = firstClient.getVsit();
		Double secondVSitComparison = secondClient.getVsit();
		Double vSit;
		if (VSitComparison == 0 && secondVSitComparison !=0 ) {
			vSit = 100.0;
		} else if (VSitComparison == 0 && secondVSitComparison ==0 ) {
			vSit = 0.0;
		}else{
			vSit = (double) (((secondVSitComparison - VSitComparison) / VSitComparison) * 100);
		}

		Double lowerAbsComparison = (double) (firstClient.getSurveyDataResults().getLowerAbs());
		Double secondlowerAbsComparison = (double) (secondClient.getSurveyDataResults().getLowerAbs());
		Double lowerAbs;
		if (lowerAbsComparison == 0 && secondlowerAbsComparison !=0 ) {
			lowerAbs = 100.0;
		} else if (lowerAbsComparison == 0 && secondlowerAbsComparison ==0 ) {
			lowerAbs = 0.0;
		}else {
			lowerAbs = (double) (((secondlowerAbsComparison - lowerAbsComparison) / lowerAbsComparison) * 100);
		}

		Double lowerRelComparison = firstClient.getSurveyDataResults().getLowerRel();
		Double secondlowerRelComparison = secondClient.getSurveyDataResults().getLowerRel();
		Double lowerRel;
		if (lowerRelComparison == 0 && secondlowerRelComparison !=0) {
			lowerRel = 100.0;
		} else if (lowerRelComparison == 0 && secondlowerRelComparison ==0) {
			lowerRel = 0.0;
		} else {
			lowerRel = (double) (((secondlowerRelComparison - lowerRelComparison) / lowerRelComparison) * 100);
		}

		Double pushAbsComparison = (double) firstClient.getSurveyDataResults().getPushAbs();
		Double secondpushAbsComparison = (double) secondClient.getSurveyDataResults().getPushAbs();
		Double pushAbs;
		if (pushAbsComparison == 0 && secondpushAbsComparison !=0) {
			pushAbs = 100.0;
		} else if (pushAbsComparison == 0 && secondpushAbsComparison ==0) {
			pushAbs = 0.0;
		}else{
			pushAbs = (double) (((secondpushAbsComparison - pushAbsComparison) / pushAbsComparison) * 100);
		}

		Double pushRelComparison = firstClient.getSurveyDataResults().getPushRel();
		Double secondpushRelComparison = firstClient.getSurveyDataResults().getPushRel();
		Double pushRel;
		if (pushRelComparison == 0 && secondpushRelComparison !=0) {
			pushRel = 100.0;
		} else if (pushRelComparison == 0 && secondpushRelComparison ==0) {
			pushRel = 0.0;
		} else {
			pushRel = (double) (((secondpushRelComparison - pushRelComparison) / pushRelComparison) * 100);
		}

		Double pullAbsComparison = (double) firstClient.getSurveyDataResults().getPullAbs();
		Double secondpullAbsComparison = (double) secondClient.getSurveyDataResults().getPullAbs();
		Double pullAbs;
		if (pullAbsComparison == 0 && secondpullAbsComparison !=0) {
			pullAbs = 100.0;
		} else if (pullAbsComparison == 0 && secondpullAbsComparison ==0) {
			pullAbs = 0.0;
		}else {
			pullAbs = (double) (((secondpullAbsComparison - pullAbsComparison) / pullAbsComparison) * 100);
		}

		Double pullRelComparison = firstClient.getSurveyDataResults().getPullRel();
		Double secondpullRelComparison = secondClient.getSurveyDataResults().getPullRel();
		Double pullRel;
		if (pullRelComparison == 0 && secondpullRelComparison !=0) {
			pullRel = 100.0;
		} else if(pullRelComparison == 0 && secondpullRelComparison ==0) {
			pullRel = 0.0;
		}else {
			pullRel = (double) (((secondpullRelComparison - pullRelComparison) / pullRelComparison) * 100);
		}

		Double s10PowerComparison = (double) firstClient.getS10PowerOutput();
		Double seconds10PowerComparison = (double) secondClient.getS10PowerOutput();

		Double s10;
		if (s10PowerComparison == 0 && seconds10PowerComparison != 0 ) {
			s10 = 100.0;
		} else if (s10PowerComparison == 0 && seconds10PowerComparison == 0 ) {
			s10 = 0.0;
		} else {
			s10 = (double) (((seconds10PowerComparison - s10PowerComparison) / s10PowerComparison) * 100);
		}

		Double s10RelComparison = firstClient.getSurveyDataResults().getS10RelativePower();
		Double seconds10RelComparison = secondClient.getSurveyDataResults().getS10RelativePower();
		Double s10Rel;
		if (s10RelComparison == 0 && seconds10RelComparison != 0) {
			s10Rel = 100.0;
		} else if (s10RelComparison == 0 && seconds10RelComparison == 0) {
			s10Rel = 0.0;
		}else {
			s10Rel = (double) (((seconds10RelComparison - s10RelComparison) / s10RelComparison) * 100);
		}

		Double s60PowerComparison = (double) firstClient.getS60PowerOutput();
		Double seconds60PowerComparison = (double) secondClient.getS60PowerOutput();
		Double s60;
		if (s60PowerComparison == 0 && seconds60PowerComparison !=0) {
			s60 = 100.0;
		} else if(s60PowerComparison == 0 && seconds60PowerComparison ==0) {
			s60 = 0.0;
		}else{
			s60 = (double) (((seconds60PowerComparison - s60PowerComparison) / s60PowerComparison) * 100);
		}

		Double s60RelComparison = firstClient.getSurveyDataResults().getS60RelativePowerCalc();
		Double seconds60RelComparison = secondClient.getSurveyDataResults().getS60RelativePowerCalc();
		Double s60Rel;
		if (s60RelComparison == 0 && seconds60RelComparison !=0) {
			s60Rel = 100.0;
		} else if (s60RelComparison == 0 && seconds60RelComparison ==0) {
			s60Rel = 0.0;
		} else{
			s60Rel = (double) (((seconds60RelComparison - s60RelComparison) / s60RelComparison) * 100);
		}

		Double vo2Max = firstClient.getSurveyDataResults().getVo2Max();
		Double secondvo2Max = secondClient.getSurveyDataResults().getVo2Max();
		Double vo2;
		if (vo2Max == 0 && secondvo2Max !=0) {
			vo2 = 100.0;
		} else if (vo2Max == 0 && secondvo2Max ==0) {
			vo2 = 0.0;
		}else{
			vo2 = (double) (((secondvo2Max - vo2Max) / vo2Max) * 100);
		}

		Double min4RelPower = firstClient.getSurveyDataResults().getMin4RelativePowerScored();
		Double secondmin4RelPower = secondClient.getSurveyDataResults().getMin4RelativePowerScored();
		Double min4Rel;
		if (min4RelPower == 0 && secondmin4RelPower  !=0) {
			min4Rel = 100.0;
		} else if (min4RelPower == 0 && secondmin4RelPower  ==0) {
			min4Rel = 0.0;
		}else{
			min4Rel = (double) (((secondmin4RelPower - min4RelPower) / min4RelPower) * 100);
		}
		SurveyComparison surveyCompare=surveyComparisonService.findByFirstSurveyIdAndSecondSurveyId(id1, id2);
		if(surveyCompare==null) {
			surveyCompare= new SurveyComparison();
			surveyCompare.setFirstSurveyId(id1);
			surveyCompare.setSecondSurveyId(id2);
		}

		surveyCompare.setDeepSquatComparison(squat);
		surveyCompare.setShoulderFlexionComparisonL(shoulderFlexion);
		surveyCompare.setShoulderFlexionComparisonR(shoulderFlexionR);
		surveyCompare.setShoulderExtensionComparisonL(shoulderExtensionL);
		surveyCompare.setShoulderExensionComparisonR(shoulderExtension);
		surveyCompare.setTrunkRotationComparisonL(trunkRotationL);
		surveyCompare.setTrunkRotationComparisonR(trunkRotation);

		surveyCompare.setPistolSquatComparisonL(pistolSquatL);
		surveyCompare.setPistolSquatComparisonR(pistolSquat);
		surveyCompare.setProneLHComparison(proneLH);
		surveyCompare.setProneRHComparison(proneRH);
		surveyCompare.setVSitComparison(vSit);

		surveyCompare.setLowerAbsComparison(lowerAbs);
		surveyCompare.setLowerRelComparison(lowerRel);
		surveyCompare.setPushAbsComparison(pushAbs);
		surveyCompare.setPushRelComparison(pushRel);
		surveyCompare.setPullAbsComparison(pullAbs);
		surveyCompare.setPullRelComparison(pullRel);

		surveyCompare.setS10PowerComparison(s10);
		surveyCompare.setS10RelComparison(s10Rel);
		surveyCompare.setS60PowerComparison(s60);
		surveyCompare.setS60RelComparison(s60Rel);

		surveyCompare.setVo2Max(vo2);
		surveyCompare.setMin4RelPower(min4Rel);

		surveyComparisonService.save(surveyCompare);

	}
}
