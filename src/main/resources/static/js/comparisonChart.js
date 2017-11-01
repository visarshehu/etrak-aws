var firstId=$("#firstId").val();
var secondId=$("#secondId").val();
var surveyId=$('#surveyId').val();
var requestY,requestX,requestZ;

var firstSurvey,secondSurvey,surveyResults;

function getFirstClient(id){
var url = "/survey/" + id;
requestX=$.getJSON(url,function(data){
	firstSurvey=data;
});
}

function getSecondClient(id){

var url = "/survey/" + id;
requestY=$.getJSON(url,function(data){
	secondSurvey=data;
});
}

function getSurveyResults(id){
	var url="/comparisonResults/"+id;
	requestZ=$.getJSON(url,function(data){
		surveyResults=data;
	});
}



getFirstClient(firstId);
getSecondClient(secondId);
getSurveyResults(surveyId);

$.when(requestX,requestY,requestZ).then(function(){

    var movement=parseFloat(surveyResults.movementComparison).toFixed(1);
    var strength=parseFloat(surveyResults.strengthComparison).toFixed(1);
    var power=parseFloat(surveyResults.powerComparison).toFixed(2);
    var endurance=parseFloat(surveyResults.enduranceComparison).toFixed(2);
    var overallDif=parseFloat(surveyResults.overrallDifference).toFixed(2);
    var overallCol;
    if(overallDif>0){
    	overallCol = '#15AF43';
		
	}
	else if(overallDif<0){
		overallCol='#8A3B48';
		
	}
	else if(overallDif==0){
		overallCol='#FFD100';
	
	}
	compareCircle("container3", "container4", "MOVEMENT", firstSurvey.surveyDataResults.movement/10, secondSurvey.surveyDataResults.movement/10,movement);
	compareCircle("container5", "container6", "STRENGTH",firstSurvey.surveyDataResults.strength/10, secondSurvey.surveyDataResults.strength/10,power);
	compareCircle("container7", "container8", "POWER", firstSurvey.surveyDataResults.power/10, secondSurvey.surveyDataResults.power/10,strength);
	compareCircle("container9", "container10", "ENDURANCE",firstSurvey.surveyDataResults.endurance/10, secondSurvey.surveyDataResults.endurance/10,endurance);
    var submitedDate=new Date(firstSurvey.submittedDate).toDateString();
    document.getElementById("overallDif").innerHTML="<h2 style='color:"+overallCol+"'><strong>"+overallDif+"%</strong></h2>";
	document.getElementById("eval1").innerHTML=" <p>Date:<strong> "+submitedDate+"</strong><br/>Rank: <br/> </p>";
    document.getElementById("score1").innerHTML=" <p>TRAKScore: <strong>"+firstSurvey.surveyDataResults["etrakScore"] +"</strong><br/> </p>";
    var secondDate=new Date(secondSurvey.submittedDate).toDateString();
	document.getElementById("eval2").innerHTML=" <p>Date:<strong> "+secondDate+"</strong><br/>Rank: <br/> </p>";
    document.getElementById("score2").innerHTML=" <p>TRAKScore: <strong>"+secondSurvey.surveyDataResults["etrakScore"] +"</strong><br/> </p>";
    AnimateLine1("mobility2", firstSurvey.surveyDataResults.rangeScore/10, "MOBILITY");
    AnimateLine1("stability2", firstSurvey.surveyDataResults.controlScore/10, "STABILITY");
    AnimateLine1("absolutep2", firstSurvey.surveyDataResults.absolutePower/10, "ABSOLUTE");
    AnimateLine1("relativep2",firstSurvey.surveyDataResults.relativePower/10 , "RELATIVE");
    AnimateLine1("lower2", firstSurvey.surveyDataResults.absoluteStrength/10, "ABSOLUTE");
    AnimateLine1("push2", firstSurvey.surveyDataResults.relativeStrength/10, "RELATIVE");
    AnimateLine1("absolutee2", firstSurvey.surveyDataResults.absoluteEndurance/10, "ABSOLUTE");
    AnimateLine1("relativee2", firstSurvey.surveyDataResults.relativeEndurance/10, "RELATIVE");
	document.getElementById("movement").innerHTML=firstSurvey.surveyDataResults.movement;
	document.getElementById("strength").innerHTML=firstSurvey.surveyDataResults.strength;
	document.getElementById("power").innerHTML=firstSurvey.surveyDataResults.power;
	document.getElementById("endurance").innerHTML=firstSurvey.surveyDataResults.endurance;
	AnimateLine4("mobility1", secondSurvey.surveyDataResults.rangeScore/10, "MOBILITY");
	AnimateLine4("stability1",secondSurvey.surveyDataResults.controlScore/10 , "STABILITY");
	AnimateLine4("lower1",secondSurvey.surveyDataResults.absoluteStrength/10 , "ABSOLUTE");
	AnimateLine4("push1",secondSurvey.surveyDataResults.relativeStrength/10, "RELATIVE");
	AnimateLine4("absolutep1",secondSurvey.surveyDataResults.absolutePower/10 , "ABSOLUTE");
	AnimateLine4("relativep1",secondSurvey.surveyDataResults.relativePower/10, "RELATIVE");
	AnimateLine4("absolutee1", secondSurvey.surveyDataResults.absoluteEndurance/10 , "ABSOLUTE");
	AnimateLine4("relativee1",secondSurvey.surveyDataResults.relativeEndurance/10 , "RELATIVE");
	document.getElementById("secondMovement").innerHTML=secondSurvey.surveyDataResults.movement;
	document.getElementById("secondStrength").innerHTML=secondSurvey.surveyDataResults.strength;
	document.getElementById("secondPower").innerHTML=secondSurvey.surveyDataResults.power;
	document.getElementById("secondEndurance").innerHTML=secondSurvey.surveyDataResults.endurance;
	

	document.getElementById("height1").innerHTML=(firstSurvey.heightFeet*12+firstSurvey.heightInches);
	document.getElementById("height2").innerHTML=(secondSurvey.heightFeet*12+secondSurvey.heightInches);
	document.getElementById("weight1").innerHTML=firstSurvey.weight;
	document.getElementById("weight2").innerHTML=secondSurvey.weight;
	document.getElementById("sbp1").innerHTML=firstSurvey.sbp;
	document.getElementById("sbp2").innerHTML=secondSurvey.sbp;
	document.getElementById("dbp1").innerHTML=firstSurvey.dbp;
	document.getElementById("dbp2").innerHTML=secondSurvey.dbp;
	document.getElementById("rhr1").innerHTML=firstSurvey.rhr;
	document.getElementById("rhr2").innerHTML=secondSurvey.rhr;
	document.getElementById("bodyfat1").innerHTML=firstSurvey.bodyFat;
	document.getElementById("bodyfat2").innerHTML=secondSurvey.bodyFat;
	
	
	document.getElementById("deep1").innerHTML=firstSurvey.deepSquatHipFlexion;
	document.getElementById("deep2").innerHTML=secondSurvey.deepSquatHipFlexion;
	document.getElementById("shoulderL1").innerHTML=firstSurvey.shoulderFlexionL;
	document.getElementById("shoulderL2").innerHTML=secondSurvey.shoulderFlexionL;
	document.getElementById("extensionR1").innerHTML=firstSurvey.shoulderExtensionR;
	document.getElementById("extensionR2").innerHTML=secondSurvey.shoulderExtensionR;
	document.getElementById("extensionL1").innerHTML=firstSurvey.shoulderExtensionL;
	document.getElementById("extensionL2").innerHTML=secondSurvey.shoulderExtensionL;
	document.getElementById("shoulderR1").innerHTML=firstSurvey.shoulderFlexionR;
	document.getElementById("shoulderR2").innerHTML=secondSurvey.shoulderFlexionR;
	document.getElementById("trunkR1").innerHTML=firstSurvey.trunkRotationR;
	document.getElementById("trunkR2").innerHTML=secondSurvey.trunkRotationR;
	document.getElementById("trunkL1").innerHTML=firstSurvey.trunkRotationL;
	document.getElementById("trunkL2").innerHTML=secondSurvey.trunkRotationL;
	document.getElementById("pistolR1").innerHTML=firstSurvey.pistolR;
	document.getElementById("pistolR2").innerHTML=secondSurvey.pistolR;
	document.getElementById("pistolL1").innerHTML=firstSurvey.pistolL;
	document.getElementById("pistolL2").innerHTML=secondSurvey.pistolL;
	document.getElementById("proneRH1").innerHTML=firstSurvey.proneRH_LF;
	document.getElementById("proneRH2").innerHTML=secondSurvey.proneRH_LF;
	document.getElementById("proneLH1").innerHTML=firstSurvey.proneRF_RH;
	document.getElementById("proneLH2").innerHTML=secondSurvey.proneRF_RH;
	document.getElementById("vsit1").innerHTML=firstSurvey.vsit;
	document.getElementById("vsit2").innerHTML=secondSurvey.vsit;
	document.getElementById("lowerAbs1").innerHTML=firstSurvey.surveyDataResults.lowerAbs;
	document.getElementById("lowerAbs2").innerHTML=secondSurvey.surveyDataResults.lowerAbs;
	var lowerRelativeForce=parseFloat(firstSurvey.surveyDataResults.lowerRel).toFixed(2);
	var lowerRelativeForce2=parseFloat(secondSurvey.surveyDataResults.lowerRel).toFixed(2);
	document.getElementById("lowerRel1").innerHTML=lowerRelativeForce;
	document.getElementById("lowerRel2").innerHTML=lowerRelativeForce2;
	
	document.getElementById("pushAbs1").innerHTML=firstSurvey.surveyDataResults.pushAbs;
	document.getElementById("pushAbs2").innerHTML=secondSurvey.surveyDataResults.pushAbs;
	
	document.getElementById("pullAbs1").innerHTML=firstSurvey.surveyDataResults.pullAbs;
	document.getElementById("pullAbs2").innerHTML=secondSurvey.surveyDataResults.pullAbs;
	
	var pullRel=parseFloat(firstSurvey.surveyDataResults.pullRel).toFixed(2);
	var pullRel2=parseFloat(secondSurvey.surveyDataResults.pullRel).toFixed(2);
	document.getElementById("pullRel1").innerHTML=pullRel;
	document.getElementById("pullRel2").innerHTML=pullRel2;
	
	var pushRel=parseFloat(firstSurvey.surveyDataResults.pushRel).toFixed(2);
	var pushRel2=parseFloat(secondSurvey.surveyDataResults.pushRel).toFixed(2);
	document.getElementById("pushRel1").innerHTML=pushRel;
	document.getElementById("pushRel2").innerHTML=pushRel2;
	
	document.getElementById("10sPower1").innerHTML=firstSurvey.s10PowerOutput;
	document.getElementById("10sPower2").innerHTML=secondSurvey.s10PowerOutput;
	
	var s10sRel=parseFloat(firstSurvey.surveyDataResults.s10RelativePower).toFixed(2);
	var s10sRel1=parseFloat(secondSurvey.surveyDataResults.s10RelativePower).toFixed(2);
	document.getElementById("10sRel1").innerHTML=s10sRel;
	document.getElementById("10sRel2").innerHTML=s10sRel1;
	document.getElementById("60sPower1").innerHTML=firstSurvey.s60PowerOutput;
	document.getElementById("60sPower2").innerHTML=secondSurvey.s60PowerOutput;
	var s60sRel1=parseFloat(firstSurvey.surveyDataResults.s60RelativePowerCalc).toFixed(2);
	var s60sRel2=parseFloat(secondSurvey.surveyDataResults.s60RelativePowerCalc).toFixed(2);
	document.getElementById("60sRel1").innerHTML=s60sRel1;
	document.getElementById("60sRel2").innerHTML=s60sRel2;
	var vo21=parseFloat(firstSurvey.surveyDataResults.vo2Max).toFixed(2);
	var vo22=parseFloat(secondSurvey.surveyDataResults.vo2Max).toFixed(2);
	document.getElementById("vo21").innerHTML=vo21;
	document.getElementById("vo22").innerHTML=vo22;
	var m4minRel1=parseFloat(firstSurvey.surveyDataResults.min4RelativePowerScored).toFixed(2);
	var m4minRel2=parseFloat(secondSurvey.surveyDataResults.min4RelativePowerScored).toFixed(2);
	document.getElementById("4minRel1").innerHTML=m4minRel1;
	document.getElementById("4minRel2").innerHTML=m4minRel2;
	
	
	var BMI=parseFloat(firstSurvey.bmi).toFixed(2);
	document.getElementById("bmi1").innerHTML=BMI;
	
	var BMI2=parseFloat(secondSurvey.bmi).toFixed(2);
	document.getElementById("bmi2").innerHTML=BMI2;
	
    document.getElementById("bodyfat1").innerHTML=firstSurvey.bodyFat;
    document.getElementById("bodyfat2").innerHTML=secondSurvey.bodyFat;
    
    var RMR=parseFloat(firstSurvey.restingMetabolicRateNutrition).toFixed(2);
    document.getElementById("rmr1").innerHTML=RMR;
    
    var RMR2=parseFloat(secondSurvey.restingMetabolicRateNutrition).toFixed(2);
    document.getElementById("rmr2").innerHTML=RMR2;
    
    var totalEnergy=parseFloat(firstSurvey.totalEnergyIntakeNutrition).toFixed(2);
    document.getElementById("totalDailyEnergy1").innerHTML=totalEnergy;
    
    
    var totalEnergy2=parseFloat(secondSurvey.totalEnergyIntakeNutrition).toFixed(2);
    document.getElementById("totalDailyEnergy2").innerHTML=totalEnergy2;
    
    var protein=parseFloat(firstSurvey.proteinNutrition).toFixed(2);
    document.getElementById("protein1").innerHTML=protein;
    var protein2=parseFloat(secondSurvey.proteinNutrition).toFixed(2);
    document.getElementById("protein2").innerHTML=protein2;
    
    var carbohydrate=parseFloat(firstSurvey.carbohydratesNutrition).toFixed(2);
    document.getElementById("carbohydrates1").innerHTML=carbohydrate;
    var carbohydrate2=parseFloat(secondSurvey.carbohydratesNutrition).toFixed(2);
    document.getElementById("carbohydrates2").innerHTML=carbohydrate2;
    
    var totalFat=parseFloat(firstSurvey.totalFatNutrition).toFixed(2);
    document.getElementById("totalFat1").innerHTML=totalFat;
    
    var totalFat2=parseFloat(secondSurvey.totalFatNutrition).toFixed(2);
    document.getElementById("totalFat2").innerHTML=totalFat2;
	
    var heightDiff=parseFloat(surveyResults.heightComparison).toFixed(2);
    document.getElementById("heightDiff").innerHTML=heightDiff;
    
    var weightDiff=parseFloat(surveyResults.weightComparison).toFixed(2);
    document.getElementById("weightDiff").innerHTML=weightDiff;
    
    var sbpDiff=parseFloat(surveyResults.sbpComparison).toFixed(2);
    document.getElementById("sbpDiff").innerHTML=sbpDiff;
    
    var dbpDiff=parseFloat(surveyResults.dbpComparison).toFixed(2);
    document.getElementById("dbpDiff").innerHTML=dbpDiff;
    
    var rhrDiff=parseFloat(surveyResults.rhrComparison).toFixed(2);
    document.getElementById("rhrDiff").innerHTML=rhrDiff;
    
    var bodyfatDiff=parseFloat(surveyResults.bodyFatComparison).toFixed(2);
    document.getElementById("bodyfatDiff").innerHTML=bodyfatDiff;
    
    var bmiDiff=parseFloat(surveyResults.bmiComparison).toFixed(2);
    document.getElementById("bmiDiff").innerHTML=bmiDiff;
    
    var rmr=parseFloat(surveyResults.rmrComparison).toFixed(2);
    document.getElementById("rmr").innerHTML=rmr;
    
    var totalDailyEnergy=parseFloat(surveyResults.totalEnergyComparison).toFixed(2);
    document.getElementById("totalDailyEnergy").innerHTML=totalDailyEnergy;
    
    var protein=parseFloat(surveyResults.proteinComparison).toFixed(2);
    document.getElementById("protein").innerHTML=protein;
    
    var carbohydrate=parseFloat(surveyResults.carbohydratesComparison).toFixed(2);
    document.getElementById("carbohydrates").innerHTML=carbohydrate;
    
    var totalFat=parseFloat(surveyResults.totalFatComparison).toFixed(2);
    document.getElementById("totalFat").innerHTML=totalFat;

    var deepSquatHip=parseFloat(surveyResults.deepSquatComparison).toFixed(2);
    TrakScoreBlack("deepSquatHip", deepSquatHip/100);
    
    var shoulderL=parseFloat(surveyResults.shoulderFlexionComparisonL).toFixed(2);
    TrakScoreBlack("shoulderL", shoulderL/100);
    var shoulderR=parseFloat(surveyResults.shoulderFlexionComparisonR).toFixed(2);
    TrakScoreBlack("shoulderR", shoulderR/100);
    var extensionR=parseFloat(surveyResults.shoulderExensionComparisonR).toFixed(2);
    TrakScoreBlack("extensionR", extensionR/100);
    var extensionL=parseFloat(surveyResults.shoulderExtensionComparisonL).toFixed(2);
    TrakScoreBlack("extensionL", extensionL/100);
    var trunkRotationR=parseFloat(surveyResults.trunkRotationComparisonR).toFixed(2);
    TrakScoreBlack("trunkRotationR", trunkRotationR/100);
    var trunkRotationL=parseFloat(surveyResults.trunkRotationComparisonL).toFixed(2);
    TrakScoreBlack("trunkRotationL", trunkRotationL/100);
    
    var pistolSquatR=parseFloat(surveyResults.pistolSquatComparisonR).toFixed(2);
    TrakScoreBlack("pistolSquatR", pistolSquatR/100);
    var pistolSquatL=parseFloat(surveyResults.pistolSquatComparisonL).toFixed(2);
    TrakScoreBlack("pistolSquatL", pistolSquatL/100);
    var proneRH=parseFloat(surveyResults.proneRHComparison).toFixed(2);
    TrakScoreBlack("proneRH", proneRH/100);
    var proneLH=parseFloat(surveyResults.proneLHComparison).toFixed(2);
    TrakScoreBlack("proneLH", proneLH/100);
    var vSit=parseFloat(surveyResults.vsitComparison).toFixed(2);
    TrakScoreBlack("vSit", vSit/100);
    
    var lowerAbs=parseFloat(surveyResults.lowerAbsComparison).toFixed(2);
    TrakScoreBlack("lowerAbs", lowerAbs/100);
    var lowerRel=parseFloat(surveyResults.lowerRelComparison).toFixed(2);
    TrakScoreBlack("lowerRel", lowerRel/100);
    var pushAbs=parseFloat(surveyResults.pushAbsComparison).toFixed(2);
    TrakScoreBlack("pushAbs", pushAbs/100);
    var pushRel=parseFloat(surveyResults.pushRelComparison).toFixed(2);
    TrakScoreBlack("pushRel", pushRel/100);
    var pullAbs=parseFloat(surveyResults.pullAbsComparison).toFixed(2);
    TrakScoreBlack("pullAbs", pullAbs/100);
    var pullRel=parseFloat(surveyResults.pullRelComparison).toFixed(2);
    TrakScoreBlack("pullRel", pullRel/100);
    
    var s10sPower=parseFloat(surveyResults.s10PowerComparison).toFixed(2);
    TrakScoreBlack("10sPower", s10sPower/100);
    var s10sRel=parseFloat(surveyResults.s10RelComparison).toFixed(2);
    TrakScoreBlack("10sRel", s10sRel/100);
    var s60sPower=parseFloat(surveyResults.s60PowerComparison).toFixed(2);
    TrakScoreBlack("60sPower", s60sPower/100);
    var s60sRel=parseFloat(surveyResults.s60RelComparison).toFixed(2);
    TrakScoreBlack("60sRel", s60sRel/100);
    var vo2=parseFloat(surveyResults.vo2Max).toFixed(2);
    TrakScoreBlack("vo2", vo2/100);
    var s4minRel=parseFloat(surveyResults.min4RelPower).toFixed(2);
    TrakScoreBlack("4minRel", s4minRel/100);

    

});


