var id = $("#yourId").val();
var movement,strength,power,endurance,vo2Max,linechart,lower,absolute,relative,absolute1,stability,push,relative1,shoulderL,shoulderR,externalShoulderR,externalShoulderL,trunkRotationR,trunkRotationL,hipBridgeR,hipBridgeL,plank,plankL,trunk,deepSquat,absolutepower,poweroutput,peakpower,powerratio1,powerratio6,powerratio7,vo2max,poweroutput2,powerratio4,poweroutput5,s10relative,power60Output;

function getSurveyRank(vid){
	 var url = "/getAllSurveys";
	  $.getJSON(url, function(data){
		  var rank;
		  for (var i = 0; i < data.length; i++){
			  if(data[i].Id==vid){
				 rank=i+1;
				 break;
			  }}
		  document.getElementById("rank").innerHTML="<p>Rank: <strong>"+rank+"/"+data.length+"</strong></p>";
		  
	  });
	
}

function getSurveyResults(vid){
	  var url = "/survey/" + vid;
	  $.getJSON(url, function(data){
		  var results=data;
		  	if (movement) movement.destroy();
	        if (strength) strength.destroy();
	        if (power) power.destroy();
	        if (endurance) endurance.destroy();
	        if (linechart) linechart.destroy();
	        if (lower) lower.destroy();
	        if (absolute) absolute.destroy();
	        if (relative) relative.destroy();
	        if (absolute1) absolute1.destroy();
	        if (stability) stability.destroy();
	        if (push) push.destroy();
	        if (relative1) relative1.destroy();
	        
	        if (shoulderL) shoulderL.destroy();
	        if (shoulderR) shoulderR.destroy();
	        if (externalShoulderR) externalShoulderR.destroy();
	        if (externalShoulderL) externalShoulderL.destroy();
	        if (trunkRotationR) trunkRotationR.destroy();
	        if (trunkRotationL) trunkRotationL.destroy();
	        if (hipBridgeR) hipBridgeR.destroy();
	        if (hipBridgeL) hipBridgeL.destroy();
	        if (plank) plank.destroy();
	        if (plankL) plankL.destroy();
	        if (trunk) trunk.destroy();
	        if (deepSquat) deepSquat.destroy();
	        if (absolutepower) absolutepower.destroy();
	        if (poweroutput) poweroutput.destroy();
	        if (peakpower) peakpower.destroy();
	        if (powerratio1) powerratio1.destroy();
	        if (powerratio6) powerratio6.destroy();
	        if (powerratio7) powerratio7.destroy();
	        if (vo2max) vo2max.destroy();
	        if (poweroutput2) poweroutput2.destroy();
	        if (powerratio4) powerratio4.destroy();
	        if (poweroutput5) poweroutput5.destroy();
	        if (s10relative) s10relative.destroy();
	        if (power60Output) power60Output.destroy();
	        
	        
	        movement=AnimateCircle("movement", results.surveyDataResults["movement"] / 10, "MOVEMENT");
	        strength=AnimateCircle("strength", results.surveyDataResults["strength"] / 10, "STRENGTH");
	        power=AnimateCircle("power", results.surveyDataResults["power"] / 10, "POWER");
	        endurance=AnimateCircle("endurance", results.surveyDataResults["endurance"] / 10, "ENDURANCE");
	        linechart=AnimateLine("linechart", results.surveyDataResults["rangeScore"] / 10, "MOBILITY");
	        lower=AnimateLine("lower", results.surveyDataResults["absoluteStrength"]/10, "ABSOLUTE");
	        absolute=AnimateLine("absolute", results.surveyDataResults["absolutePower"]/10, "ABSOLUTE");
	        relative=AnimateLine("relative", results.surveyDataResults["relativePower"]/10, "RELATIVE");
	        absolute1=AnimateLine("absolute1", results.surveyDataResults["absoluteEndurance"]/10, "ABSOLUTE");
	        stability=AnimateLine("stability", results.surveyDataResults["controlScore"]/10, "STABILITY");
	        push=AnimateLine("push", results.surveyDataResults["relativeStrength"]/10, "RELATIVE");
	        relative1=AnimateLine("relative1", results.surveyDataResults["relativeEndurance"]/10, "RELATIVE");
	        
	        shoulderL=TrakScore("shoulderL", results.surveyDataResults["shoulderFlexionLScore"]/10);
	        shoulderR=TrakScore("shoulderR", results.surveyDataResults["shoulderFlexionRScore"]/10);
	        externalShoulderR=TrakScore("externalShoulderR", results.surveyDataResults["shoulderExtensionRScore"]/10);
	        externalShoulderL=TrakScore("externalShoulderL", results.surveyDataResults["shoulderExtensionLScore"]/10);
	        trunkRotationR=TrakScore("trunkRotationR", results.surveyDataResults["trunkRotationRScore"]/10);
	        trunkRotationL=TrakScore("trunkRotationL", results.surveyDataResults["trunkRotationLScore"]/10);
	        hipBridgeR=TrakScore("hipBridgeR", results.surveyDataResults["pistolSquatRScore"]/10);
	        hipBridgeL=TrakScore("hipBridgeL", results.surveyDataResults["pistolSquatLScore"]/10);
	        plank=TrakScore("plank", results.surveyDataResults["proneRH_LFScore"]/10);
	        plankL=TrakScore("plankL", results.surveyDataResults["proneLH_RFScore"]/10);
	        trunk=TrakScore("trunk", results.surveyDataResults["vSitScore"]/10);
	        deepSquat=TrakScore("deepSquat", results.surveyDataResults["deepSquatScore"]/10);
	        absolutepower=TrakScore("absolutepower",results.surveyDataResults["lowerAbsoluteForce"]/10);
	        poweroutput=TrakScore("poweroutput",results.surveyDataResults["lowerRelativeForce"]/10);
	        peakpower=TrakScore("peakpower", results.surveyDataResults["pushAbsoluteForce"]/10);
	        powerratio1=TrakScore("powerratio1",results.surveyDataResults["pushRelativeForce"]/10);
	        powerratio6=TrakScore("powerratio6", results.surveyDataResults["pullAbsoluteForce"]/10);
	        powerratio7=TrakScore("powerratio7", results.surveyDataResults["pullRelativeForce"]/10);
	        vo2max=TrakScore("vo2max", results.surveyDataResults["absolutePower"]/10);
	        poweroutput2=TrakScore("4poweroutput", results.surveyDataResults["s60RelativePower"]/10);
	        powerratio4=TrakScore("4powerratio", results.surveyDataResults["vo2Score"]/10);
	        poweroutput5=TrakScore("5poweroutput",results.surveyDataResults["min4RelativePower"]/10);
	        s10relative=TrakScore("s10Relative",results.surveyDataResults["s10RelativePowerResults"]/10);
	        power60Output=TrakScore("power60Output",results.surveyDataResults["s60PowerOutputResults"]/10);
	        document.getElementById("squat").innerHTML=results.deepSquatHipFlexion;
	        document.getElementById("shoulder").innerHTML=results.shoulderFlexionL;
	        document.getElementById("rshoulder").innerHTML=results.shoulderFlexionR;
	        document.getElementById("extension").innerHTML=results.shoulderExtensionR;
	        document.getElementById("Lextension").innerHTML=results.shoulderExtensionL;
	        document.getElementById("trunkr").innerHTML=results.trunkRotationR;
	        document.getElementById("trunkl").innerHTML=results.trunkRotationL;
	        document.getElementById("pistol").innerHTML=results.pistolR;
	        document.getElementById("pistolL").innerHTML=results.pistolL;
	        document.getElementById("prone").innerHTML=results.proneRH_LF;
	        document.getElementById("pronel").innerHTML=results.proneRF_RH;
	        document.getElementById("sit").innerHTML=results.vsit;
	        document.getElementById("height").innerHTML=(results.heightFeet*12+results.heightInches);
	        document.getElementById("weight").innerHTML=results.weight;
	        document.getElementById("sbp").innerHTML=results.SBP;
	        document.getElementById("dbp").innerHTML=results.DBP;
	        document.getElementById("rhr").innerHTML=results.RHR;
	        var BMI=parseFloat(results.BMI).toFixed(2);
	        document.getElementById("bmi").innerHTML=BMI;
	        document.getElementById("bodyfat").innerHTML=results.bodyFat;
	        var RMR=parseFloat(results.restingMetabolicRateNutrition).toFixed(2);
	        document.getElementById("rmr").innerHTML=RMR;
	        
	        var totalEnergy=parseFloat(results.totalEnergyIntakeNutrition).toFixed(2);
	        document.getElementById("totalDailyEnergy").innerHTML=totalEnergy;
	        
	        var protein=parseFloat(results.proteinNutrition).toFixed(2);
	        document.getElementById("protein").innerHTML=protein;
	        
	        var carbohydrate=parseFloat(results.carbohydratesNutrition).toFixed(2);
	        document.getElementById("carbohydrate").innerHTML=carbohydrate;
	        
	        var totalFat=parseFloat(results.totalFatNutrition).toFixed(2);
	        document.getElementById("totalFat").innerHTML=totalFat;
	        document.getElementById("lowerA").innerHTML=results.surveyDataResults["lowerAbs"];
	        var lowerRel=parseFloat(results.surveyDataResults["lowerRel"]).toFixed(2);
	        document.getElementById("lowerR").innerHTML=lowerRel;
	        document.getElementById("pushA").innerHTML=results.surveyDataResults["pushAbs"];
	        var pushRel=parseFloat(results.surveyDataResults["pushRel"]).toFixed(2);
	        document.getElementById("pushL").innerHTML=pushRel;
	        document.getElementById("pullA").innerHTML=results.surveyDataResults["pullAbs"];
	        var pullRel=parseFloat(results.surveyDataResults["pullRel"]).toFixed(2);
	        document.getElementById("pullR").innerHTML=pullRel;
	        var rel=parseFloat(results.surveyDataResults["s10RelativePower"]).toFixed(2);
	        document.getElementById("s10Rel").innerHTML=rel;
	        var res=parseFloat(results.surveyDataResults["s60RelativePowerCalc"]).toFixed(2);
	        document.getElementById("power60").innerHTML=res;
	        document.getElementById("power60Out").innerHTML=results.s60PowerOutput;
	        document.getElementById("power10").innerHTML=results.s10PowerOutput;
	        var vo2=parseFloat(results.surveyDataResults["vo2Max"]).toFixed(2);
	        document.getElementById("vmax").innerHTML=vo2;
	        var min4=parseFloat(results.surveyDataResults["min4RelativePowerScored"]).toFixed(2);
	        document.getElementById("rel4").innerHTML=min4;
	        
	        var submitedDate=new Date(results.submittedDate).toDateString();
	        document.getElementById("date").innerHTML="Date: <strong>"+submitedDate +"</strong>";
	        document.getElementById("notes").innerHTML=results.notes;
	        document.getElementById("trakscore").innerHTML="TRAKScore: <strong>"+results.surveyDataResults["etrakScore"]+"</strong>";
	  });
	  
}



