package com.inspire11.etrak.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActivityLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACTIVITYLEVEL_ID")
	private Long Id;

	private String ActivityLevel;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getActivityLevel() {
		return ActivityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		ActivityLevel = activityLevel;
	}

}
