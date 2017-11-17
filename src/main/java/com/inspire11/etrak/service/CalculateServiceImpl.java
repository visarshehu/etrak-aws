package com.inspire11.etrak.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inspire11.etrak.lookup.LookUp;
import com.inspire11.etrak.lookup.LookUpRelative;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.model.SurveyDataResults;
import com.inspire11.etrak.repository.SurveyDataRepository;

@Service("calculateService")
public class CalculateServiceImpl implements CalculateService {
	@Autowired
	private SurveyDataRepository surveyDataRepository;

	//@Autowired
	//private SurveyServiceResults surveyServiceResults;

	@Autowired
	private LookUp lookupTable;
	
	@Autowired
	private SurveyService surveyService;

	@Autowired
	private LookUpRelative lookupRelative;

	private double etrak;

	private Integer power, strength, endurance, movement;


	@Override
	public void CalculateMovement(Long id) {
		SurveyData survey = surveyDataRepository.findOne(id);
	
		int deepSquat = lookupTable.getScore("DeepSquatHipFlexion", survey.getDeepSquatHipFlexion());

		int shoulderFlexionR = lookupTable.getScore("ShoulderFlexion", survey.getShoulderFlexionR());

		int shoulderFlexionL = lookupTable.getScore("ShoulderFlexion", survey.getShoulderFlexionL());

		int shoulderExtensionR = lookupTable.getScore("ShoulderExtension", survey.getShoulderExtensionR());

		int shoulderExtensionL = lookupTable.getScore("ShoulderExtension", survey.getShoulderExtensionL());

		int trunkRotationR = lookupTable.getScore("TrunkRotation", survey.getTrunkRotationR());

		int trunkRotationL = lookupTable.getScore("TrunkRotation", survey.getTrunkRotationL());

		double rangeScore = (deepSquat + shoulderFlexionR + shoulderFlexionL + shoulderExtensionR + shoulderExtensionL
				+ trunkRotationL + trunkRotationR) / (7.0);
		int range = (int) Math.round((rangeScore));

		double pistolSquatR = Math.round((survey.getPistolR() / 3) * 10);

		double pistolSquatL = Math.round((survey.getPistolL() / 3) * 10);

		double proneRH_LF = Math.round((survey.getProneRH_LF() / 3) * 10);

		double proneLF_RH = Math.round((survey.getProneRF_RH() / 3) * 10);

		double vSit = Math.round((survey.getVsit() / (3.0)) * 10);

		double controlScore = ((pistolSquatR + pistolSquatL + proneRH_LF + proneLF_RH + vSit) / 5);
		int control = (int) Math.round(controlScore);
		double movementScore = ((range + control) / 2.0);
		movement = (int) Math.round(movementScore);
		
		 SurveyDataResults  surveyresults = survey.getSurveyDataResults();
		    if (surveyresults == null) {
		        surveyresults = new SurveyDataResults();
		        survey.setSurveyDataResults(surveyresults);
		    }
		    
		surveyresults.setMovement(movement);
		surveyresults.setRangeScore(range);
		surveyresults.setControlScore(control);
		surveyresults.setDeepSquatScore(deepSquat);
		surveyresults.setShoulderFlexionLScore(shoulderFlexionL);
		surveyresults.setShoulderFlexionRScore(shoulderFlexionR);
		surveyresults.setShoulderExtensionLScore(shoulderExtensionL);
		surveyresults.setShoulderExtensionRScore(shoulderExtensionR);
		surveyresults.setTrunkRotationLScore(trunkRotationL);
		surveyresults.setTrunkRotationRScore(trunkRotationR);
		surveyresults.setPistolSquatRScore(pistolSquatR);
		surveyresults.setPistolSquatLScore(pistolSquatL);
		surveyresults.setProneLH_RFScore(proneLF_RH);
		surveyresults.setProneRH_LFScore(proneRH_LF);
		surveyresults.setvSitScore(vSit);
		
	
		surveyDataRepository.save(survey);

	}