function getClientResults(id) {
    var url = "/clients/" + id;
    $.getJSON(url, function(data) {
    	var data=data;
    	var vid;
    	vid=(data.survey.length) - 1;
    
    	var surveyId=data.survey[vid].Id;
    	
    	getSurveyResults(surveyId);
    	
    	
    	document.getElementById("name").innerHTML=data.name;
        document.getElementById("name1").innerHTML=data.name;
        document.getElementById("name2").innerHTML=data.name;
        document.getElementById("name3").innerHTML=data.name;
        document.getElementById("name4").innerHTML=data.name;
        getSurveyRank(surveyId);
        
        data.survey.forEach(function(surveyData){
      	  $('#surveys').append(new Option(new Date(surveyData.submittedDate).toDateString(), surveyData.Id));
      

      	
        })
    });
}

getClientResults(id);

function AnimateCircle(container_id, animatePercentage, type) {
    var startColor = '#C8E6C9';
    var endColor = '#F18F01';
    
    if((animatePercentage*10)==1 || (animatePercentage*10)==2){
    	endColor='#A5D6A7';
    }
    else 
    	if((animatePercentage*10)==3 || (animatePercentage*10)==4){
    		endColor='#81C784';
    	}
    	else 
    		if((animatePercentage*10)==5 || (animatePercentage*10)==6)
    		{
    			endColor='#4CAF50';
    		}
    		else
    			if((animatePercentage*10)==7 || (animatePercentage*10)==8){
    				endColor='#388E3C';
    			}
    			else
    				if((animatePercentage*10)==9 || (animatePercentage*10)==10){
    					endColor='#2E7D32'
    				}

    var element = document.getElementById(container_id);
    var circle = new ProgressBar.Circle(element, {
        color: startColor,
        trailColor: '#eee',
        trailWidth: 3,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        text: {
            value: "<h4 style='padding-top:30px; color:black !important; text-align:center;'><b>" + type + "</b></h4>" + "<h4 style='text-align:center; font-size:10em; margin-top:-25px;color:#1B5E20'><b>" + (animatePercentage) * 10 + "</b></h1>",
            className: 'progressbar__label'
        },

        step: function(state, circle) {
            circle.path.setAttribute('stroke', state.color);
        }
    });

    circle.animate(animatePercentage, {
        from: {
            color: startColor
        },
        to: {
            color: endColor
        }
    });

    circle.path.style.strokeLinecap = 'round';

    return circle;

}

