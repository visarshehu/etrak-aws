package com.inspire11.etrak.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ActivityLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "activitylevel_id")
	private Long id;

	@Lob
	@Column(columnDefinition="TEXT")
	private String activityLevel;
	
	private Double score;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	/*public List<SurveyData> getSurvey() {
		return survey;
	}

	public void setSurvey(List<SurveyData> survey) {
		this.survey = survey;
	}*/
}
