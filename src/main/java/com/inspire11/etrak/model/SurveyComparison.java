package com.inspire11.etrak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SurveyComparison {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "surveycomparison_id")
	private Long id;
	
	private Long firstClient;
	
	private Long secondClient;
	
	private Long firstSurveyId;
	
	private Long secondSurveyId;

	private Double movementComparison;
	
	private Double strengthComparison;
	
	private Double powerComparison;
	
	private Double enduranceComparison;
	
	private Double overrallDifference;
	
	private Double deepSquatComparison;
	
	private Double shoulderFlexionComparisonL;
	
	private Double shoulderFlexionComparisonR;
	
	private Double shoulderExensionComparisonR;
	
	private Double shoulderExtensionComparisonL;
	
	private Double trunkRotationComparisonR;
	
	private Double trunkRotationComparisonL;
	
	private Double pistolSquatComparisonR;
	
	private Double pistolSquatComparisonL;
	
	private Double proneRHComparison;
	
	private Double proneLHComparison;
	
	private Double VSitComparison;
	
	private Double lowerAbsComparison;
	
	private Double lowerRelComparison;
	
	private Double pushAbsComparison;
	
	private Double pushRelComparison;
	
	private Double pullAbsComparison;
	
	private Double pullRelComparison;
	
	private Double s10PowerComparison;
	
	private Double s10RelComparison;
	
	private Double s60PowerComparison;
	
	private Double s60RelComparison;
	
	private Double vo2Max;
	
	private Double min4RelPower;
	
	private Double heightComparison;
	
	private Double weightComparison;
	
	private Double sbpComparison;
	
	private Double dbpComparison;
	
	private Double rhrComparison;
	
	private Double bodyFatComparison;
	
	private Double bmiComparison;
	
	private Double rmrComparison;
	
	private Double totalEnergyComparison;
	
	private Double proteinComparison;
	
	private Double carbohydratesComparison;
	
	private Double totalFatComparison;
	
	

	public Double getMovementComparison() {
		return movementComparison;
	}

	public void setMovementComparison(Double movementComparison) {
		this.movementComparison = movementComparison;
	}

	public Double getStrengthComparison() {
		return strengthComparison;
	}

	public void setStrengthComparison(Double strengthComparison) {
		this.strengthComparison = strengthComparison;
	}

	public Double getPowerComparison() {
		return powerComparison;
	}

	public void setPowerComparison(Double powerComparison) {
		this.powerComparison = powerComparison;
	}

	public Double getEnduranceComparison() {
		return enduranceComparison;
	}

	public void setEnduranceComparison(Double enduranceComparison) {
		this.enduranceComparison = enduranceComparison;
	}

	public Double getOverrallDifference() {
		return overrallDifference;
	}

	public void setOverrallDifference(Double overrallDifference) {
		this.overrallDifference = overrallDifference;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFirstClient() {
		return firstClient;
	}

	public void setFirstClient(Long firstClient) {
		this.firstClient = firstClient;
	}

	public Long getSecondClient() {
		return secondClient;
	}

	public void setSecondClient(Long secondClient) {
		this.secondClient = secondClient;
	}

	public Double getDeepSquatComparison() {
		return deepSquatComparison;
	}

	public void setDeepSquatComparison(Double deepSquatComparison) {
		this.deepSquatComparison = deepSquatComparison;
	}

	public Double getShoulderFlexionComparisonL() {
		return shoulderFlexionComparisonL;
	}

	public void setShoulderFlexionComparisonL(Double shoulderFlexionComparisonL) {
		this.shoulderFlexionComparisonL = shoulderFlexionComparisonL;
	}

	public Double getShoulderFlexionComparisonR() {
		return shoulderFlexionComparisonR;
	}

	public void setShoulderFlexionComparisonR(Double shoulderFlexionComparisonR) {
		this.shoulderFlexionComparisonR = shoulderFlexionComparisonR;
	}

	public Double getShoulderExensionComparisonR() {
		return shoulderExensionComparisonR;
	}

	public void setShoulderExensionComparisonR(Double shoulderExensionComparisonR) {
		this.shoulderExensionComparisonR = shoulderExensionComparisonR;
	}

	public Double getShoulderExtensionComparisonL() {
		return shoulderExtensionComparisonL;
	}

	public void setShoulderExtensionComparisonL(Double shoulderExtensionComparisonL) {
		this.shoulderExtensionComparisonL = shoulderExtensionComparisonL;
	}

	public Double getTrunkRotationComparisonR() {
		return trunkRotationComparisonR;
	}

	public void setTrunkRotationComparisonR(Double trunkRotationComparisonR) {
		this.trunkRotationComparisonR = trunkRotationComparisonR;
	}

	public Double getTrunkRotationComparisonL() {
		return trunkRotationComparisonL;
	}

	public void setTrunkRotationComparisonL(Double trunkRotationComparisonL) {
		this.trunkRotationComparisonL = trunkRotationComparisonL;
	}

	public Double getPistolSquatComparisonR() {
		return pistolSquatComparisonR;
	}

	public void setPistolSquatComparisonR(Double pistolSquatComparisonR) {
		this.pistolSquatComparisonR = pistolSquatComparisonR;
	}

	public Double getPistolSquatComparisonL() {
		return pistolSquatComparisonL;
	}

	public void setPistolSquatComparisonL(Double pistolSquatComparisonL) {
		this.pistolSquatComparisonL = pistolSquatComparisonL;
	}

	public Double getProneRHComparison() {
		return proneRHComparison;
	}

	public void setProneRHComparison(Double proneRHComparison) {
		this.proneRHComparison = proneRHComparison;
	}

	public Double getProneLHComparison() {
		return proneLHComparison;
	}

	public void setProneLHComparison(Double proneLHComparison) {
		this.proneLHComparison = proneLHComparison;
	}

	public Double getVSitComparison() {
		return VSitComparison;
	}

	public void setVSitComparison(Double vSitComparison) {
		VSitComparison = vSitComparison;
	}

	public Double getLowerAbsComparison() {
		return lowerAbsComparison;
	}

	public void setLowerAbsComparison(Double lowerAbsComparison) {
		this.lowerAbsComparison = lowerAbsComparison;
	}

	public Double getLowerRelComparison() {
		return lowerRelComparison;
	}

	public void setLowerRelComparison(Double lowerRelComparison) {
		this.lowerRelComparison = lowerRelComparison;
	}

	public Double getPushAbsComparison() {
		return pushAbsComparison;
	}

	public void setPushAbsComparison(Double pushAbsComparison) {
		this.pushAbsComparison = pushAbsComparison;
	}

	public Double getPushRelComparison() {
		return pushRelComparison;
	}

	public void setPushRelComparison(Double pushRelComparison) {
		this.pushRelComparison = pushRelComparison;
	}

	public Double getPullAbsComparison() {
		return pullAbsComparison;
	}

	public void setPullAbsComparison(Double pullAbsComparison) {
		this.pullAbsComparison = pullAbsComparison;
	}

	public Double getPullRelComparison() {
		return pullRelComparison;
	}

	public void setPullRelComparison(Double pullRelComparison) {
		this.pullRelComparison = pullRelComparison;
	}

	public Double getS10PowerComparison() {
		return s10PowerComparison;
	}

	public void setS10PowerComparison(Double s10PowerComparison) {
		this.s10PowerComparison = s10PowerComparison;
	}

	public Double getS10RelComparison() {
		return s10RelComparison;
	}

	public void setS10RelComparison(Double s10RelComparison) {
		this.s10RelComparison = s10RelComparison;
	}

	public Double getS60PowerComparison() {
		return s60PowerComparison;
	}

	public void setS60PowerComparison(Double s60PowerComparison) {
		this.s60PowerComparison = s60PowerComparison;
	}

	public Double getS60RelComparison() {
		return s60RelComparison;
	}

	public void setS60RelComparison(Double s60RelComparison) {
		this.s60RelComparison = s60RelComparison;
	}

	public Double getVo2Max() {
		return vo2Max;
	}

	public void setVo2Max(Double vo2Max) {
		this.vo2Max = vo2Max;
	}

	public Double getMin4RelPower() {
		return min4RelPower;
	}

	public void setMin4RelPower(Double min4RelPower) {
		this.min4RelPower = min4RelPower;
	}

	public Double getHeightComparison() {
		return heightComparison;
	}

	public void setHeightComparison(Double heightComparison) {
		this.heightComparison = heightComparison;
	}

	public Double getWeightComparison() {
		return weightComparison;
	}

	public void setWeightComparison(Double weightComparison) {
		this.weightComparison = weightComparison;
	}

	public Double getSbpComparison() {
		return sbpComparison;
	}

	public void setSbpComparison(Double sbpComparison) {
		this.sbpComparison = sbpComparison;
	}

	public Double getDbpComparison() {
		return dbpComparison;
	}

	public void setDbpComparison(Double dbpComparison) {
		this.dbpComparison = dbpComparison;
	}

	public Double getRhrComparison() {
		return rhrComparison;
	}

	public void setRhrComparison(Double rhrComparison) {
		this.rhrComparison = rhrComparison;
	}

	public Double getBodyFatComparison() {
		return bodyFatComparison;
	}

	public void setBodyFatComparison(Double bodyFatComparison) {
		this.bodyFatComparison = bodyFatComparison;
	}

	public Double getBmiComparison() {
		return bmiComparison;
	}

	public void setBmiComparison(Double bmiComparison) {
		this.bmiComparison = bmiComparison;
	}

	public Double getRmrComparison() {
		return rmrComparison;
	}

	public void setRmrComparison(Double rmrComparison) {
		this.rmrComparison = rmrComparison;
	}

	public Double getTotalEnergyComparison() {
		return totalEnergyComparison;
	}

	public void setTotalEnergyComparison(Double totalEnergyComparison) {
		this.totalEnergyComparison = totalEnergyComparison;
	}

	public Double getProteinComparison() {
		return proteinComparison;
	}

	public void setProteinComparison(Double proteinComparison) {
		this.proteinComparison = proteinComparison;
	}

	public Double getCarbohydratesComparison() {
		return carbohydratesComparison;
	}

	public void setCarbohydratesComparison(Double carbohydratesComparison) {
		this.carbohydratesComparison = carbohydratesComparison;
	}

	public Double getTotalFatComparison() {
		return totalFatComparison;
	}

	public void setTotalFatComparison(Double totalFatComparison) {
		this.totalFatComparison = totalFatComparison;
	}

	public Long getFirstSurveyId() {
		return firstSurveyId;
	}

	public void setFirstSurveyId(Long firstSurveyId) {
		this.firstSurveyId = firstSurveyId;
	}

	public Long getSecondSurveyId() {
		return secondSurveyId;
	}

	public void setSecondSurveyId(Long secondSurveyId) {
		this.secondSurveyId = secondSurveyId;
	}
	
	
}