	@Override
	public void CalculateStrength(Long id) {
		SurveyData survey = surveyDataRepository.findOne(id);

		int scoreAbsForce = 0, scoreRelForce=0, scorePushAbs=0, scorePushRel=0, scorePullAbs=0, scorePullRel=0;
		
		int lowerAbsoluteForce = 0,pushAbsoluteForce=0,pullAbsoluteForce=0;
		double lowerRelativeForce=0,pushRelativeForce=0,pullRelativeForce=0;
		if(survey.getUnit()=='I') {
		
		 lowerAbsoluteForce = (int) (survey.getLowerMaxL() + survey.getLowerMaxR());
		 lowerRelativeForce = (survey.getLowerMaxL() + survey.getLowerMaxR()) / survey.getWeight();
		 pushAbsoluteForce = (int) (survey.getPushMaxR() + survey.getPushMaxL());
		 pushRelativeForce = (survey.getPushMaxR() + survey.getPushMaxL()) / survey.getWeight();
		 pullAbsoluteForce = (int) (survey.getPullMaxL() + survey.getPullMaxR());
		 pullRelativeForce = (survey.getPullMaxL() + survey.getPullMaxR()) / survey.getWeight();

		if (survey.getClient().getGender() == 'F') {
			scoreAbsForce = lookupTable.getScore("LowerBodyForceWomen", lowerAbsoluteForce);
			scoreRelForce = lookupRelative.getScore("LowerRelativeWomen", lowerRelativeForce);
			scorePushAbs = lookupTable.getScore("PushPullWomen", pushAbsoluteForce);
			scorePushRel = lookupRelative.getScore("PushPullWomenRelative", pushRelativeForce);
			scorePullAbs = lookupTable.getScore("PushPullWomen", pullAbsoluteForce);
			scorePullRel = lookupRelative.getScore("PushPullWomenRelative", pullRelativeForce);

		} else {
			scoreAbsForce = lookupTable.getScore("LowerBodyForceMen", lowerAbsoluteForce);
			scoreRelForce = lookupRelative.getScore("LowerRelativeForce", lowerRelativeForce);
			scorePushAbs = lookupTable.getScore("PushPullMen", pushAbsoluteForce);
			scorePushRel = lookupRelative.getScore("PushPullRelative", pushRelativeForce);
			scorePullAbs = lookupTable.getScore("PushPullMen", pullAbsoluteForce);
			scorePullRel = lookupRelative.getScore("PushPullRelative", pullRelativeForce);
		}

	
		
		}
		
		else if(survey.getUnit()=='M') {
			
			 lowerAbsoluteForce = (int) (survey.getLowerMaxLKg() + survey.getLowerMaxRKg());
			 lowerRelativeForce = (survey.getLowerMaxLKg() + survey.getLowerMaxRKg()) / survey.getWeightKg();
			 pushAbsoluteForce = (int) (survey.getPushMaxRKg() + survey.getPushMaxLKg());
			 pushRelativeForce = (survey.getPushMaxRKg() + survey.getPushMaxLKg()) / survey.getWeightKg();
			 pullAbsoluteForce = (int) (survey.getPullMaxKg() + survey.getPullMaxKg());
			 pullRelativeForce = (survey.getPullMaxKg() + survey.getPullMaxKg()) / survey.getWeightKg();

			if (survey.getClient().getGender() == 'F') {
				scoreAbsForce = lookupTable.getScore("LowerBodyForceWomenMetric", lowerAbsoluteForce);
				scoreRelForce = lookupRelative.getScore("LowerRelativeWomen", lowerRelativeForce);
				scorePushAbs = lookupTable.getScore("PushPullWomenMetric", pushAbsoluteForce);
				scorePushRel = lookupRelative.getScore("PushPullWomenRelative", pushRelativeForce);
				scorePullAbs = lookupTable.getScore("PushPullWomenMetric", pullAbsoluteForce);
				scorePullRel = lookupRelative.getScore("PushPullWomenRelative", pullRelativeForce);

			} else {
				scoreAbsForce = lookupTable.getScore("LowerBodyForceMenMetric", lowerAbsoluteForce);
				scoreRelForce = lookupRelative.getScore("LowerRelativeForce", lowerRelativeForce);
				scorePushAbs = lookupTable.getScore("PushPullMenMetric", pushAbsoluteForce);
				scorePushRel = lookupRelative.getScore("PushPullRelative", pushRelativeForce);
				scorePullAbs = lookupTable.getScore("PushPullMenMetric", pullAbsoluteForce);
				scorePullRel = lookupRelative.getScore("PushPullRelative", pullRelativeForce);
			}

		
			
		}
		
		int absoluteStrength = (int) Math.round((scoreAbsForce + scorePushAbs + scorePullAbs) / 3);
		int relativeStrength = (int) Math.round((scoreRelForce + scorePushRel + scorePullRel) / 3);
		double strengthScore = (absoluteStrength + relativeStrength) / 2.0;
		strength = (int) Math.round(strengthScore);
		 SurveyDataResults  surveyresults = survey.getSurveyDataResults();
		    if (surveyresults == null) {
		        surveyresults = new SurveyDataResults();
		        survey.setSurveyDataResults(surveyresults);
		    }
		surveyresults.setLowerAbs(lowerAbsoluteForce);
		surveyresults.setLowerRel(lowerRelativeForce);
		surveyresults.setPushAbs(pushAbsoluteForce);
		surveyresults.setPushRel(pushRelativeForce);
		surveyresults.setPullAbs(pullAbsoluteForce);
		surveyresults.setPullRel(pullRelativeForce);

		surveyresults.setLowerAbsoluteForce(scoreAbsForce);
		surveyresults.setAbsoluteStrength(absoluteStrength);
		surveyresults.setRelativeStrength(relativeStrength);
		surveyresults.setLowerRelativeForce(scoreRelForce);
		surveyresults.setPushAbsoluteForce(scorePushAbs);
		surveyresults.setPushRelativeForce(scorePushRel);
		surveyresults.setPullAbsoluteForce(scorePullAbs);
		surveyresults.setPullRelativeForce(scorePullRel);
		surveyresults.setStrength(strength);
		surveyDataRepository.save(survey);
	}

