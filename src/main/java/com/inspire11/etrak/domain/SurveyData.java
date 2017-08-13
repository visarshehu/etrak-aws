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
	@JoinColumn(name = "USER_ID")
	private Users UserId;

	@ManyToOne
	@JoinColumn(name = "ACTIVITYLEVEL_ID")
	private ActivityLevel ActivityLevelId;

	private Double Weight;

	private Double Height;

	private Double BodyFat;

	private Integer SBP;

	private Integer DBP;

	private Integer RHR;

	private Integer DeepSquatHipFlexion;

	private Integer ShoulderFlexionR;

	private Integer ShoulderFlexionL;

	private Integer ShoulderExtensionR;

	private Integer ShoulderExtensionL;

	private Integer TrunkRotationR;

	private Integer TrunkRotationL;

	private Double TotalStability;

	private Double PistolR;

	private Double PistolL;

	private Double ProneRH_LF;

	private Double ProneRF_RH;

	private Double Vsit;

	private Double Total_1RMForce;

	private Double LowerBodyForce;

	private Double PushForce;

	private Double PullForce;

	private Double LowerSW_ratio;

	private Double PushSW_ratio;

	private Double PullSW_ratio;

	private Double TotalStabilityForce;

	private Double LowerStabilityForce;

	private Double PushStabilityForce;

	private Double PullStabilityForce;

	private Double Power1S;

	private Double Power10S;

	private Double Power60S;

	private Double Power4MIN;

	private Double Power1S_BWratio;

	private Double Power10S_BWratio;

	private Double Power60s_BWratio;

	private Double Power4MIN_BWratio;

	private Double TotalEfficiency;

	private Double DropOff10sTo60s;

	private Double Dropoff60sTo4min;

	private Double Vo2Max;

	private Double CalsMin;

	private Double AvgForce;

	private String ClientGoals;

	private Double MobilityScore;

	private Double StabilityScore;

	private Double MovementScore;

	private Double AbsoluteStrength;

	private Double RelativeStrength;

	private Double StrengthScore;

	private Double AbsolutePower;

	private Double RelativePower;

	private Double PowerScore;

	private Double EnduranceScore;

	private Double CoreScore;

	private Date TimeStamp;

	private Double RestingMetabolicRate;

	private Double TotalEnergyExpenditure;

	private Integer DbPistolSquat_rightLeg;

	private Integer DbPistolSquat_leftLeg;

	private Double BroatJump;

	private Double BenchPress5RM;

	private Double PullUpsMax;

	private Double RowTime1000m;

	private Double RowCalories1000m;

	private Double PushUpsMax;

	private Double ExternalShoulderRotationR;

	private Double ExternalShoulderRotationL;

	private Double LowerBodyAbsoluteStrengthScore;

	private Double LowerBodyRelativeStrengthScore;

	private Double PushAbsoluteStrengthScore;

	private Double PushRelativeStrengthScore;

	private Double PullAbsoluteStrengthScore;

	private Double PullRelativeStrenghScore;

	private Double PeakPowerRelativeScore;

	private Double PowerAbsoluteScore10s;

	private Double PowerRelativeScore10s;

	private Double PowerAbsoluteScore60s;

	private Double PowerRelativeScore60s;

	private Double Vo2MaxAbsoluteScore;

	private Double PowerAbsoluteScore4min;

	private Double PowerRelativeScore4min;

	private Integer MealsPerDay;

	private Double Proteins;

	private Double Carbohydrates;

	private Double Fats;

	private Double ExtraCalories;

	private Double WallSquat;

	private Double LateralHipBridgeRight;

	private Double LateralHipBridgeLeft;

	private Double PronePlank;

	private Double SeatedTrunkStability;

	private Double DeepWallSquat;

	private Double FingerTouchTestRin_Lex;

	private Double FingerTouchTest;

	private Double LegRaiseRight;

	private Double LegRaiseLeft;

	private Double FingerTouchTestSecond;

	private Double FMSDeepSquat;

	private Double FMSHurdleStepR;

	private Double FMSHurdleStepL;

	private Double FMSaslrR;

	private Double FMSActiveStraitLegRaise;

	private Double FMSshoulderTestLeftArm;

	private Double FMSshoulderTestRightArm;

	private Double FMSTrunkPushups;

	private Double FMSrotaryStabilityRightSide;

	private Double FMSrotaryStabilityLeftSide;

	private Double FMSrotaryMobilityLeftSide;

	private Double FMSrotaryMobilityRightSide;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Users getUserId() {
		return UserId;
	}

	public void setUserId(Users userId) {
		UserId = userId;
	}

	public ActivityLevel getActivityLevelId() {
		return ActivityLevelId;
	}

	public void setActivityLevelId(ActivityLevel ActivityLevelId) {
		this.ActivityLevelId = ActivityLevelId;
	}

	public Double getWeight() {
		return Weight;
	}

	public void setWeight(Double weight) {
		Weight = weight;
	}

	public Double getHeight() {
		return Height;
	}

	public void setHeight(Double height) {
		Height = height;
	}

	public Double getBodyFat() {
		return BodyFat;
	}

	public void setBodyFat(Double bodyFat) {
		BodyFat = bodyFat;
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
		return DeepSquatHipFlexion;
	}

	public void setDeepSquatHipFlexion(Integer deepSquatHipFlexion) {
		DeepSquatHipFlexion = deepSquatHipFlexion;
	}

	public Integer getShoulderFlexionR() {
		return ShoulderFlexionR;
	}

	public void setShoulderFlexionR(Integer shoulderFlexionR) {
		ShoulderFlexionR = shoulderFlexionR;
	}

	public Integer getShoulderFlexionL() {
		return ShoulderFlexionL;
	}

	public void setShoulderFlexionL(Integer shoulderFlexionL) {
		ShoulderFlexionL = shoulderFlexionL;
	}

	public Integer getShoulderExtensionR() {
		return ShoulderExtensionR;
	}

	public void setShoulderExtensionR(Integer shoulderExtensionR) {
		ShoulderExtensionR = shoulderExtensionR;
	}

	public Integer getShoulderExtensionL() {
		return ShoulderExtensionL;
	}

	public void setShoulderExtensionL(Integer shoulderExtensionL) {
		ShoulderExtensionL = shoulderExtensionL;
	}

	public Integer getTrunkRotationR() {
		return TrunkRotationR;
	}

	public void setTrunkRotationR(Integer trunkRotationR) {
		TrunkRotationR = trunkRotationR;
	}

	public Integer getTrunkRotationL() {
		return TrunkRotationL;
	}

	public void setTrunkRotationL(Integer trunkRotationL) {
		TrunkRotationL = trunkRotationL;
	}

	public Double getTotalStability() {
		return TotalStability;
	}

	public void setTotalStability(Double totalStability) {
		TotalStability = totalStability;
	}

	public Double getPistolR() {
		return PistolR;
	}

	public void setPistolR(Double pistolR) {
		PistolR = pistolR;
	}

	public Double getPistolL() {
		return PistolL;
	}

	public void setPistolL(Double pistolL) {
		PistolL = pistolL;
	}

	public Double getProneRH_LF() {
		return ProneRH_LF;
	}

	public void setProneRH_LF(Double proneRH_LF) {
		ProneRH_LF = proneRH_LF;
	}

	public Double getProneRF_RH() {
		return ProneRF_RH;
	}

	public void setProneRF_RH(Double proneRF_RH) {
		ProneRF_RH = proneRF_RH;
	}

	public Double getVsit() {
		return Vsit;
	}

	public void setVsit(Double vsit) {
		Vsit = vsit;
	}

	public Double getTotal_1RMForce() {
		return Total_1RMForce;
	}

	public void setTotal_1RMForce(Double total_1rmForce) {
		Total_1RMForce = total_1rmForce;
	}

	public Double getLowerBodyForce() {
		return LowerBodyForce;
	}

	public void setLowerBodyForce(Double lowerBodyForce) {
		LowerBodyForce = lowerBodyForce;
	}

	public Double getPushForce() {
		return PushForce;
	}

	public void setPushForce(Double pushForce) {
		PushForce = pushForce;
	}

	public Double getPullForce() {
		return PullForce;
	}

	public void setPullForce(Double pullForce) {
		PullForce = pullForce;
	}

	public Double getLowerSW_ratio() {
		return LowerSW_ratio;
	}

	public void setLowerSW_ratio(Double lowerSW_ratio) {
		LowerSW_ratio = lowerSW_ratio;
	}

	public Double getPushSW_ratio() {
		return PushSW_ratio;
	}

	public void setPushSW_ratio(Double pushSW_ratio) {
		PushSW_ratio = pushSW_ratio;
	}

	public Double getPullSW_ratio() {
		return PullSW_ratio;
	}

	public void setPullSW_ratio(Double pullSW_ratio) {
		PullSW_ratio = pullSW_ratio;
	}

	public Double getTotalStabilityForce() {
		return TotalStabilityForce;
	}

	public void setTotalStabilityForce(Double totalStabilityForce) {
		TotalStabilityForce = totalStabilityForce;
	}

	public Double getLowerStabilityForce() {
		return LowerStabilityForce;
	}

	public void setLowerStabilityForce(Double lowerStabilityForce) {
		LowerStabilityForce = lowerStabilityForce;
	}

	public Double getPushStabilityForce() {
		return PushStabilityForce;
	}

	public void setPushStabilityForce(Double pushStabilityForce) {
		PushStabilityForce = pushStabilityForce;
	}

	public Double getPullStabilityForce() {
		return PullStabilityForce;
	}

	public void setPullStabilityForce(Double pullStabilityForce) {
		PullStabilityForce = pullStabilityForce;
	}

	public Double getPower1S() {
		return Power1S;
	}

	public void setPower1S(Double power1s) {
		Power1S = power1s;
	}

	public Double getPower10S() {
		return Power10S;
	}

	public void setPower10S(Double power10s) {
		Power10S = power10s;
	}

	public Double getPower60S() {
		return Power60S;
	}

	public void setPower60S(Double power60s) {
		Power60S = power60s;
	}

	public Double getPower4MIN() {
		return Power4MIN;
	}

	public void setPower4MIN(Double power4min) {
		Power4MIN = power4min;
	}

	public Double getPower1S_BWratio() {
		return Power1S_BWratio;
	}

	public void setPower1S_BWratio(Double power1s_BWratio) {
		Power1S_BWratio = power1s_BWratio;
	}

	public Double getPower10S_BWratio() {
		return Power10S_BWratio;
	}

	public void setPower10S_BWratio(Double power10s_BWratio) {
		Power10S_BWratio = power10s_BWratio;
	}

	public Double getPower60s_BWratio() {
		return Power60s_BWratio;
	}

	public void setPower60s_BWratio(Double power60s_BWratio) {
		Power60s_BWratio = power60s_BWratio;
	}

	public Double getPower4MIN_BWratio() {
		return Power4MIN_BWratio;
	}

	public void setPower4MIN_BWratio(Double power4min_BWratio) {
		Power4MIN_BWratio = power4min_BWratio;
	}

	public Double getTotalEfficiency() {
		return TotalEfficiency;
	}

	public void setTotalEfficiency(Double totalEfficiency) {
		TotalEfficiency = totalEfficiency;
	}

	public Double getDropOff10sTo60s() {
		return DropOff10sTo60s;
	}

	public void setDropOff10sTo60s(Double dropOff10sTo60s) {
		DropOff10sTo60s = dropOff10sTo60s;
	}

	public Double getDropoff60sTo4min() {
		return Dropoff60sTo4min;
	}

	public void setDropoff60sTo4min(Double dropoff60sTo4min) {
		Dropoff60sTo4min = dropoff60sTo4min;
	}

	public Double getVo2Max() {
		return Vo2Max;
	}

	public void setVo2Max(Double vo2Max) {
		Vo2Max = vo2Max;
	}

	public Double getCalsMin() {
		return CalsMin;
	}

	public void setCalsMin(Double calsMin) {
		CalsMin = calsMin;
	}

	public Double getAvgForce() {
		return AvgForce;
	}

	public void setAvgForce(Double avgForce) {
		AvgForce = avgForce;
	}

	public String getClientGoals() {
		return ClientGoals;
	}

	public void setClientGoals(String clientGoals) {
		ClientGoals = clientGoals;
	}

	public Double getMobilityScore() {
		return MobilityScore;
	}

	public void setMobilityScore(Double mobilityScore) {
		MobilityScore = mobilityScore;
	}

	public Double getStabilityScore() {
		return StabilityScore;
	}

	public void setStabilityScore(Double stabilityScore) {
		StabilityScore = stabilityScore;
	}

	public Double getMovementScore() {
		return MovementScore;
	}

	public void setMovementScore(Double movementScore) {
		MovementScore = movementScore;
	}

	public Double getAbsoluteStrength() {
		return AbsoluteStrength;
	}

	public void setAbsoluteStrength(Double absoluteStrength) {
		AbsoluteStrength = absoluteStrength;
	}

	public Double getRelativeStrength() {
		return RelativeStrength;
	}

	public void setRelativeStrength(Double relativeStrength) {
		RelativeStrength = relativeStrength;
	}

	public Double getStrengthScore() {
		return StrengthScore;
	}

	public void setStrengthScore(Double strengthScore) {
		StrengthScore = strengthScore;
	}

	public Double getAbsolutePower() {
		return AbsolutePower;
	}

	public void setAbsolutePower(Double absolutePower) {
		AbsolutePower = absolutePower;
	}

	public Double getRelativePower() {
		return RelativePower;
	}

	public void setRelativePower(Double relativePower) {
		RelativePower = relativePower;
	}

	public Double getPowerScore() {
		return PowerScore;
	}

	public void setPowerScore(Double powerScore) {
		PowerScore = powerScore;
	}

	public Double getEnduranceScore() {
		return EnduranceScore;
	}

	public void setEnduranceScore(Double enduranceScore) {
		EnduranceScore = enduranceScore;
	}

	public Double getCoreScore() {
		return CoreScore;
	}

	public void setCoreScore(Double coreScore) {
		CoreScore = coreScore;
	}

	public Date getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		TimeStamp = timeStamp;
	}

	public Double getRestingMetabolicRate() {
		return RestingMetabolicRate;
	}

	public void setRestingMetabolicRate(Double restingMetabolicRate) {
		RestingMetabolicRate = restingMetabolicRate;
	}

	public Double getTotalEnergyExpenditure() {
		return TotalEnergyExpenditure;
	}

	public void setTotalEnergyExpenditure(Double totalEnergyExpenditure) {
		TotalEnergyExpenditure = totalEnergyExpenditure;
	}

	public Integer getDbPistolSquat_rightLeg() {
		return DbPistolSquat_rightLeg;
	}

	public void setDbPistolSquat_rightLeg(Integer dbPistolSquat_rightLeg) {
		DbPistolSquat_rightLeg = dbPistolSquat_rightLeg;
	}

	public Integer getDbPistolSquat_leftLeg() {
		return DbPistolSquat_leftLeg;
	}

	public void setDbPistolSquat_leftLeg(Integer dbPistolSquat_leftLeg) {
		DbPistolSquat_leftLeg = dbPistolSquat_leftLeg;
	}

	public Double getBroatJump() {
		return BroatJump;
	}

	public void setBroatJump(Double broatJump) {
		BroatJump = broatJump;
	}

	public Double getBenchPress5RM() {
		return BenchPress5RM;
	}

	public void setBenchPress5RM(Double benchPress5RM) {
		BenchPress5RM = benchPress5RM;
	}

	public Double getPullUpsMax() {
		return PullUpsMax;
	}

	public void setPullUpsMax(Double pullUpsMax) {
		PullUpsMax = pullUpsMax;
	}

	public Double getRowTime1000m() {
		return RowTime1000m;
	}

	public void setRowTime1000m(Double rowTime1000m) {
		RowTime1000m = rowTime1000m;
	}

	public Double getRowCalories1000m() {
		return RowCalories1000m;
	}

	public void setRowCalories1000m(Double rowCalories1000m) {
		RowCalories1000m = rowCalories1000m;
	}

	public Double getPushUpsMax() {
		return PushUpsMax;
	}

	public void setPushUpsMax(Double pushUpsMax) {
		PushUpsMax = pushUpsMax;
	}

	public Double getExternalShoulderRotationR() {
		return ExternalShoulderRotationR;
	}

	public void setExternalShoulderRotationR(Double externalShoulderRotationR) {
		ExternalShoulderRotationR = externalShoulderRotationR;
	}

	public Double getExternalShoulderRotationL() {
		return ExternalShoulderRotationL;
	}

	public void setExternalShoulderRotationL(Double externalShoulderRotationL) {
		ExternalShoulderRotationL = externalShoulderRotationL;
	}

	public Double getLowerBodyAbsoluteStrengthScore() {
		return LowerBodyAbsoluteStrengthScore;
	}

	public void setLowerBodyAbsoluteStrengthScore(Double lowerBodyAbsoluteStrengthScore) {
		LowerBodyAbsoluteStrengthScore = lowerBodyAbsoluteStrengthScore;
	}

	public Double getLowerBodyRelativeStrengthScore() {
		return LowerBodyRelativeStrengthScore;
	}

	public void setLowerBodyRelativeStrengthScore(Double lowerBodyRelativeStrengthScore) {
		LowerBodyRelativeStrengthScore = lowerBodyRelativeStrengthScore;
	}

	public Double getPushAbsoluteStrengthScore() {
		return PushAbsoluteStrengthScore;
	}

	public void setPushAbsoluteStrengthScore(Double pushAbsoluteStrengthScore) {
		PushAbsoluteStrengthScore = pushAbsoluteStrengthScore;
	}

	public Double getPushRelativeStrengthScore() {
		return PushRelativeStrengthScore;
	}

	public void setPushRelativeStrengthScore(Double pushRelativeStrengthScore) {
		PushRelativeStrengthScore = pushRelativeStrengthScore;
	}

	public Double getPullAbsoluteStrengthScore() {
		return PullAbsoluteStrengthScore;
	}

	public void setPullAbsoluteStrengthScore(Double pullAbsoluteStrengthScore) {
		PullAbsoluteStrengthScore = pullAbsoluteStrengthScore;
	}

	public Double getPullRelativeStrenghScore() {
		return PullRelativeStrenghScore;
	}

	public void setPullRelativeStrenghScore(Double pullRelativeStrenghScore) {
		PullRelativeStrenghScore = pullRelativeStrenghScore;
	}

	public Double getPeakPowerRelativeScore() {
		return PeakPowerRelativeScore;
	}

	public void setPeakPowerRelativeScore(Double peakPowerRelativeScore) {
		PeakPowerRelativeScore = peakPowerRelativeScore;
	}

	public Double getPowerAbsoluteScore10s() {
		return PowerAbsoluteScore10s;
	}

	public void setPowerAbsoluteScore10s(Double powerAbsoluteScore10s) {
		PowerAbsoluteScore10s = powerAbsoluteScore10s;
	}

	public Double getPowerRelativeScore10s() {
		return PowerRelativeScore10s;
	}

	public void setPowerRelativeScore10s(Double powerRelativeScore10s) {
		PowerRelativeScore10s = powerRelativeScore10s;
	}

	public Double getPowerAbsoluteScore60s() {
		return PowerAbsoluteScore60s;
	}

	public void setPowerAbsoluteScore60s(Double powerAbsoluteScore60s) {
		PowerAbsoluteScore60s = powerAbsoluteScore60s;
	}

	public Double getPowerRelativeScore60s() {
		return PowerRelativeScore60s;
	}

	public void setPowerRelativeScore60s(Double powerRelativeScore60s) {
		PowerRelativeScore60s = powerRelativeScore60s;
	}

	public Double getVo2MaxAbsoluteScore() {
		return Vo2MaxAbsoluteScore;
	}

	public void setVo2MaxAbsoluteScore(Double vo2MaxAbsoluteScore) {
		Vo2MaxAbsoluteScore = vo2MaxAbsoluteScore;
	}

	public Double getPowerAbsoluteScore4min() {
		return PowerAbsoluteScore4min;
	}

	public void setPowerAbsoluteScore4min(Double powerAbsoluteScore4min) {
		PowerAbsoluteScore4min = powerAbsoluteScore4min;
	}

	public Double getPowerRelativeScore4min() {
		return PowerRelativeScore4min;
	}

	public void setPowerRelativeScore4min(Double powerRelativeScore4min) {
		PowerRelativeScore4min = powerRelativeScore4min;
	}

	public Integer getMealsPerDay() {
		return MealsPerDay;
	}

	public void setMealsPerDay(Integer mealsPerDay) {
		MealsPerDay = mealsPerDay;
	}

	public Double getProteins() {
		return Proteins;
	}

	public void setProteins(Double proteins) {
		Proteins = proteins;
	}

	public Double getCarbohydrates() {
		return Carbohydrates;
	}

	public void setCarbohydrates(Double carbohydrates) {
		Carbohydrates = carbohydrates;
	}

	public Double getFats() {
		return Fats;
	}

	public void setFats(Double fats) {
		Fats = fats;
	}

	public Double getExtraCalories() {
		return ExtraCalories;
	}

	public void setExtraCalories(Double extraCalories) {
		ExtraCalories = extraCalories;
	}

	public Double getWallSquat() {
		return WallSquat;
	}

	public void setWallSquat(Double wallSquat) {
		WallSquat = wallSquat;
	}

	public Double getLateralHipBridgeRight() {
		return LateralHipBridgeRight;
	}

	public void setLateralHipBridgeRight(Double lateralHipBridgeRight) {
		LateralHipBridgeRight = lateralHipBridgeRight;
	}

	public Double getLateralHipBridgeLeft() {
		return LateralHipBridgeLeft;
	}

	public void setLateralHipBridgeLeft(Double lateralHipBridgeLeft) {
		LateralHipBridgeLeft = lateralHipBridgeLeft;
	}

	public Double getPronePlank() {
		return PronePlank;
	}

	public void setPronePlank(Double pronePlank) {
		PronePlank = pronePlank;
	}

	public Double getSeatedTrunkStability() {
		return SeatedTrunkStability;
	}

	public void setSeatedTrunkStability(Double seatedTrunkStability) {
		SeatedTrunkStability = seatedTrunkStability;
	}

	public Double getDeepWallSquat() {
		return DeepWallSquat;
	}

	public void setDeepWallSquat(Double deepWallSquat) {
		DeepWallSquat = deepWallSquat;
	}

	public Double getFingerTouchTestRin_Lex() {
		return FingerTouchTestRin_Lex;
	}

	public void setFingerTouchTestRin_Lex(Double fingerTouchTestRin_Lex) {
		FingerTouchTestRin_Lex = fingerTouchTestRin_Lex;
	}

	public Double getFingerTouchTest() {
		return FingerTouchTest;
	}

	public void setFingerTouchTest(Double fingerTouchTest) {
		FingerTouchTest = fingerTouchTest;
	}

	public Double getLegRaiseRight() {
		return LegRaiseRight;
	}

	public void setLegRaiseRight(Double legRaiseRight) {
		LegRaiseRight = legRaiseRight;
	}

	public Double getLegRaiseLeft() {
		return LegRaiseLeft;
	}

	public void setLegRaiseLeft(Double legRaiseLeft) {
		LegRaiseLeft = legRaiseLeft;
	}

	public Double getFingerTouchTestSecond() {
		return FingerTouchTestSecond;
	}

	public void setFingerTouchTestSecond(Double fingerTouchTestSecond) {
		FingerTouchTestSecond = fingerTouchTestSecond;
	}

	public Double getFMSDeepSquat() {
		return FMSDeepSquat;
	}

	public void setFMSDeepSquat(Double fMSDeepSquat) {
		FMSDeepSquat = fMSDeepSquat;
	}

	public Double getFMSHurdleStepR() {
		return FMSHurdleStepR;
	}

	public void setFMSHurdleStepR(Double fMSHurdleStepR) {
		FMSHurdleStepR = fMSHurdleStepR;
	}

	public Double getFMSHurdleStepL() {
		return FMSHurdleStepL;
	}

	public void setFMSHurdleStepL(Double fMSHurdleStepL) {
		FMSHurdleStepL = fMSHurdleStepL;
	}

	public Double getFMSaslrR() {
		return FMSaslrR;
	}

	public void setFMSaslrR(Double fMSaslrR) {
		FMSaslrR = fMSaslrR;
	}

	public Double getFMSActiveStraitLegRaise() {
		return FMSActiveStraitLegRaise;
	}

	public void setFMSActiveStraitLegRaise(Double fMSActiveStraitLegRaise) {
		FMSActiveStraitLegRaise = fMSActiveStraitLegRaise;
	}

	public Double getFMSshoulderTestLeftArm() {
		return FMSshoulderTestLeftArm;
	}

	public void setFMSshoulderTestLeftArm(Double fMSshoulderTestLeftArm) {
		FMSshoulderTestLeftArm = fMSshoulderTestLeftArm;
	}

	public Double getFMSshoulderTestRightArm() {
		return FMSshoulderTestRightArm;
	}

	public void setFMSshoulderTestRightArm(Double fMSshoulderTestRightArm) {
		FMSshoulderTestRightArm = fMSshoulderTestRightArm;
	}

	public Double getFMSTrunkPushups() {
		return FMSTrunkPushups;
	}

	public void setFMSTrunkPushups(Double fMSTrunkPushups) {
		FMSTrunkPushups = fMSTrunkPushups;
	}

	public Double getFMSrotaryStabilityRightSide() {
		return FMSrotaryStabilityRightSide;
	}

	public void setFMSrotaryStabilityRightSide(Double fMSrotaryStabilityRightSide) {
		FMSrotaryStabilityRightSide = fMSrotaryStabilityRightSide;
	}

	public Double getFMSrotaryStabilityLeftSide() {
		return FMSrotaryStabilityLeftSide;
	}

	public void setFMSrotaryStabilityLeftSide(Double fMSrotaryStabilityLeftSide) {
		FMSrotaryStabilityLeftSide = fMSrotaryStabilityLeftSide;
	}

	public Double getFMSrotaryMobilityLeftSide() {
		return FMSrotaryMobilityLeftSide;
	}

	public void setFMSrotaryMobilityLeftSide(Double fMSrotaryMobilityLeftSide) {
		FMSrotaryMobilityLeftSide = fMSrotaryMobilityLeftSide;
	}

	public Double getFMSrotaryMobilityRightSide() {
		return FMSrotaryMobilityRightSide;
	}

	public void setFMSrotaryMobilityRightSide(Double fMSrotaryMobilityRightSide) {
		FMSrotaryMobilityRightSide = fMSrotaryMobilityRightSide;
	}


}