function AnimateLine(container_id, animatePercentage, type) {
    var element = document.getElementById(container_id);
    var endColor;
    if((animatePercentage*10)==1 || (animatePercentage*10)==2){
    	endColor='#A5D6A7';
    }
    else 
    	if((animatePercentage*10)==3 || (animatePercentage*10)==4){
    		endColor='#81C784';
    	}
    	else 
    		if((animatePercentage*10)==5 || (animatePercentage*10)==6)
    		{
    			endColor='#4CAF50';
    		}
    		else
    			if((animatePercentage*10)==7 || (animatePercentage*10)==8){
    				endColor='#388E3C';
    			}
    			else
    				if((animatePercentage*10)==9 || (animatePercentage*10)==10){
    					endColor='#2E7D32'
    				}
    var bar = new ProgressBar.Line(element, {
        strokeWidth: 4,
        easing: 'easeInOut',
        duration: 1400,
        color: endColor,
        trailColor: '#eee',
        trailWidth: 3,
        svgStyle: {
            width: '95%',
            height: '100%'
        },


        text: {

            value: "<p style='float:left'>" + type + "</p><p style='padding-left:16em'>" + animatePercentage * 10 + "/10</p>",
           className: 'progressbar_linelabel',
            style: {
                color: '#f00',
                position: 'absolute',
                top: '-70%',
                padding: 0,
            }
        }


    });
    bar.path.style.strokeLinecap = 'round';

    bar.animate(animatePercentage);
    
    return bar;

}