	@Override
	public void CalculatePower(Long id) {
		SurveyData survey = surveyDataRepository.findOne(id);

		double s10RelativePower, s60RelativePower;
		int s10PowerOutput, s60PowerOutput, s10RelativePowerResult, s60RelativePowerResult;
		
		
		if(survey.getUnit()=='I') {
		
		if (survey.getClient().getGender() == 'F') {
			
			int output=survey.getS10PowerOutput();
			s10PowerOutput = lookupTable.getScore("AbsolutePowerWomen10", output);
			s60PowerOutput = lookupTable.getScore("AbsolutePowerWomen60", survey.getS60PowerOutput());
			s10RelativePower = survey.getS10PowerOutput() / (survey.getWeight() / 2.2);
			s60RelativePower = survey.getS60PowerOutput() / (survey.getWeight() / 2.2);
			s10RelativePowerResult = lookupRelative.getScore("s10RelativePowerWomen", s10RelativePower);
			s60RelativePowerResult = lookupRelative.getScore("s60RelativePowerWomen", s60RelativePower);
		} else {
			int output=survey.getS10PowerOutput();
			s10PowerOutput = lookupTable.getScore("AbsolutePowerMen10", output);
			s60PowerOutput = lookupTable.getScore("AbsolutePowerMen60", survey.getS60PowerOutput());
			s10RelativePower = survey.getS10PowerOutput() / (survey.getWeight() / 2.2);
			s60RelativePower = survey.getS60PowerOutput() / (survey.getWeight() / 2.2);
			s10RelativePowerResult = lookupRelative.getScore("s10RelativePowerMen", s10RelativePower);
			s60RelativePowerResult = lookupRelative.getScore("s60RelativePowerMen", s60RelativePower);
		}}
		else {
			
			if (survey.getClient().getGender() == 'F') {
				s10PowerOutput = lookupTable.getScore("AbsolutePowerWomen10Metric", survey.getS10PowerOutput());
				s60PowerOutput = lookupTable.getScore("AbsolutePowerWomen60Metric", survey.getS60PowerOutput());
				s10RelativePower = survey.getS10PowerOutput() / (survey.getWeightKg());
				s60RelativePower = survey.getS60PowerOutput() / (survey.getWeightKg());
				s10RelativePowerResult = lookupRelative.getScore("s10RelativePowerWomenMetric", s10RelativePower);
				s60RelativePowerResult = lookupRelative.getScore("s60RelativePowerWomenMetric", s60RelativePower);
			} else {
				s10PowerOutput = lookupTable.getScore("AbsolutePowerMen10", survey.getS10PowerOutput());
				s60PowerOutput = lookupTable.getScore("AbsolutePowerMen60", survey.getS60PowerOutput());
				s10RelativePower = survey.getS10PowerOutput() / (survey.getWeightKg());
				s60RelativePower = survey.getS60PowerOutput() / (survey.getWeightKg());
				s10RelativePowerResult = lookupRelative.getScore("s10RelativePowerMenMetric", s10RelativePower);
				s60RelativePowerResult = lookupRelative.getScore("s60RelativePowerMenMetric", s60RelativePower);
			}
			
		}
		int absPower = (int) Math.round((s10PowerOutput + s60PowerOutput) / 2.0);
		int relPower = (int) Math.round((s10RelativePowerResult + s60RelativePowerResult) / 2.0);
		double powerScore = (absPower + relPower) / (2.0);
		power = (int) Math.round(powerScore);
		SurveyDataResults  surveyresults = survey.getSurveyDataResults();
	    if (surveyresults == null) {
	        surveyresults = new SurveyDataResults();
	        survey.setSurveyDataResults(surveyresults);
	    }
		surveyresults.setS10RelativePowerResults(s10RelativePowerResult);
		surveyresults.setS60PowerOutputResults(s60PowerOutput);
		surveyresults.setS10PowerOutputResults(s10PowerOutput);
		surveyresults.setS10RelativePower(s10RelativePower);
		surveyresults.setS60RelativePowerCalc(s60RelativePower);
		surveyresults.setAbsolutePower(absPower);
		surveyresults.setRelativePower(relPower);
		surveyresults.setS60RelativePower(s60RelativePowerResult);
		surveyresults.setPower(power);
	    surveyDataRepository.save(survey);
	}

