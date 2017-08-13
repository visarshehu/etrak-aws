package com.inspire11.etrak.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Users {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long Id;

	private String Name;

	private String LastName;

	private String UserName;

	private char[] Password;

	private char Gender;

	private Date BirthDate;

	private String PhoneNumber;

	private String Address;

	private String Email;

	private String Assessment;

	private String NutritionalGoal;

	@OneToMany
	@JoinColumn(name = "SURVERY_ID", nullable = false)
	private List<SurveyData> surveyData = new ArrayList<>();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public char[] getPassword() {
		return Password;
	}

	public void setPassword(char[] password) {
		Password = password;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAssessment() {
		return Assessment;
	}

	public void setAssessment(String assessment) {
		Assessment = assessment;
	}

	public String getNutritionalGoal() {
		return NutritionalGoal;
	}

	public void setNutritionalGoal(String nutritionalGoal) {
		NutritionalGoal = nutritionalGoal;
	}

	public List<SurveyData> getSurveyData() {
		return surveyData;
	}

	public void setSurveyData(List<SurveyData> surveyData) {
		this.surveyData = surveyData;
	}

	

}
