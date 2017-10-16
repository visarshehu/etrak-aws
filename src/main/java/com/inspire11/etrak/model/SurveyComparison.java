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

	private Double movementComparison;
	
	private Double strengthComparison;
	
	private Double powerComparison;
	
	private Double enduranceComparison;
	
	private Double overrallDifference;

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
	
	
}