	@Override
	public void CalculateEndurance(Long id) {
		double vo2Max, min4RelativePower;
		int scoremin4Relative, vo2Score, vo2Result, min4PowerOutput;
		double calories,seconds,weight;
		SurveyData survey = surveyDataRepository.findOne(id);
		if(survey.getUnit()=='I') {
		if (survey.getClient().getGender() == 'F') {
			 calories=survey.getCalories() ;
			 seconds=survey.getKmRow() ;
			 weight=survey.getWeight();
			vo2Max = (((calories / (seconds / 60)) / 5) * 1000) / (weight / (2.2));
			vo2Result = (int) Math.round(vo2Max);
			vo2Score = lookupTable.getScore("VO2", vo2Result);
			min4PowerOutput = lookupTable.getScore("PowerOutput4minWomen", survey.getMin4PowerOutput());
			min4RelativePower = (survey.getMin4PowerOutput()) / (survey.getWeight()/2.2);
			scoremin4Relative = lookupRelative.getScore("PeakRelative", min4RelativePower);

		}

		else {
			 calories=survey.getCalories() ;
			 seconds=survey.getKmRow() ;
			 weight=survey.getWeight();
			vo2Max = (((calories / (seconds / 60)) / 5) * 1000) / (weight / (2.2));
			vo2Result = (int) Math.round(vo2Max);
			vo2Score = lookupTable.getScore("VO2", vo2Result);
			min4PowerOutput = lookupTable.getScore("AbsolutePower4Min", survey.getMin4PowerOutput());
			min4RelativePower = (survey.getMin4PowerOutput()) / (survey.getWeight()/2.2);
			scoremin4Relative = lookupRelative.getScore("PeakRelative", min4RelativePower);
		}}
		else {
			if (survey.getClient().getGender() == 'F') {
				 calories=survey.getCalories() ;
				 seconds=survey.getKmRow() ;
				 weight=survey.getWeightKg();
				vo2Max = (((calories / (seconds / 60)) / 5) * 1000) / (weight);
				vo2Result = (int) Math.round(vo2Max);
				vo2Score = lookupTable.getScore("VO2", vo2Result);
				min4PowerOutput = lookupTable.getScore("PowerOutput4minWomen", survey.getMin4PowerOutput());
				min4RelativePower = (survey.getMin4PowerOutput()) / (survey.getWeight()/2.2);
				scoremin4Relative = lookupRelative.getScore("PeakRelative", min4RelativePower);

			}

			else {
				 calories=survey.getCalories() ;
				 seconds=survey.getKmRow() ;
				 weight=survey.getWeightKg();
				vo2Max = (((calories / (seconds / 60)) / 5) * 1000) / (weight);
				vo2Result = (int) Math.round(vo2Max);
				vo2Score = lookupTable.getScore("VO2", vo2Result);
				min4PowerOutput = lookupTable.getScore("AbsolutePower4Min", survey.getMin4PowerOutput());
				min4RelativePower = (survey.getMin4PowerOutput()) / (survey.getWeightKg());
				scoremin4Relative = lookupRelative.getScore("min4RelativeMen", min4RelativePower);
			}
		}

		SurveyDataResults  surveyresults = survey.getSurveyDataResults();
	    if (surveyresults == null) {
	        surveyresults = new SurveyDataResults();
	        survey.setSurveyDataResults(surveyresults);
	    }
		double enduranceScore = (vo2Score + scoremin4Relative) / 2.0;
		int enduranceAbsolute = (int) Math.round(vo2Score);
		int relativeEndurance = (int) Math.round(scoremin4Relative);
		endurance = (int) Math.round(enduranceScore);
		etrak = (movement + power + strength + endurance) / 4.0;
		surveyresults.setVo2Max(vo2Max);
		surveyresults.setVo2Score(vo2Score);
		surveyresults.setMin4powerOutput(min4PowerOutput);
		surveyresults.setAbsoluteEndurance(enduranceAbsolute);
		surveyresults.setRelativeEndurance(relativeEndurance);
		surveyresults.setMin4RelativePower(scoremin4Relative);
		surveyresults.setMin4RelativePowerScored(min4RelativePower);
		surveyresults.setEndurance(endurance);
		surveyresults.setEtrakScore(etrak);
	    surveyDataRepository.save(survey);


	}