function TrakScore(container_id, animatePercentage) {
    var element = document.getElementById(container_id);
    var endColor;
    if((animatePercentage*10)==1 || (animatePercentage*10)==2){
    	endColor='#A5D6A7';
    }
    else 
    	if((animatePercentage*10)==3 || (animatePercentage*10)==4){
    		endColor='#81C784';
    	}
    	else 
    		if((animatePercentage*10)==5 || (animatePercentage*10)==6)
    		{
    			endColor='#4CAF50';
    		}
    		else
    			if((animatePercentage*10)==7 || (animatePercentage*10)==8){
    				endColor='#388E3C';
    			}
    			else
    				if((animatePercentage*10)==9 || (animatePercentage*10)==10){
    					endColor='#2E7D32'
    				}
    			
    var bar = new ProgressBar.Line(element, {

        strokeWidth: 4,
        easing: 'easeInOut',
        duration: 1400,
        color: endColor,
        trailColor: '#eee',
        trailWidth: 3,
        svgStyle: {
            width: '85%',
            height: '7%'
        },


        text: {
            // Default: null
            value: animatePercentage * 10 + '/10',
            // Default: 'progressbar-text'
            className: 'progressbar_linelabel',
            style: {
                color: '#f00',
                position: 'absolute',
                left: '85%',
                top: '20%',
                padding: 0,
            }
        }


    });
    bar.path.style.strokeLinecap = 'round';

    bar.animate(animatePercentage);

    return bar;
}

$('#surveys').change(function(){
		var vid=$('#surveys').val();
		getSurveyResults(vid);
		getSurveyRank(vid);
		
		
	});