package com.inspire11.etrak.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SurveyData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SURVEY_ID")
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "USER_ID",referencedColumnName="user_id")
	private User UserId;

	@ManyToOne
	@JoinColumn(name = "ACTIVITYLEVEL_ID",referencedColumnName="activitylevel_id")
	private ActivityLevel activityLevelId;

	private Double weight;

	private Double height;

	private Double bodyFat;

	private Integer SBP;

	private Integer DBP;

	private Integer RHR;

	private Integer deepSquatHipFlexion;

	private Integer shoulderFlexionR;

	private Integer shoulderFlexionL;

	private Integer shoulderExtensionR;

	private Integer shoulderExtensionL;

	private Integer trunkRotationR;

	private Integer trunkRotationL;

	private Double totalStability;

	private Double pistolR;

	private Double pistolL;

	private Double proneRH_LF;

	private Double proneRF_RH;

	private Double vsit;

	private Double total_1RMForce;

	private Double lowerBodyForce;

	private Double pushForce;

	private Double pullForce;

	private Double lowerSW_ratio;

	private Double pushSW_ratio;

	private Double pullSW_ratio;

	private Double totalStabilityForce;

	private Double lowerStabilityForce;

	private Double pushStabilityForce;

	private Double pullStabilityForce;

	private Double power1S;

	private Double power10S;

	private Double power60S;

	private Double power4MIN;

	private Double power1S_BWratio;

	private Double power10S_BWratio;

	private Double power60s_BWratio;

	private Double power4MIN_BWratio;

	private Double totalEfficiency;

	private Double dropOff10sTo60s;

	private Double dropoff60sTo4min;

	private Double vo2Max;

	private Double calsMin;

	private Double avgForce;

	private String clientGoals;

	private Double mobilityScore;

	private Double stabilityScore;

	private Double movementScore;

	private Double absoluteStrength;

	private Double relativeStrength;

	private Double strengthScore;

	private Double absolutePower;

	private Double relativePower;

	private Double powerScore;

	private Double enduranceScore;

	private Double coreScore;

	private Date timeStamp;

	private Double restingMetabolicRate;

	private Double totalEnergyExpenditure;

	private Integer dbPistolSquat_rightLeg;

	private Integer dbPistolSquat_leftLeg;

	private Double broatJump;

	private Double benchPress5RM;

	private Double pullUpsMax;

	private Double rowTime1000m;

	private Double rowCalories1000m;

	private Double pushUpsMax;

	private Double externalShoulderRotationR;

	private Double externalShoulderRotationL;

	private Double lowerBodyAbsoluteStrengthScore;

	private Double lowerBodyRelativeStrengthScore;

	private Double pushAbsoluteStrengthScore;

	private Double pushRelativeStrengthScore;

	private Double pullAbsoluteStrengthScore;

	private Double pullRelativeStrenghScore;

	private Double peakPowerRelativeScore;

	private Double powerAbsoluteScore10s;

	private Double powerRelativeScore10s;

	private Double powerAbsoluteScore60s;

	private Double powerRelativeScore60s;

	private Double vo2MaxAbsoluteScore;

	private Double powerAbsoluteScore4min;

	private Double powerRelativeScore4min;

	private Integer mealsPerDay;

	private Double proteins;

	private Double carbohydrates;

	private Double fats;

	private Double extraCalories;

	private Double wallSquat;

	private Double lateralHipBridgeRight;

	private Double lateralHipBridgeLeft;

	private Double pronePlank;

	private Double seatedTrunkStability;

	private Double deepWallSquat;

	private Double fingerTouchTestRin_Lex;

	private Double fingerTouchTest;

	private Double legRaiseRight;

	private Double legRaiseLeft;

	private Double fingerTouchTestSecond;

	private Double fmsDeepSquat;

	private Double fmsHurdleStepR;

	private Double fmsHurdleStepL;

	private Double fmsaslrR;

	private Double fmsActiveStraitLegRaise;

	private Double fmsshoulderTestLeftArm;

	private Double fmsshoulderTestRightArm;

	private Double fmsTrunkPushups;

	private Double fmsrotaryStabilityRightSide;

	private Double fmsrotaryStabilityLeftSide;

	private Double fmsrotaryMobilityLeftSide;

	private Double fmsrotaryMobilityRightSide;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public User getUserId() {
		return UserId;
	}

	public void setUserId(User userId) {
		UserId = userId;
	}

	public ActivityLevel getActivityLevelId() {
		return activityLevelId;
	}

	public void setActivityLevelId(ActivityLevel activityLevelId) {
		this.activityLevelId = activityLevelId;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getBodyFat() {
		return bodyFat;
	}

	public void setBodyFat(Double bodyFat) {
		this.bodyFat = bodyFat;
	}

	public Integer getSBP() {
		return SBP;
	}

	public void setSBP(Integer sBP) {
		SBP = sBP;
	}

	public Integer getDBP() {
		return DBP;
	}

	public void setDBP(Integer dBP) {
		DBP = dBP;
	}

	public Integer getRHR() {
		return RHR;
	}

	public void setRHR(Integer rHR) {
		RHR = rHR;
	}

	public Integer getDeepSquatHipFlexion() {
		return deepSquatHipFlexion;
	}

	public void setDeepSquatHipFlexion(Integer deepSquatHipFlexion) {
		this.deepSquatHipFlexion = deepSquatHipFlexion;
	}

	public Integer getShoulderFlexionR() {
		return shoulderFlexionR;
	}

	public void setShoulderFlexionR(Integer shoulderFlexionR) {
		this.shoulderFlexionR = shoulderFlexionR;
	}

	public Integer getShoulderFlexionL() {
		return shoulderFlexionL;
	}

	public void setShoulderFlexionL(Integer shoulderFlexionL) {
		this.shoulderFlexionL = shoulderFlexionL;
	}

	public Integer getShoulderExtensionR() {
		return shoulderExtensionR;
	}

	public void setShoulderExtensionR(Integer shoulderExtensionR) {
		this.shoulderExtensionR = shoulderExtensionR;
	}

	public Integer getShoulderExtensionL() {
		return shoulderExtensionL;
	}

	public void setShoulderExtensionL(Integer shoulderExtensionL) {
		this.shoulderExtensionL = shoulderExtensionL;
	}

	public Integer getTrunkRotationR() {
		return trunkRotationR;
	}

	public void setTrunkRotationR(Integer trunkRotationR) {
		this.trunkRotationR = trunkRotationR;
	}

	public Integer getTrunkRotationL() {
		return trunkRotationL;
	}

	public void setTrunkRotationL(Integer trunkRotationL) {
		this.trunkRotationL = trunkRotationL;
	}

	public Double getTotalStability() {
		return totalStability;
	}

	public void setTotalStability(Double totalStability) {
		this.totalStability = totalStability;
	}

	public Double getPistolR() {
		return pistolR;
	}

	public void setPistolR(Double pistolR) {
		this.pistolR = pistolR;
	}

	public Double getPistolL() {
		return pistolL;
	}

	public void setPistolL(Double pistolL) {
		this.pistolL = pistolL;
	}

	public Double getProneRH_LF() {
		return proneRH_LF;
	}

	public void setProneRH_LF(Double proneRH_LF) {
		this.proneRH_LF = proneRH_LF;
	}

	public Double getProneRF_RH() {
		return proneRF_RH;
	}

	public void setProneRF_RH(Double proneRF_RH) {
		this.proneRF_RH = proneRF_RH;
	}

	public Double getVsit() {
		return vsit;
	}

	public void setVsit(Double vsit) {
		this.vsit = vsit;
	}

	public Double getTotal_1RMForce() {
		return total_1RMForce;
	}

	public void setTotal_1RMForce(Double total_1rmForce) {
		total_1RMForce = total_1rmForce;
	}

	public Double getLowerBodyForce() {
		return lowerBodyForce;
	}

	public void setLowerBodyForce(Double lowerBodyForce) {
		this.lowerBodyForce = lowerBodyForce;
	}

	public Double getPushForce() {
		return pushForce;
	}

	public void setPushForce(Double pushForce) {
		this.pushForce = pushForce;
	}

	public Double getPullForce() {
		return pullForce;
	}

	public void setPullForce(Double pullForce) {
		this.pullForce = pullForce;
	}

	public Double getLowerSW_ratio() {
		return lowerSW_ratio;
	}

	public void setLowerSW_ratio(Double lowerSW_ratio) {
		this.lowerSW_ratio = lowerSW_ratio;
	}

	public Double getPushSW_ratio() {
		return pushSW_ratio;
	}

	public void setPushSW_ratio(Double pushSW_ratio) {
		this.pushSW_ratio = pushSW_ratio;
	}

	public Double getPullSW_ratio() {
		return pullSW_ratio;
	}

	public void setPullSW_ratio(Double pullSW_ratio) {
		this.pullSW_ratio = pullSW_ratio;
	}

	public Double getTotalStabilityForce() {
		return totalStabilityForce;
	}

	public void setTotalStabilityForce(Double totalStabilityForce) {
		this.totalStabilityForce = totalStabilityForce;
	}

	public Double getLowerStabilityForce() {
		return lowerStabilityForce;
	}

	public void setLowerStabilityForce(Double lowerStabilityForce) {
		this.lowerStabilityForce = lowerStabilityForce;
	}

	public Double getPushStabilityForce() {
		return pushStabilityForce;
	}

	public void setPushStabilityForce(Double pushStabilityForce) {
		this.pushStabilityForce = pushStabilityForce;
	}

	public Double getPullStabilityForce() {
		return pullStabilityForce;
	}

	public void setPullStabilityForce(Double pullStabilityForce) {
		this.pullStabilityForce = pullStabilityForce;
	}

	public Double getPower1S() {
		return power1S;
	}

	public void setPower1S(Double power1s) {
		power1S = power1s;
	}

	public Double getPower10S() {
		return power10S;
	}

	public void setPower10S(Double power10s) {
		power10S = power10s;
	}

	public Double getPower60S() {
		return power60S;
	}

	public void setPower60S(Double power60s) {
		power60S = power60s;
	}

	public Double getPower4MIN() {
		return power4MIN;
	}

	public void setPower4MIN(Double power4min) {
		power4MIN = power4min;
	}

	public Double getPower1S_BWratio() {
		return power1S_BWratio;
	}

	public void setPower1S_BWratio(Double power1s_BWratio) {
		power1S_BWratio = power1s_BWratio;
	}

	public Double getPower10S_BWratio() {
		return power10S_BWratio;
	}

	public void setPower10S_BWratio(Double power10s_BWratio) {
		power10S_BWratio = power10s_BWratio;
	}

	public Double getPower60s_BWratio() {
		return power60s_BWratio;
	}

	public void setPower60s_BWratio(Double power60s_BWratio) {
		this.power60s_BWratio = power60s_BWratio;
	}

	public Double getPower4MIN_BWratio() {
		return power4MIN_BWratio;
	}

	public void setPower4MIN_BWratio(Double power4min_BWratio) {
		power4MIN_BWratio = power4min_BWratio;
	}

	public Double getTotalEfficiency() {
		return totalEfficiency;
	}

	public void setTotalEfficiency(Double totalEfficiency) {
		this.totalEfficiency = totalEfficiency;
	}

	public Double getDropOff10sTo60s() {
		return dropOff10sTo60s;
	}

	public void setDropOff10sTo60s(Double dropOff10sTo60s) {
		this.dropOff10sTo60s = dropOff10sTo60s;
	}

	public Double getDropoff60sTo4min() {
		return dropoff60sTo4min;
	}

	public void setDropoff60sTo4min(Double dropoff60sTo4min) {
		this.dropoff60sTo4min = dropoff60sTo4min;
	}

	public Double getVo2Max() {
		return vo2Max;
	}

	public void setVo2Max(Double vo2Max) {
		this.vo2Max = vo2Max;
	}

	public Double getCalsMin() {
		return calsMin;
	}

	public void setCalsMin(Double calsMin) {
		this.calsMin = calsMin;
	}

	public Double getAvgForce() {
		return avgForce;
	}

	public void setAvgForce(Double avgForce) {
		this.avgForce = avgForce;
	}

	public String getClientGoals() {
		return clientGoals;
	}

	public void setClientGoals(String clientGoals) {
		this.clientGoals = clientGoals;
	}

	public Double getMobilityScore() {
		return mobilityScore;
	}

	public void setMobilityScore(Double mobilityScore) {
		this.mobilityScore = mobilityScore;
	}

	public Double getStabilityScore() {
		return stabilityScore;
	}

	public void setStabilityScore(Double stabilityScore) {
		this.stabilityScore = stabilityScore;
	}

	public Double getMovementScore() {
		return movementScore;
	}

	public void setMovementScore(Double movementScore) {
		this.movementScore = movementScore;
	}

	public Double getAbsoluteStrength() {
		return absoluteStrength;
	}

	public void setAbsoluteStrength(Double absoluteStrength) {
		this.absoluteStrength = absoluteStrength;
	}

	public Double getRelativeStrength() {
		return relativeStrength;
	}

	public void setRelativeStrength(Double relativeStrength) {
		this.relativeStrength = relativeStrength;
	}

	public Double getStrengthScore() {
		return strengthScore;
	}

	public void setStrengthScore(Double strengthScore) {
		this.strengthScore = strengthScore;
	}

	public Double getAbsolutePower() {
		return absolutePower;
	}

	public void setAbsolutePower(Double absolutePower) {
		this.absolutePower = absolutePower;
	}

	public Double getRelativePower() {
		return relativePower;
	}

	public void setRelativePower(Double relativePower) {
		this.relativePower = relativePower;
	}

	public Double getPowerScore() {
		return powerScore;
	}

	public void setPowerScore(Double powerScore) {
		this.powerScore = powerScore;
	}

	public Double getEnduranceScore() {
		return enduranceScore;
	}

	public void setEnduranceScore(Double enduranceScore) {
		this.enduranceScore = enduranceScore;
	}

	public Double getCoreScore() {
		return coreScore;
	}

	public void setCoreScore(Double coreScore) {
		this.coreScore = coreScore;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getRestingMetabolicRate() {
		return restingMetabolicRate;
	}

	public void setRestingMetabolicRate(Double restingMetabolicRate) {
		this.restingMetabolicRate = restingMetabolicRate;
	}

	public Double getTotalEnergyExpenditure() {
		return totalEnergyExpenditure;
	}

	public void setTotalEnergyExpenditure(Double totalEnergyExpenditure) {
		this.totalEnergyExpenditure = totalEnergyExpenditure;
	}

	public Integer getDbPistolSquat_rightLeg() {
		return dbPistolSquat_rightLeg;
	}

	public void setDbPistolSquat_rightLeg(Integer dbPistolSquat_rightLeg) {
		this.dbPistolSquat_rightLeg = dbPistolSquat_rightLeg;
	}

	public Integer getDbPistolSquat_leftLeg() {
		return dbPistolSquat_leftLeg;
	}

	public void setDbPistolSquat_leftLeg(Integer dbPistolSquat_leftLeg) {
		this.dbPistolSquat_leftLeg = dbPistolSquat_leftLeg;
	}

	public Double getBroatJump() {
		return broatJump;
	}

	public void setBroatJump(Double broatJump) {
		this.broatJump = broatJump;
	}

	public Double getBenchPress5RM() {
		return benchPress5RM;
	}

	public void setBenchPress5RM(Double benchPress5RM) {
		this.benchPress5RM = benchPress5RM;
	}

	public Double getPullUpsMax() {
		return pullUpsMax;
	}

	public void setPullUpsMax(Double pullUpsMax) {
		this.pullUpsMax = pullUpsMax;
	}

	public Double getRowTime1000m() {
		return rowTime1000m;
	}

	public void setRowTime1000m(Double rowTime1000m) {
		this.rowTime1000m = rowTime1000m;
	}

	public Double getRowCalories1000m() {
		return rowCalories1000m;
	}

	public void setRowCalories1000m(Double rowCalories1000m) {
		this.rowCalories1000m = rowCalories1000m;
	}

	public Double getPushUpsMax() {
		return pushUpsMax;
	}

	public void setPushUpsMax(Double pushUpsMax) {
		this.pushUpsMax = pushUpsMax;
	}

	public Double getExternalShoulderRotationR() {
		return externalShoulderRotationR;
	}

	public void setExternalShoulderRotationR(Double externalShoulderRotationR) {
		this.externalShoulderRotationR = externalShoulderRotationR;
	}

	public Double getExternalShoulderRotationL() {
		return externalShoulderRotationL;
	}

	public void setExternalShoulderRotationL(Double externalShoulderRotationL) {
		this.externalShoulderRotationL = externalShoulderRotationL;
	}

	public Double getLowerBodyAbsoluteStrengthScore() {
		return lowerBodyAbsoluteStrengthScore;
	}

	public void setLowerBodyAbsoluteStrengthScore(Double lowerBodyAbsoluteStrengthScore) {
		this.lowerBodyAbsoluteStrengthScore = lowerBodyAbsoluteStrengthScore;
	}

	public Double getLowerBodyRelativeStrengthScore() {
		return lowerBodyRelativeStrengthScore;
	}

	public void setLowerBodyRelativeStrengthScore(Double lowerBodyRelativeStrengthScore) {
		this.lowerBodyRelativeStrengthScore = lowerBodyRelativeStrengthScore;
	}

	public Double getPushAbsoluteStrengthScore() {
		return pushAbsoluteStrengthScore;
	}

	public void setPushAbsoluteStrengthScore(Double pushAbsoluteStrengthScore) {
		this.pushAbsoluteStrengthScore = pushAbsoluteStrengthScore;
	}

	public Double getPushRelativeStrengthScore() {
		return pushRelativeStrengthScore;
	}

	public void setPushRelativeStrengthScore(Double pushRelativeStrengthScore) {
		this.pushRelativeStrengthScore = pushRelativeStrengthScore;
	}

	public Double getPullAbsoluteStrengthScore() {
		return pullAbsoluteStrengthScore;
	}

	public void setPullAbsoluteStrengthScore(Double pullAbsoluteStrengthScore) {
		this.pullAbsoluteStrengthScore = pullAbsoluteStrengthScore;
	}

	public Double getPullRelativeStrenghScore() {
		return pullRelativeStrenghScore;
	}

	public void setPullRelativeStrenghScore(Double pullRelativeStrenghScore) {
		this.pullRelativeStrenghScore = pullRelativeStrenghScore;
	}

	public Double getPeakPowerRelativeScore() {
		return peakPowerRelativeScore;
	}

	public void setPeakPowerRelativeScore(Double peakPowerRelativeScore) {
		this.peakPowerRelativeScore = peakPowerRelativeScore;
	}

	public Double getPowerAbsoluteScore10s() {
		return powerAbsoluteScore10s;
	}

	public void setPowerAbsoluteScore10s(Double powerAbsoluteScore10s) {
		this.powerAbsoluteScore10s = powerAbsoluteScore10s;
	}

	public Double getPowerRelativeScore10s() {
		return powerRelativeScore10s;
	}

	public void setPowerRelativeScore10s(Double powerRelativeScore10s) {
		this.powerRelativeScore10s = powerRelativeScore10s;
	}

	public Double getPowerAbsoluteScore60s() {
		return powerAbsoluteScore60s;
	}

	public void setPowerAbsoluteScore60s(Double powerAbsoluteScore60s) {
		this.powerAbsoluteScore60s = powerAbsoluteScore60s;
	}

	public Double getPowerRelativeScore60s() {
		return powerRelativeScore60s;
	}

	public void setPowerRelativeScore60s(Double powerRelativeScore60s) {
		this.powerRelativeScore60s = powerRelativeScore60s;
	}

	public Double getVo2MaxAbsoluteScore() {
		return vo2MaxAbsoluteScore;
	}

	public void setVo2MaxAbsoluteScore(Double vo2MaxAbsoluteScore) {
		this.vo2MaxAbsoluteScore = vo2MaxAbsoluteScore;
	}

	public Double getPowerAbsoluteScore4min() {
		return powerAbsoluteScore4min;
	}

	public void setPowerAbsoluteScore4min(Double powerAbsoluteScore4min) {
		this.powerAbsoluteScore4min = powerAbsoluteScore4min;
	}

	public Double getPowerRelativeScore4min() {
		return powerRelativeScore4min;
	}

	public void setPowerRelativeScore4min(Double powerRelativeScore4min) {
		this.powerRelativeScore4min = powerRelativeScore4min;
	}

	public Integer getMealsPerDay() {
		return mealsPerDay;
	}

	public void setMealsPerDay(Integer mealsPerDay) {
		this.mealsPerDay = mealsPerDay;
	}

	public Double getProteins() {
		return proteins;
	}

	public void setProteins(Double proteins) {
		this.proteins = proteins;
	}

	public Double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(Double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public Double getFats() {
		return fats;
	}

	public void setFats(Double fats) {
		this.fats = fats;
	}

	public Double getExtraCalories() {
		return extraCalories;
	}

	public void setExtraCalories(Double extraCalories) {
		this.extraCalories = extraCalories;
	}

	public Double getWallSquat() {
		return wallSquat;
	}

	public void setWallSquat(Double wallSquat) {
		this.wallSquat = wallSquat;
	}

	public Double getLateralHipBridgeRight() {
		return lateralHipBridgeRight;
	}

	public void setLateralHipBridgeRight(Double lateralHipBridgeRight) {
		this.lateralHipBridgeRight = lateralHipBridgeRight;
	}

	public Double getLateralHipBridgeLeft() {
		return lateralHipBridgeLeft;
	}

	public void setLateralHipBridgeLeft(Double lateralHipBridgeLeft) {
		this.lateralHipBridgeLeft = lateralHipBridgeLeft;
	}

	public Double getPronePlank() {
		return pronePlank;
	}

	public void setPronePlank(Double pronePlank) {
		this.pronePlank = pronePlank;
	}

	public Double getSeatedTrunkStability() {
		return seatedTrunkStability;
	}

	public void setSeatedTrunkStability(Double seatedTrunkStability) {
		this.seatedTrunkStability = seatedTrunkStability;
	}

	public Double getDeepWallSquat() {
		return deepWallSquat;
	}

	public void setDeepWallSquat(Double deepWallSquat) {
		this.deepWallSquat = deepWallSquat;
	}

	public Double getFingerTouchTestRin_Lex() {
		return fingerTouchTestRin_Lex;
	}

	public void setFingerTouchTestRin_Lex(Double fingerTouchTestRin_Lex) {
		this.fingerTouchTestRin_Lex = fingerTouchTestRin_Lex;
	}

	public Double getFingerTouchTest() {
		return fingerTouchTest;
	}

	public void setFingerTouchTest(Double fingerTouchTest) {
		this.fingerTouchTest = fingerTouchTest;
	}

	public Double getLegRaiseRight() {
		return legRaiseRight;
	}

	public void setLegRaiseRight(Double legRaiseRight) {
		this.legRaiseRight = legRaiseRight;
	}

	public Double getLegRaiseLeft() {
		return legRaiseLeft;
	}

	public void setLegRaiseLeft(Double legRaiseLeft) {
		this.legRaiseLeft = legRaiseLeft;
	}

	public Double getFingerTouchTestSecond() {
		return fingerTouchTestSecond;
	}

	public void setFingerTouchTestSecond(Double fingerTouchTestSecond) {
		this.fingerTouchTestSecond = fingerTouchTestSecond;
	}

	public Double getFmsDeepSquat() {
		return fmsDeepSquat;
	}

	public void setFmsDeepSquat(Double fmsDeepSquat) {
		this.fmsDeepSquat = fmsDeepSquat;
	}

	public Double getFmsHurdleStepR() {
		return fmsHurdleStepR;
	}

	public void setFmsHurdleStepR(Double fmsHurdleStepR) {
		this.fmsHurdleStepR = fmsHurdleStepR;
	}

	public Double getFmsHurdleStepL() {
		return fmsHurdleStepL;
	}

	public void setFmsHurdleStepL(Double fmsHurdleStepL) {
		this.fmsHurdleStepL = fmsHurdleStepL;
	}

	public Double getFmsaslrR() {
		return fmsaslrR;
	}

	public void setFmsaslrR(Double fmsaslrR) {
		this.fmsaslrR = fmsaslrR;
	}

	public Double getFmsActiveStraitLegRaise() {
		return fmsActiveStraitLegRaise;
	}

	public void setFmsActiveStraitLegRaise(Double fmsActiveStraitLegRaise) {
		this.fmsActiveStraitLegRaise = fmsActiveStraitLegRaise;
	}

	public Double getFmsshoulderTestLeftArm() {
		return fmsshoulderTestLeftArm;
	}

	public void setFmsshoulderTestLeftArm(Double fmsshoulderTestLeftArm) {
		this.fmsshoulderTestLeftArm = fmsshoulderTestLeftArm;
	}

	public Double getFmsshoulderTestRightArm() {
		return fmsshoulderTestRightArm;
	}

	public void setFmsshoulderTestRightArm(Double fmsshoulderTestRightArm) {
		this.fmsshoulderTestRightArm = fmsshoulderTestRightArm;
	}

	public Double getFmsTrunkPushups() {
		return fmsTrunkPushups;
	}

	public void setFmsTrunkPushups(Double fmsTrunkPushups) {
		this.fmsTrunkPushups = fmsTrunkPushups;
	}

	public Double getFmsrotaryStabilityRightSide() {
		return fmsrotaryStabilityRightSide;
	}

	public void setFmsrotaryStabilityRightSide(Double fmsrotaryStabilityRightSide) {
		this.fmsrotaryStabilityRightSide = fmsrotaryStabilityRightSide;
	}

	public Double getFmsrotaryStabilityLeftSide() {
		return fmsrotaryStabilityLeftSide;
	}

	public void setFmsrotaryStabilityLeftSide(Double fmsrotaryStabilityLeftSide) {
		this.fmsrotaryStabilityLeftSide = fmsrotaryStabilityLeftSide;
	}

	public Double getFmsrotaryMobilityLeftSide() {
		return fmsrotaryMobilityLeftSide;
	}

	public void setFmsrotaryMobilityLeftSide(Double fmsrotaryMobilityLeftSide) {
		this.fmsrotaryMobilityLeftSide = fmsrotaryMobilityLeftSide;
	}

	public Double getFmsrotaryMobilityRightSide() {
		return fmsrotaryMobilityRightSide;
	}

	public void setFmsrotaryMobilityRightSide(Double fmsrotaryMobilityRightSide) {
		this.fmsrotaryMobilityRightSide = fmsrotaryMobilityRightSide;
	}

	

}
