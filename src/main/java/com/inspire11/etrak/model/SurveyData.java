package com.inspire11.etrak.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SurveyData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SURVEY_ID")
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID",referencedColumnName="client_id")
	private Client clientId;

	@ManyToOne
	@JoinColumn(name = "ACTIVITYLEVEL_ID",referencedColumnName="activitylevel_id")
	private ActivityLevel activityLevelId;
	
	@Column(name = "nutritional_Goal")
	private String nutritionalGoal;

	private String unit; 
	
	private Double weight;

	private Double height;

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
	
	private Double lowerMaxL;

	private Double pushMaxR;
	
	private Double pushMaxL;
	
	private Double pullMax;
	
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
	
	private Double mileRun;
	
	private Double kmRun;
	
	private Double min4PowerOutput;
	
	private Double Calories;
	
	private Double vo2Max;
	
	private Double min4RelativeOutput;
	
	private String Notes;
	
	public Double movement;
	
	public Double strength;
	
	public Double power;
	
	public Double endurance;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public ActivityLevel getActivityLevelId() {
		return activityLevelId;
	}

	public void setActivityLevelId(ActivityLevel activityLevelId) {
		this.activityLevelId = activityLevelId;
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

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
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

	public Double getMileRun() {
		return mileRun;
	}

	public void setMileRun(Double mileRun) {
		this.mileRun = mileRun;
	}

	public Double getKmRun() {
		return kmRun;
	}

	public void setKmRun(Double kmRun) {
		this.kmRun = kmRun;
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

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public Double getMovement() {
		return movement;
	}

	public void setMovement(Double movement) {
		this.movement = movement;
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
	
}
	
	
	

