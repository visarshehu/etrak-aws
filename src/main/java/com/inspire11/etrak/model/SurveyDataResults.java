package com.inspire11.etrak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "surveydataresults")
public class SurveyDataResults {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SURVEYRESULT_ID")
	private Long Id;

	private Integer deepSquatScore;

	private Integer shoulderFlexionLScore;

	private Integer shoulderFlexionRScore;

	private Integer shoulderExtensionRScore;

	private Integer shoulderExtensionLScore;

	private Integer trunkRotationRScore;

	private Integer trunkRotationLScore;

	private Double pistolSquatRScore;

	private Double pistolSquatLScore;

	private Double proneRH_LFScore;

	private Double proneLH_RFScore;

	private Double vSitScore;

	private Double etrakScore;

	private Integer movement;

	private Integer rangeScore;

	private Integer controlScore;

	private Integer strength;

	private Integer power;

	private Integer endurance;

	private Integer lowerAbsoluteForce;

	private Integer lowerRelativeForce;

	private Integer pushAbsoluteForce;

	private Integer pushRelativeForce;

	private Integer pullAbsoluteForce;

	private Integer pullRelativeForce;

	private Double s10RelativePower;

	private Integer s60RelativePower;

	private Double vo2Max;

	private Integer min4RelativePower;
	
	private Integer absoluteStrength;
	
	private Integer relativeStrength;
	
	private Integer absolutePower;
	
	private Integer relativePower;
	
	private Integer relativeEndurance;
	
	private Integer absoluteEndurance;
	
	private Integer min4powerOutput;
	
	private Integer lowerAbs;
	
	private Double lowerRel;
	
	private Integer pushAbs;
	
	private Double pushRel;
	
	private Integer pullAbs;
	
	private Double pullRel;
	
	
	

	@OneToOne(mappedBy = "surveyDataResults")
	@JsonBackReference
	private SurveyData surveyData;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Double getEtrakScore() {
		return etrakScore;
	}

	public void setEtrakScore(Double etrakScore) {
		this.etrakScore = etrakScore;
	}

	

	public Integer getRangeScore() {
		return rangeScore;
	}

	public void setRangeScore(Integer rangeScore) {
		this.rangeScore = rangeScore;
	}

	public Integer getControlScore() {
		return controlScore;
	}

	public void setControlScore(Integer controlScore) {
		this.controlScore = controlScore;
	}

	


	public Integer getLowerAbsoluteForce() {
		return lowerAbsoluteForce;
	}

	public void setLowerAbsoluteForce(Integer lowerAbsoluteForce) {
		this.lowerAbsoluteForce = lowerAbsoluteForce;
	}

	public Integer getLowerRelativeForce() {
		return lowerRelativeForce;
	}

	public void setLowerRelativeForce(Integer lowerRelativeForce) {
		this.lowerRelativeForce = lowerRelativeForce;
	}

	public Integer getPushAbsoluteForce() {
		return pushAbsoluteForce;
	}

	public void setPushAbsoluteForce(Integer pushAbsoluteForce) {
		this.pushAbsoluteForce = pushAbsoluteForce;
	}

	public Integer getPushRelativeForce() {
		return pushRelativeForce;
	}

	public void setPushRelativeForce(Integer pushRelativeForce) {
		this.pushRelativeForce = pushRelativeForce;
	}

	public Integer getPullAbsoluteForce() {
		return pullAbsoluteForce;
	}

	public void setPullAbsoluteForce(Integer pullAbsoluteForce) {
		this.pullAbsoluteForce = pullAbsoluteForce;
	}

	public Integer getPullRelativeForce() {
		return pullRelativeForce;
	}

	public void setPullRelativeForce(Integer pullRelativeForce) {
		this.pullRelativeForce = pullRelativeForce;
	}

	public Double getVo2Max() {
		return vo2Max;
	}

	public void setVo2Max(Double vo2Max) {
		this.vo2Max = vo2Max;
	}

	public Integer getMin4RelativePower() {
		return min4RelativePower;
	}

	public void setMin4RelativePower(Integer min4RelativePower) {
		this.min4RelativePower = min4RelativePower;
	}

	public SurveyData getSurveyData() {
		return surveyData;
	}

	public void setSurveyData(SurveyData surveyData) {
		this.surveyData = surveyData;
	}

	public Double getS10RelativePower() {
		return s10RelativePower;
	}

	public void setS10RelativePower(Double s10RelativePower) {
		this.s10RelativePower = s10RelativePower;
	}

	public Integer getS60RelativePower() {
		return s60RelativePower;
	}

	public void setS60RelativePower(Integer s60RelativePower) {
		this.s60RelativePower = s60RelativePower;
	}

	public Integer getDeepSquatScore() {
		return deepSquatScore;
	}

	public void setDeepSquatScore(Integer deepSquatScore) {
		this.deepSquatScore = deepSquatScore;
	}

	public Integer getShoulderFlexionLScore() {
		return shoulderFlexionLScore;
	}

