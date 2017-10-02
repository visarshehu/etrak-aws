package com.inspire11.etrak.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	private String activityLevel;

	@Column(name = "nutritional_Goal")
	private String nutritionalGoal;

	private String unit;

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

	private Double pullMax;

	private Double pullMaxKg;

	private Double lowerAbsoluteForce;

	private Double lowerRelativeForce;

	private Double pushAbsoluteForce;

	private Double pushRelativeForce;

	private Double pullAbsoluteForce;

	private Double pullRelativeForce;

	private Double s10PowerOutput;

	private Double s60PowerOutput;

	private Double s10RelativePower;

	private Double s60RelativePower;

	private String mileRun;

	private String kmRow;

	private String m1600Run;

	private Double min4PowerOutput;

	private Double Calories;

	private Double vo2Max;

	private Double min4RelativeOutput;

	private String notes;
	
	@OneToMany(mappedBy = "surveydataresults", cascade = CascadeType.ALL)
	@JsonManagedReference  
	private Set<SurveyDataResults> survey= new HashSet<SurveyDataResults>();

	

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

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}



	public String getNutritionalGoal() {
		return nutritionalGoal;
	}

	public void setNutritionalGoal(String nutritionalGoal) {
		this.nutritionalGoal = nutritionalGoal;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public Double getPullMax() {
		return pullMax;
	}

	public void setPullMax(Double pullMax) {
		this.pullMax = pullMax;
	}

	public Double getLowerAbsoluteForce() {
		return lowerAbsoluteForce;
	}

	public void setLowerAbsoluteForce(Double lowerAbsoluteForce) {
		this.lowerAbsoluteForce = lowerAbsoluteForce;
	}

	public Double getLowerRelativeForce() {
		return lowerRelativeForce;
	}

	public void setLowerRelativeForce(Double lowerRelativeForce) {
		this.lowerRelativeForce = lowerRelativeForce;
	}

	public Double getPushAbsoluteForce() {
		return pushAbsoluteForce;
	}

	public void setPushAbsoluteForce(Double pushAbsoluteForce) {
		this.pushAbsoluteForce = pushAbsoluteForce;
	}

	public Double getPushRelativeForce() {
		return pushRelativeForce;
	}

	public void setPushRelativeForce(Double pushRelativeForce) {
		this.pushRelativeForce = pushRelativeForce;
	}

	public Double getPullAbsoluteForce() {
		return pullAbsoluteForce;
	}

	public void setPullAbsoluteForce(Double pullAbsoluteForce) {
		this.pullAbsoluteForce = pullAbsoluteForce;
	}

	public Double getPullRelativeForce() {
		return pullRelativeForce;
	}

	public void setPullRelativeForce(Double pullRelativeForce) {
		this.pullRelativeForce = pullRelativeForce;
	}

	public Double getS10PowerOutput() {
		return s10PowerOutput;
	}

	public void setS10PowerOutput(Double s10PowerOutput) {
		this.s10PowerOutput = s10PowerOutput;
	}

	public Double getS60PowerOutput() {
		return s60PowerOutput;
	}

	public void setS60PowerOutput(Double s60PowerOutput) {
		this.s60PowerOutput = s60PowerOutput;
	}

	public Double getS10RelativePower() {
		return s10RelativePower;
	}

	public void setS10RelativePower(Double s10RelativePower) {
		this.s10RelativePower = s10RelativePower;
	}

	public Double getS60RelativePower() {
		return s60RelativePower;
	}

	public void setS60RelativePower(Double s60RelativePower) {
		this.s60RelativePower = s60RelativePower;
	}

	

	public Double getMin4PowerOutput() {
		return min4PowerOutput;
	}

	public void setMin4PowerOutput(Double min4PowerOutput) {
		this.min4PowerOutput = min4PowerOutput;
	}

	public Double getCalories() {
		return Calories;
	}

	public void setCalories(Double calories) {
		Calories = calories;
	}

	public Double getVo2Max() {
		return vo2Max;
	}

	public void setVo2Max(Double vo2Max) {
		this.vo2Max = vo2Max;
	}

	public Double getMin4RelativeOutput() {
		return min4RelativeOutput;
	}

	public void setMin4RelativeOutput(Double min4RelativeOutput) {
		this.min4RelativeOutput = min4RelativeOutput;
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

	public String getMileRun() {
		return mileRun;
	}

	public void setMileRun(String mileRun) {
		this.mileRun = mileRun;
	}

	public String getKmRow() {
		return kmRow;
	}

	public void setKmRow(String kmRow) {
		this.kmRow = kmRow;
	}

	public String getM1600Run() {
		return m1600Run;
	}

	public void setM1600Run(String m1600Run) {
		this.m1600Run = m1600Run;
	}

}
