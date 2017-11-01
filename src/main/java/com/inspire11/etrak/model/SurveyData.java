package com.inspire11.etrak.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SurveyData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SURVEY_ID")
	private Long Id;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "client_id")
	public Client client;

	private String activityLevel_id;

	private String nutritionalGoal;

	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "surveyresult_id")
	private SurveyDataResults surveyDataResults;
	
	private Character unit;

	private Double weight;

	private Double weightKg;

	private Double heightFeet;

	private Double heightInches;

	private Double heightCm;

	private Double bodyFat;

	private Integer SBP;

	private Integer DBP;

	private Integer RHR;

	private Integer deepSquatHipFlexion;

	private Integer shoulderFlexionR;

	private Integer shoulderFlexionL;

	private Integer shoulderExtensionR;

	private Integer shoulderExtensionL;

	private Integer trunkRotationR;

	private Integer trunkRotationL;

	private Double pistolR;

	private Double pistolL;

	private Double proneRH_LF;

	private Double proneRF_RH;

	private Double vsit;

	private Double lowerMaxR;

	private Double lowerMaxRKg;

	private Double lowerMaxL;

	private Double lowerMaxLKg;

	private Double pushMaxR;

	private Double pushMaxRKg;

	private Double pushMaxL;

	private Double pushMaxLKg;

	private Double pullMaxL;

	private Double pullMaxR;

	private Double pullMaxKg;

	private Integer s10PowerOutput;

	private Integer s60PowerOutput;

	private Integer mileRun;

	private Integer kmRow;

	private Integer m1600Run;

	private Integer min4PowerOutput;

	private Double Calories;

	private String notes;

	private Double restingMetabolicRateNutrition;

	private Double totalEnergyIntakeNutrition;

	private Double proteinNutrition;

	private Double carbohydratesNutrition;

	private Double totalFatNutrition;

	private Double BMI;

	@CreationTimestamp
	@Column(name = "submitedTime",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date submittedDate;

	/*@PrePersist
	protected void onCreate() {
		submittedDate = new Date();
	}*/

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNutritionalGoal() {
		return nutritionalGoal;
	}

	public void setNutritionalGoal(String nutritionalGoal) {
		this.nutritionalGoal = nutritionalGoal;
	}


	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeightFeet() {
		return heightFeet;
	}

	public void setHeightFeet(Double heightFeet) {
		this.heightFeet = heightFeet;
	}

	public Double getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(Double heightInches) {
		this.heightInches = heightInches;
	}

	public Double getHeightCm() {
		return heightCm;
	}

	public void setHeightCm(Double heightCm) {
		this.heightCm = heightCm;
	}

	public Double getBodyFat() {
		return bodyFat;
	}

	public void setBodyFat(Double bodyFat) {
		this.bodyFat = bodyFat;
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
		return deepSquatHipFlexion;
	}

	public void setDeepSquatHipFlexion(Integer deepSquatHipFlexion) {
		this.deepSquatHipFlexion = deepSquatHipFlexion;
	}

	public Integer getShoulderFlexionR() {
		return shoulderFlexionR;
	}

	public void setShoulderFlexionR(Integer shoulderFlexionR) {
		this.shoulderFlexionR = shoulderFlexionR;
	}

	public Integer getShoulderFlexionL() {
		return shoulderFlexionL;
	}

	public void setShoulderFlexionL(Integer shoulderFlexionL) {
		this.shoulderFlexionL = shoulderFlexionL;
	}

	public Integer getShoulderExtensionR() {
		return shoulderExtensionR;
	}

	public void setShoulderExtensionR(Integer shoulderExtensionR) {
		this.shoulderExtensionR = shoulderExtensionR;
	}

	public Integer getShoulderExtensionL() {
		return shoulderExtensionL;
	}

	public void setShoulderExtensionL(Integer shoulderExtensionL) {
		this.shoulderExtensionL = shoulderExtensionL;
	}

	public Integer getTrunkRotationR() {
		return trunkRotationR;
	}

	public void setTrunkRotationR(Integer trunkRotationR) {
		this.trunkRotationR = trunkRotationR;
	}

	public Integer getTrunkRotationL() {
		return trunkRotationL;
	}

	public void setTrunkRotationL(Integer trunkRotationL) {
		this.trunkRotationL = trunkRotationL;
	}

	public Double getPistolR() {
		return pistolR;
	}

	public void setPistolR(Double pistolR) {
		this.pistolR = pistolR;
	}

	public Double getPistolL() {
		return pistolL;
	}

	public void setPistolL(Double pistolL) {
		this.pistolL = pistolL;
	}

	public Double getProneRH_LF() {
		return proneRH_LF;
	}

	public void setProneRH_LF(Double proneRH_LF) {
		this.proneRH_LF = proneRH_LF;
	}

	public Double getProneRF_RH() {
		return proneRF_RH;
	}

	public void setProneRF_RH(Double proneRF_RH) {
		this.proneRF_RH = proneRF_RH;
	}

	public Double getVsit() {
		return vsit;
	}

	public void setVsit(Double vsit) {
		this.vsit = vsit;
	}

	public Double getLowerMaxR() {
		return lowerMaxR;
	}

	public void setLowerMaxR(Double lowerMaxR) {
		this.lowerMaxR = lowerMaxR;
	}

	public Double getLowerMaxL() {
		return lowerMaxL;
	}

	public void setLowerMaxL(Double lowerMaxL) {
		this.lowerMaxL = lowerMaxL;
	}

	public Double getPushMaxR() {
		return pushMaxR;
	}

	public void setPushMaxR(Double pushMaxR) {
		this.pushMaxR = pushMaxR;
	}

	public Double getPushMaxL() {
		return pushMaxL;
	}

	public void setPushMaxL(Double pushMaxL) {
		this.pushMaxL = pushMaxL;
	}

	public Integer getS10PowerOutput() {
		return s10PowerOutput;
	}

	public void setS10PowerOutput(Integer s10PowerOutput) {
		this.s10PowerOutput = s10PowerOutput;
	}

	public Integer getS60PowerOutput() {
		return s60PowerOutput;
	}

	public void setS60PowerOutput(Integer s60PowerOutput) {
		this.s60PowerOutput = s60PowerOutput;
	}

	public Integer getMin4PowerOutput() {
		return min4PowerOutput;
	}

	public void setMin4PowerOutput(Integer min4PowerOutput) {
		this.min4PowerOutput = min4PowerOutput;
	}

	public Double getCalories() {
		return Calories;
	}

	public void setCalories(Double calories) {
		Calories = calories;
	}

	public Double getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(Double weightKg) {
		this.weightKg = weightKg;
	}

	public Double getLowerMaxRKg() {
		return lowerMaxRKg;
	}

	public void setLowerMaxRKg(Double lowerMaxRKg) {
		this.lowerMaxRKg = lowerMaxRKg;
	}

	public Double getLowerMaxLKg() {
		return lowerMaxLKg;
	}

	public void setLowerMaxLKg(Double lowerMaxLKg) {
		this.lowerMaxLKg = lowerMaxLKg;
	}

	public Double getPushMaxRKg() {
		return pushMaxRKg;
	}

	public void setPushMaxRKg(Double pushMaxRKg) {
		this.pushMaxRKg = pushMaxRKg;
	}

	public Double getPushMaxLKg() {
		return pushMaxLKg;
	}

	public void setPushMaxLKg(Double pushMaxLKg) {
		this.pushMaxLKg = pushMaxLKg;
	}

	public Double getPullMaxKg() {
		return pullMaxKg;
	}

	public void setPullMaxKg(Double pullMaxKg) {
		this.pullMaxKg = pullMaxKg;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getMileRun() {
		return mileRun;
	}

	public void setMileRun(Integer mileRun) {
		this.mileRun = mileRun;
	}

	public Integer getKmRow() {
		return kmRow;
	}

	public void setKmRow(Integer kmRow) {
		this.kmRow = kmRow;
	}

	public Integer getM1600Run() {
		return m1600Run;
	}

	public void setM1600Run(Integer m1600Run) {
		this.m1600Run = m1600Run;
	}

	public SurveyDataResults getSurveyDataResults() {
		return surveyDataResults;
	}

	public void setSurveyDataResults(SurveyDataResults surveyDataResults) {
		this.surveyDataResults = surveyDataResults;
	}

	public Double getPullMaxL() {
		return pullMaxL;
	}

	public void setPullMaxL(Double pullMaxL) {
		this.pullMaxL = pullMaxL;
	}

	public Double getPullMaxR() {
		return pullMaxR;
	}

	public void setPullMaxR(Double pullMaxR) {
		this.pullMaxR = pullMaxR;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public Double getRestingMetabolicRateNutrition() {
		return restingMetabolicRateNutrition;
	}

	public void setRestingMetabolicRateNutrition(Double restingMetabolicRateNutrition) {
		this.restingMetabolicRateNutrition = restingMetabolicRateNutrition;
	}

	public Double getTotalEnergyIntakeNutrition() {
		return totalEnergyIntakeNutrition;
	}

	public void setTotalEnergyIntakeNutrition(Double totalEnergyIntakeNutrition) {
		this.totalEnergyIntakeNutrition = totalEnergyIntakeNutrition;
	}

	public Double getProteinNutrition() {
		return proteinNutrition;
	}

	public void setProteinNutrition(Double proteinNutrition) {
		this.proteinNutrition = proteinNutrition;
	}

	public Double getCarbohydratesNutrition() {
		return carbohydratesNutrition;
	}

	public void setCarbohydratesNutrition(Double carbohydratesNutrition) {
		this.carbohydratesNutrition = carbohydratesNutrition;
	}

	public Double getTotalFatNutrition() {
		return totalFatNutrition;
	}

	public void setTotalFatNutrition(Double totalFatNutrition) {
		this.totalFatNutrition = totalFatNutrition;
	}

	public Double getBMI() {
		return BMI;
	}

	public void setBMI(Double bMI) {
		BMI = bMI;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getActivityLevel_id() {
		return activityLevel_id;
	}

	public void setActivityLevel_id(String activityLevel_id) {
		this.activityLevel_id = activityLevel_id;
	}

	public Character getUnit() {
		return unit;
	}

	public void setUnit(Character unit) {
		this.unit = unit;
	}





}