//TrakScoreBlack("deepSquatHip", 0.5);
//TrakScore("shoulderL", 0.5);
//TrakScore("shoulderR", 0.7);
//TrakScoreBlack("externalShoulderR", 1);
//TrakScore("externalShoulderL", 1);
//TrakScoreBlack("internalShoulderR", 1);
//TrakScoreBlack("internalShoulderL", 0.8);
//TrakScore("trunkRotationR", 0.5);
//TrakScore("trunkRotationL", 0.3);
//TrakScore("pistolSquatR", 0.5);
//TrakScore("pistolSquatL", 0.6);
//TrakScore("proneRH", 0.9);
//TrakScore("proneLH", 0.9);
//TrakScore("vSit", 0.9);
//TrakScore("lowerAbs", 0.9);
//TrakScore("lowerRel", 0.9);
//TrakScore("pushAbs", 0.9);
//TrakScore("pushRel", 0.9);
//TrakScore("pullAbs", 0.9);
//TrakScore("pullRel", 0.9);
//TrakScore("10sRel", 0.9);
//TrakScore("60sRel", 0.9);
//TrakScore("vo2", 0.9);
//TrakScore("4minRel", 0.9);

function TrakScore(container_id, animatePercentage) {
	var element = document.getElementById(container_id);

	var bar = new ProgressBar.Line(element, {

		strokeWidth : 4,
		easing : 'easeInOut',
		duration : 1400,
		color : '#778899',
		trailColor : '#eee',
		trailWidth : 3,
		svgStyle : {
			width : '85%',
			height : '7%'
		},

		text : {
			// Default: null
			value : animatePercentage * 100+" %" ,
			// Default: 'progressbar-text'
			className : 'progressbar_linelabel',
			style : {
				// Text color.
				// Default: same as stroke color (options.color)
				color : '#f00',
				position : 'absolute',
				left : '85%',
				top : '20%',
				padding : 0,

			}
		}

	});
	bar.path.style.strokeLinecap = 'round';

	bar.animate(Math.abs(animatePercentage)); // Number from 0.0 to 1.0

}

