package com.inspire11.etrak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "surveydataresults")

public class SurveyDataResults {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SURVEYRESULT_ID")
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Long Id;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer deepSquatScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer shoulderFlexionLScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer shoulderFlexionRScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer shoulderExtensionRScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer shoulderExtensionLScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer trunkRotationRScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer trunkRotationLScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double pistolSquatRScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double pistolSquatLScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double proneRH_LFScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double proneLH_RFScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double vSitScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double etrakScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer movement;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer rangeScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer controlScore;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer strength;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer power;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer endurance;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer lowerAbsoluteForce;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer lowerRelativeForce;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer pushAbsoluteForce;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer pushRelativeForce;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer pullAbsoluteForce;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer pullRelativeForce;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double s10RelativePower;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer s60RelativePower;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double vo2Max;

	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer min4RelativePower;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer absoluteStrength;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer relativeStrength;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer absolutePower;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer relativePower;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer relativeEndurance;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer absoluteEndurance;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer min4powerOutput;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer lowerAbs;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double lowerRel;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer pushAbs;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double pushRel;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer pullAbs;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double pullRel;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer s10RelativePowerResults;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer s60PowerOutputResults;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double s60RelativePowerCalc;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer s10PowerOutputResults;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Integer vo2Score;
	
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Double min4RelativePowerScored;

	public Integer getS10RelativePowerResults() {
		return s10RelativePowerResults;
	}

	public void setS10RelativePowerResults(Integer s10RelativePowerResults) {
		this.s10RelativePowerResults = s10RelativePowerResults;
	}

	public Integer getS60PowerOutputResults() {
		return s60PowerOutputResults;
	}

	public void setS60PowerOutputResults(Integer s60PowerOutputResults) {
		this.s60PowerOutputResults = s60PowerOutputResults;
	}

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

	public Double getS60RelativePowerCalc() {
		return s60RelativePowerCalc;
	}

	public void setS60RelativePowerCalc(Double s60RelativePowerCalc) {
		this.s60RelativePowerCalc = s60RelativePowerCalc;
	}

	public Integer getS10PowerOutputResults() {
		return s10PowerOutputResults;
	}

	public void setS10PowerOutputResults(Integer s10PowerOutputResults) {
		this.s10PowerOutputResults = s10PowerOutputResults;
	}

	public Integer getVo2Score() {
		return vo2Score;
	}

	public void setVo2Score(Integer vo2Score) {
		this.vo2Score = vo2Score;
	}

	public Double getMin4RelativePowerScored() {
		return min4RelativePowerScored;
	}

	public void setMin4RelativePowerScored(Double min4RelativePowerScored) {
		this.min4RelativePowerScored = min4RelativePowerScored;
	}

}