	public void setShoulderFlexionLScore(Integer shoulderFlexionLScore) {
		this.shoulderFlexionLScore = shoulderFlexionLScore;
	}

	public Integer getShoulderFlexionRScore() {
		return shoulderFlexionRScore;
	}

	public void setShoulderFlexionRScore(Integer shoulderFlexionRScore) {
		this.shoulderFlexionRScore = shoulderFlexionRScore;
	}

	public Integer getShoulderExtensionRScore() {
		return shoulderExtensionRScore;
	}

	public void setShoulderExtensionRScore(Integer shoulderExtensionRScore) {
		this.shoulderExtensionRScore = shoulderExtensionRScore;
	}

	public Integer getShoulderExtensionLScore() {
		return shoulderExtensionLScore;
	}

	public void setShoulderExtensionLScore(Integer shoulderExtensionLScore) {
		this.shoulderExtensionLScore = shoulderExtensionLScore;
	}

	public Integer getTrunkRotationRScore() {
		return trunkRotationRScore;
	}

	public void setTrunkRotationRScore(Integer trunkRotationRScore) {
		this.trunkRotationRScore = trunkRotationRScore;
	}

	public Integer getTrunkRotationLScore() {
		return trunkRotationLScore;
	}

	public void setTrunkRotationLScore(Integer trunkRotationLScore) {
		this.trunkRotationLScore = trunkRotationLScore;
	}

	public Double getPistolSquatRScore() {
		return pistolSquatRScore;
	}

	public void setPistolSquatRScore(Double pistolSquatRScore) {
		this.pistolSquatRScore = pistolSquatRScore;
	}

	public Double getPistolSquatLScore() {
		return pistolSquatLScore;
	}

	public void setPistolSquatLScore(Double pistolSquatLScore) {
		this.pistolSquatLScore = pistolSquatLScore;
	}

	public Double getProneRH_LFScore() {
		return proneRH_LFScore;
	}

	public void setProneRH_LFScore(Double proneRH_LFScore) {
		this.proneRH_LFScore = proneRH_LFScore;
	}

	public Double getProneLH_RFScore() {
		return proneLH_RFScore;
	}

	public void setProneLH_RFScore(Double proneLH_RFScore) {
		this.proneLH_RFScore = proneLH_RFScore;
	}

	public Double getvSitScore() {
		return vSitScore;
	}

	public void setvSitScore(Double vSitScore) {
		this.vSitScore = vSitScore;
	}

	public Integer getMovement() {
		return movement;
	}

	public void setMovement(Integer movement) {
		this.movement = movement;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getEndurance() {
		return endurance;
	}

	public void setEndurance(Integer endurance) {
		this.endurance = endurance;
	}

	public Integer getAbsoluteStrength() {
		return absoluteStrength;
	}

	public void setAbsoluteStrength(Integer absoluteStrength) {
		this.absoluteStrength = absoluteStrength;
	}

	public Integer getRelativeStrength() {
		return relativeStrength;
	}

	public void setRelativeStrength(Integer relativeStrength) {
		this.relativeStrength = relativeStrength;
	}

	public Integer getAbsolutePower() {
		return absolutePower;
	}

	public void setAbsolutePower(Integer absolutePower) {
		this.absolutePower = absolutePower;
	}

	public Integer getRelativePower() {
		return relativePower;
	}

	public void setRelativePower(Integer relativePower) {
		this.relativePower = relativePower;
	}

	public Integer getRelativeEndurance() {
		return relativeEndurance;
	}

	public void setRelativeEndurance(Integer relativeEndurance) {
		this.relativeEndurance = relativeEndurance;
	}

	public Integer getAbsoluteEndurance() {
		return absoluteEndurance;
	}

	public void setAbsoluteEndurance(Integer absoluteEndurance) {
		this.absoluteEndurance = absoluteEndurance;
	}

	public Integer getMin4powerOutput() {
		return min4powerOutput;
	}

	public void setMin4powerOutput(Integer min4powerOutput) {
		this.min4powerOutput = min4powerOutput;
	}

	public Integer getLowerAbs() {
		return lowerAbs;
	}

	public void setLowerAbs(Integer lowerAbs) {
		this.lowerAbs = lowerAbs;
	}

	public Double getLowerRel() {
		return lowerRel;
	}

	public void setLowerRel(Double lowerRel) {
		this.lowerRel = lowerRel;
	}

	public Integer getPushAbs() {
		return pushAbs;
	}

	public void setPushAbs(Integer pushAbs) {
		this.pushAbs = pushAbs;
	}

	public Double getPushRel() {
		return pushRel;
	}

	public void setPushRel(Double pushRel) {
		this.pushRel = pushRel;
	}

	public Integer getPullAbs() {
		return pullAbs;
	}

	public void setPullAbs(Integer pullAbs) {
		this.pullAbs = pullAbs;
	}

	public Double getPullRel() {
		return pullRel;
	}

	public void setPullRel(Double pullRel) {
		this.pullRel = pullRel;
	}

}