function TrakScoreBlack(container_id, animatePercentage) {
	var element = document.getElementById(container_id);
	var endColor,animateChart;
	if(animatePercentage>1 || animatePercentage ==1) {
		animateChart=1;
		endColor = '#15AF43'
		}
	else{
		animateChart=animatePercentage;
		 endColor = '#8A3B48';
	}

	var bar = new ProgressBar.Line(element, {

		strokeWidth : 4,
		easing : 'easeInOut',
		duration : 1400,
		color : endColor,
		trailColor : '#eee',
		trailWidth : 3,
		svgStyle : {
			width : '85%',
			height : '7%'
		},

		text : {
			// Default: null
			value : animatePercentage * 100+" %" ,
			// Default: 'progressbar-text'
			className : 'progressbar_linelabel',
			style : {
				// Text color.
				// Default: same as stroke color (options.color)
				color : '#f00',
				position : 'absolute',
				left : '85%',
				top : '20%',
				padding : 0,
			}
		}

	});
	bar.path.style.strokeLinecap = 'round';

	bar.animate(Math.abs(animateChart)); // Number from 0.0 to 1.0

}

function compareCircle(container_id, container_id2, type, animatePercentage,
		animatesecondPercentage,percentageDifference) {
	var element = document.getElementById(container_id);
	var element2 = document.getElementById(container_id2);
	var endColor;
	if(percentageDifference>0){
		endColor = '#15AF43';
		
	}
	else if(percentageDifference<0){
		endColor='#8A3B48';
		
	}
	else if(percentageDifference==0){
		endColor='#FFD100';
	
	}
	
	var startColor = '#FC5B3F';
	 

	var increase = (((animatePercentage) * 10 - (animatesecondPercentage) * 10) / (animatesecondPercentage * 10));

	var bar = new ProgressBar.Circle(
			element,
			{

				color : endColor,
				trailColor : '#eee',
				trailWidth : 4,
				duration : 1400,
				easing : 'easeInOut',
				strokeWidth : 3,
				text : {
					value : "<h4 style='color:black !important;padding-left:2.5em; 'text-align:center;'><b>"
							+ type
							+ "</b></h4>"
							+ "<h4 style='text-align:center;  font-size:40px; margin-top:2px;color:"+endColor+"'><b>"
							+ percentageDifference + "%</b></h1>",
					className : 'progressbar__label'
				},
				// Set default step function for all animate calls
				step : function(state, bar) {
					bar.path.setAttribute('stroke', state.color);
				}

			});
	var bar2 = new ProgressBar.Circle(element2, {

		color : '#434343',
		trailColor : '#eee',
		trailWidth : 4,
		duration : 1400,
		easing : 'easeInOut',
		strokeWidth : 3,
		// Set default step function for all animate calls
		step : function(state, bar2) {
			bar2.path.setAttribute('stroke', state.color);
		}

	});

	bar.animate(animatePercentage, {
		from : {
			color : startColor
		},
		to : {
			color : endColor

		}
	});

	bar.path.style.strokeLinecap = 'round';

	bar2.animate(animatesecondPercentage, {
		from : {
			color : startColor
		},
		to : {
			color : '#434343'
		}
	});

	bar2.path.style.strokeLinecap = 'round';
}




