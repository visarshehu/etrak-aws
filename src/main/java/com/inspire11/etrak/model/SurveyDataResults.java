package com.inspire11.etrak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="surveydataresults")
public class SurveyDataResults {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SURVEYRESULT_ID")
	private Long Id;
	
    private Double etrakScore;
	
	public Double movement;
	
	public Double rangeScore;
	
	public Double controlScore;

	public Double strength;

	public Double power;

	public Double endurance;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "survey_id")
	public SurveyData survey;

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

	public Double getMovement() {
		return movement;
	}

	public void setMovement(Double movement) {
		this.movement = movement;
	}

	public Double getRangeScore() {
		return rangeScore;
	}

	public void setRangeScore(Double rangeScore) {
		this.rangeScore = rangeScore;
	}

	public Double getControlScore() {
		return controlScore;
	}

	public void setControlScore(Double controlScore) {
		this.controlScore = controlScore;
	}

	public Double getStrength() {
		return strength;
	}

	public void setStrength(Double strength) {
		this.strength = strength;
	}

	public Double getPower() {
		return power;
	}

	public void setPower(Double power) {
		this.power = power;
	}

	public Double getEndurance() {
		return endurance;
	}

	public void setEndurance(Double endurance) {
		this.endurance = endurance;
	}

	public SurveyData getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyData survey) {
		this.survey = survey;
	}
	
	
	
	
}
