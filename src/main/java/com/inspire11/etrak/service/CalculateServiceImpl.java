package com.inspire11.etrak.service;

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

	@Autowired
	private SurveyServiceResults surveyServiceResults;

	@Autowired
	private LookUp lookupTable;

	@Autowired
	private LookUpRelative lookupRelative;

	private double etrak;

	private Integer power, strength, endurance, movement;

	SurveyDataResults surveyresults = new SurveyDataResults();

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

		survey.setSurveyDataResults(surveyresults);
		surveyServiceResults.saveSurveyResults(surveyresults);

	}

	@Override
	public void CalculateStrength(Long id) {
		SurveyData survey = surveyDataRepository.findOne(id);
		int scoreAbsForce, scoreRelForce, scorePushAbs, scorePushRel, scorePullAbs, scorePullRel;
		int lowerAbsoluteForce = (int) (survey.getLowerMaxL() + survey.getLowerMaxR());
		double lowerRelativeForce = (survey.getLowerMaxL() + survey.getLowerMaxR()) / survey.getWeight();
		int pushAbsoluteForce = (int) (survey.getPushMaxR() + survey.getPushMaxL());
		double pushRelativeForce = (survey.getPushMaxR() + survey.getPushMaxL()) / survey.getWeight();
		int pullAbsoluteForce = (int) (survey.getPullMaxL() + survey.getPullMaxR());
		double pullRelativeForce = (survey.getPullMaxL() + survey.getPullMaxR()) / survey.getWeight();

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

		int absoluteStrength = (int) Math.round((scoreAbsForce + scorePushAbs + scorePullAbs) / 3);
		int relativeStrength = (int) Math.round((scoreRelForce + scorePushRel + scorePullRel) / 3);
		double strengthScore = (absoluteStrength + relativeStrength) / 2.0;
		strength = (int) Math.round(strengthScore);
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
		surveyServiceResults.saveSurveyResults(surveyresults);
	}

	@Override
	public void CalculatePower(Long id) {
		SurveyData survey = surveyDataRepository.findOne(id);
		double s10RelativePower, s60RelativePower;
		int s10PowerOutput, s60PowerOutput, s10RelativePowerResult, s60RelativePowerResult;
		if (survey.getClient().getGender() == 'F') {
			s10PowerOutput = lookupTable.getScore("AbsolutePowerWomen10", survey.getS10PowerOutput());
			s60PowerOutput = lookupTable.getScore("AbsolutePowerWomen60", survey.getS60PowerOutput());
			s10RelativePower = survey.getS10PowerOutput() / (survey.getWeight()/2.2);
			s60RelativePower = survey.getS60PowerOutput() / (survey.getWeight()/2.2);
			s10RelativePowerResult = lookupRelative.getScore("s10RelativePowerWomen", s10RelativePower);
			s60RelativePowerResult = lookupRelative.getScore("s60RelativePowerWomen", s60RelativePower);
		} else {
			s10PowerOutput = lookupTable.getScore("AbsolutePowerMen10", survey.getS10PowerOutput());
			s60PowerOutput = lookupTable.getScore("AbsolutePowerMen60", survey.getS60PowerOutput());
			s10RelativePower = survey.getS10PowerOutput() / (survey.getWeight()/2.2);
			s60RelativePower = survey.getS60PowerOutput() / (survey.getWeight()/2.2);
			s10RelativePowerResult = lookupRelative.getScore("s10RelativePowerMen", s10RelativePower);
			s60RelativePowerResult = lookupRelative.getScore("s60RelativePowerMen", s60RelativePower);
		}
		int absPower = (int) Math.round((s10PowerOutput + s60PowerOutput) / 2.0);
		int relPower = (int) Math.round((s10RelativePowerResult + s60RelativePowerResult) / 2.0);
		double powerScore = (absPower + relPower) / (2.0);
		power = (int) Math.round(powerScore);
		surveyresults.setS10RelativePowerResults(s10RelativePowerResult);
		surveyresults.setS60PowerOutputResults(s60PowerOutput);
		
		surveyresults.setS10PowerOutputResults(s10PowerOutput);
		surveyresults.setS10RelativePower(s10RelativePower);
		surveyresults.setS60RelativePowerCalc(s60RelativePower);
		surveyresults.setAbsolutePower(absPower);
		surveyresults.setRelativePower(relPower);
		surveyresults.setS60RelativePower(s60RelativePowerResult);
		surveyresults.setPower(power);
		surveyServiceResults.saveSurveyResults(surveyresults);
	}

	@Override
	public void CalculateEndurance(Long id) {

		double vo2Max, min4RelativePower;
		int scoremin4Relative, vo2Score, vo2Result, min4PowerOutput;

		SurveyData survey = surveyDataRepository.findOne(id);
		if (survey.getClient().getGender() == 'F') {
			vo2Max = ((survey.getCalories() / survey.getKmRow() / 5) * 1000) / (survey.getWeight() / (2.2));
			vo2Result = (int) Math.round(vo2Max);
			vo2Score = lookupTable.getScore("VO2", vo2Result);
			min4PowerOutput = lookupTable.getScore("PowerOutput4min", survey.getMin4PowerOutput());
			min4RelativePower = (survey.getMin4PowerOutput()) / survey.getWeight();
			scoremin4Relative = lookupRelative.getScore("PowerRatio", min4RelativePower);

		}

		else {
			vo2Max = ((survey.getCalories() / (survey.getKmRow()*60) / 5) * 1000) / survey.getWeight() / (2.2);
			vo2Result = (int) Math.round(vo2Max);
			vo2Score = lookupTable.getScore("VO2", vo2Result);
			min4PowerOutput = lookupTable.getScore("AbsolutePower4Min", survey.getMin4PowerOutput());
			min4RelativePower = (survey.getMin4PowerOutput()) / survey.getWeight();
			scoremin4Relative = lookupRelative.getScore("PowerRatio", min4RelativePower);
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
		surveyresults.setEndurance(endurance);
		surveyresults.setEtrakScore(etrak);
		surveyServiceResults.saveSurveyResults(surveyresults);

	}

}