function AnimateLine1(container_id, animatePercentage, type) {
	var element = document.getElementById(container_id);

	var bar = new ProgressBar.Line(element, {
		strokeWidth : 4,
		easing : 'easeInOut',
		duration : 1400,
		color : '#778899',
		trailColor : '#eee',
		trailWidth : 3,
		svgStyle : {
			width : '95%',
			height : '100%'
		},

		text : {
			// Initial value for text.
			// Default: null
			value : "<p style='float:left;font-size:10px'>" + type
					+ "</p><p style='padding-left:8em; font-size:10px'>"
					+ animatePercentage * 10 + "/10</p>",

			// Default: 'progressbar-text'
			className : 'progressbar_linelabel',
			style : {
				// Text color.
				// Default: same as stroke color (options.color)
				color : '#f00',
				position : 'absolute',

				top : '-60%',
				padding : 0,
				margin : 0,
			}
		}

	});
	bar.path.style.strokeLinecap = 'round';

	bar.animate(animatePercentage); // Number from 0.0 to 1.0

}



function AnimateLine4(container_id, animatePercentage, type) {
	var element = document.getElementById(container_id);

	var bar = new ProgressBar.Line(element, {
		strokeWidth : 4,
		easing : 'easeInOut',
		duration : 1400,
		color : '#434343',
		trailColor : '#eee',
		trailWidth : 3,
		svgStyle : {
			width : '95%',
			height : '100%'
		},

		text : {
			// Initial value for text.
			// Default: null
			value : "<p style='float:left;font-size:10px'>" + type
					+ "</p><p style='padding-left:8em; font-size:10px'>"
					+ animatePercentage * 10 + "/10</p>",

			// Default: 'progressbar-text'
			className : 'progressbar_linelabel',
			style : {
				// Text color.
				// Default: same as stroke color (options.color)
				color : '#f00',
				position : 'absolute',

				top : '-60%',
				padding : 0,
				margin : 0,
			}
		}

	});
	bar.path.style.strokeLinecap = 'round';

	bar.animate(animatePercentage); // Number from 0.0 to 1.0

}