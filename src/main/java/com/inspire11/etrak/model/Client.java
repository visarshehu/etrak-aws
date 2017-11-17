
package com.inspire11.etrak.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Long id;

	@Column(name = "name")
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private String name;

	@Column(name = "last_name")
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private String lastName;

	@Column(name = "birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private Date birthDate;

	@Column(name = "email")
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private String email;

	@Column(name = "gender")
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private char gender;

	@Column(name = "address")
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private String address;

	@Column(name = "phone_Number")
	@JsonView({View.SurveyWithClients.class,View.ClientsWithSurvey.class})
	private String phoneNumber;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonView(View.ClientsWithSurvey.class)
	//@JsonManagedReference
	//@JsonBackReference
	private List<SurveyData> survey = new ArrayList<SurveyData>();

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<SurveyData> getSurvey() {
		return survey;
	}

	public void setSurvey(List<SurveyData> survey) {
		this.survey = survey;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