	@Override
	public void CalculateNutrition(Long id) {
		
		SurveyData survey = surveyDataRepository.findOne(id);
		char gender;
		double BMI,restingMetabolicRate, totalEnergyIntake, protein = 0, carbohydrates = 0, totalFat = 0, goalCoefficient = 0;
		final Calendar now = Calendar.getInstance();
		final Calendar then = Calendar.getInstance();
		double weight,height;
		Date birthdate=survey.getClient().getBirthDate();
		then.setTime(birthdate);
		double age = (now.get(Calendar.YEAR) - then.get(Calendar.YEAR));
		if(survey.getUnit()=='I') {
			weight=survey.getWeight() ;
			height=(survey.getHeightFeet() * 12 + survey.getHeightInches());
			BMI=(weight/2.2)/((height*0.0254)*(height*0.0254));
		 
		 gender=survey.getClient().getGender();
			if (gender == 'F') {
				restingMetabolicRate = ((weight / 2.2) * 10) + (( height * 2.54)*6.25) - (age * 5) - 161;
			} else {
				restingMetabolicRate = ((weight / 2.2) * 10) + (( height * 2.54)*6.25) - (age * 5) +5;

			}
		}
		
		else {
			weight=survey.getWeightKg();
			height=survey.getHeightCm();
			BMI=(weight)/(height*height);
			 gender=survey.getClient().getGender();
			if (gender == 'F') {
				restingMetabolicRate =(weight*10)+(height*6.25)-(age*5)-161;
			} else {
				restingMetabolicRate = (weight*10)+(height*6.25)-(age*5)+5;
			}
			
		}
		
		
		double activityScore=0;
		String activityLevel=survey.getActivityLevel_id();
		if(activityLevel.equals("5")){
			activityScore = 1.9;}
		else if(activityLevel.equals("1")){
			activityScore =  1.2;}
		else if(activityLevel.equals("2")){
			activityScore = 1.375;}
		else if(activityLevel.equals("3")){
			activityScore = 1.55;}
		else if(activityLevel.equals("4")){
			activityScore = 1.725;}
		
		double activityCoefficient = restingMetabolicRate *activityScore;

		if (survey.getNutritionalGoal().equals("maintain")) {
			goalCoefficient = 0;
		} else if (survey.getNutritionalGoal().equals("gain")) {
			goalCoefficient = 750;
		} else if (survey.getNutritionalGoal().equals("lose")) {
			goalCoefficient = -500;
		}

		totalEnergyIntake = activityCoefficient + goalCoefficient;

		if (survey.getNutritionalGoal().equals("maintain")) {
			protein = totalEnergyIntake * 0.05;
			carbohydrates = totalEnergyIntake * 0.125;
			totalFat = totalEnergyIntake * 0.03333;
		} else if (survey.getNutritionalGoal().equals("gain")) {
			protein = totalEnergyIntake * 0.075;
			carbohydrates = totalEnergyIntake * 0.1375;
			totalFat = totalEnergyIntake * 0.01667;
		} else if (survey.getNutritionalGoal().equals("lose")) {
			protein = totalEnergyIntake * 0.075;
			carbohydrates = totalEnergyIntake * 0.1125;
			totalFat = totalEnergyIntake * 0.027778;
		}

		survey.setBMI(BMI);
		survey.setRestingMetabolicRateNutrition(restingMetabolicRate);
		survey.setTotalEnergyIntakeNutrition(totalEnergyIntake);
		survey.setProteinNutrition(protein);
		survey.setCarbohydratesNutrition(carbohydrates);
		survey.setTotalFatNutrition(totalFat);
		surveyService.saveSurvey(survey);
		
	}

}

