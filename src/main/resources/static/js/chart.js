var id = $("#yourId").val();

/*function fillPopup(type){
	var url="/scores/"+type;
	$.getJSON(url, function(tables){
		
		
	});
}*/
function getClientResults(id) {
    var url = "/clients/" + id;
    $.getJSON(url, function(data) {
    	var results=data.survey[data.survey.length-1];
        // console.log(result);
        AnimateCircle("movement", results.surveyDataResults["movement"] / 10, "MOVEMENT");
        AnimateCircle("strength", results.surveyDataResults["strength"] / 10, "STRENGTH");
        AnimateCircle("power", results.surveyDataResults["power"] / 10, "POWER");
        AnimateCircle("endurance", results.surveyDataResults["endurance"] / 10, "ENDURANCE");
        AnimateLine("linechart", results.surveyDataResults["rangeScore"] / 10, "MOBILITY");
        AnimateLine("lower", results.surveyDataResults["absoluteStrength"]/10, "ABSOLUTE");
        AnimateLine("absolute", results.surveyDataResults["absolutePower"]/10, "ABSOLUTE");
        AnimateLine("relative", results.surveyDataResults["relativePower"]/10, "RELATIVE");
        AnimateLine("absolute1", results.surveyDataResults["absoluteEndurance"]/10, "ABSOLUTE");
        AnimateLine("stability", results.surveyDataResults["controlScore"]/10, "STABILITY");
        AnimateLine("push", results.surveyDataResults["relativeStrength"]/10, "RELATIVE");
        AnimateLine("relative1", results.surveyDataResults["relativeEndurance"]/10, "RELATIVE");
        TrakScore("shoulderL", results.surveyDataResults["shoulderFlexionLScore"]/10);
        TrakScore("shoulderR", results.surveyDataResults["shoulderFlexionRScore"]/10);
        TrakScore("externalShoulderR", results.surveyDataResults["shoulderExtensionRScore"]/10);
        TrakScore("externalShoulderL", results.surveyDataResults["shoulderExtensionLScore"]/10);
        TrakScore("trunkRotationR", results.surveyDataResults["trunkRotationRScore"]/10);
        TrakScore("trunkRotationL", results.surveyDataResults["trunkRotationLScore"]/10);
        TrakScore("hipBridgeR", results.surveyDataResults["pistolSquatRScore"]/10);
        TrakScore("hipBridgeL", results.surveyDataResults["pistolSquatLScore"]/10);
        TrakScore("plank", results.surveyDataResults["proneRH_LFScore"]/10);
        TrakScore("plankL", results.surveyDataResults["proneLH_RFScore"]/10);
        TrakScore("trunk", results.surveyDataResults["vSitScore"]/10);
        TrakScore("deepSquat", results.surveyDataResults["deepSquatScore"]/10);
        TrakScore("absolutepower",results.surveyDataResults["lowerAbsoluteForce"]/10);
        TrakScore("poweroutput",results.surveyDataResults["lowerRelativeForce"]/10);
        TrakScore("peakpower", results.surveyDataResults["pushAbsoluteForce"]/10);
        TrakScore("powerratio1",results.surveyDataResults["pushRelativeForce"]/10);
        TrakScore("powerratio6", results.surveyDataResults["pullAbsoluteForce"]/10);
        TrakScore("powerratio7", results.surveyDataResults["pullRelativeForce"]/10);
        TrakScore("vo2max", results.surveyDataResults["absolutePower"]/10);
        TrakScore("4poweroutput", results.surveyDataResults["s60RelativePower"]/10);
        TrakScore("4powerratio", results.surveyDataResults["vo2Max"]/10);
        TrakScore("5poweroutput",results.surveyDataResults["min4RelativePower"]/10);
        TrakScore("s10Relative",results.surveyDataResults["s10RelativePowerResults"]/10);
        TrakScore("power60Output",results.surveyDataResults["s60PowerOutputResults"]/10);
        document.getElementById("squat").innerHTML=results.deepSquatHipFlexion;
        document.getElementById("shoulder").innerHTML=results.shoulderFlexionL;
        document.getElementById("rshoulder").innerHTML=results.shoulderFlexionR;
        document.getElementById("extension").innerHTML=results.shoulderFlexionL;
        document.getElementById("Lextension").innerHTML=results.shoulderFlexionR;
        document.getElementById("trunkr").innerHTML=results.trunkRotationR;
        document.getElementById("trunkl").innerHTML=results.trunkRotationL;
        document.getElementById("pistol").innerHTML=results.pistolR;
        document.getElementById("pistolL").innerHTML=results.pistolL;
        document.getElementById("prone").innerHTML=results.proneRH_LF;
        document.getElementById("pronel").innerHTML=results.proneRF_RH;
        document.getElementById("sit").innerHTML=results.vsit;
        document.getElementById("lowerA").innerHTML=results.surveyDataResults["lowerAbs"];
        var lowerRel=parseFloat(results.surveyDataResults["lowerRel"]).toFixed(2);
        document.getElementById("lowerR").innerHTML=results.surveyDataResults[lowerRel];
        document.getElementById("pushA").innerHTML=results.surveyDataResults["pushAbs"];
        var pushRel=parseFloat(results.surveyDataResults["pushRel"]).toFixed(2);
        document.getElementById("pushL").innerHTML=results.surveyDataResults[pushRel];
        document.getElementById("pullA").innerHTML=results.surveyDataResults["pullAbs"];
        var pullRel=parseFloat(results.surveyDataResults["pullRel"]).toFixed(2);
        document.getElementById("pullR").innerHTML=results.surveyDataResults["pullRel"];
        var rel=parseFloat(results.surveyDataResults["s10RelativePower"]).toFixed(2);
        document.getElementById("s10Rel").innerHTML=rel;
        var res=parseFloat(results.surveyDataResults["s60RelativePowerCalc"]).toFixed(2);
        document.getElementById("power60").innerHTML=res;
        document.getElementById("power60Out").innerHTML=results.s60PowerOutput;
        document.getElementById("power10").innerHTML=results.s10PowerOutput;
        document.getElementById("vmax").innerHTML=results.deepSquatHipFlexion;
        document.getElementById("rel4").innerHTML=results.min4PowerOutput;
        document.getElementById("name").innerHTML=data.name;
        document.getElementById("name1").innerHTML=data.name;
        document.getElementById("name2").innerHTML=data.name;
        document.getElementById("name3").innerHTML=data.name;
        document.getElementById("name4").innerHTML=data.name;
        var submitedDate=new Date(results.submittedDate).toDateString();
        document.getElementById("date").innerHTML="Date: <strong>"+submitedDate +"</strong>";
        document.getElementById("number").innerHTML="Number: <strong> " +data.survey.length+"</strong>";
        document.getElementById("trakscore").innerHTML="TRAKScore: <strong>"+results.surveyDataResults["etrakScore"]+"</strong>";
 
    });
}

getClientResults(id);

function AnimateCircle(container_id, animatePercentage, type) {
    var startColor = '#FC5B3F';
    var endColor = '#F18F01';

    var element = document.getElementById(container_id);
    var circle = new ProgressBar.Circle(element, {
        color: startColor,
        trailColor: '#eee',
        trailWidth: 3,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        text: {
            value: "<h4 style='padding-top:30px; color:black !important; text-align:center;'><b>" + type + "</b></h4>" + "<h4 style='text-align:center; font-size:10em; margin-top:-25px'><b>" + (animatePercentage) * 10 + "</b></h1>",
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


}

function AnimateLine(container_id, animatePercentage, type) {
    var element = document.getElementById(container_id);

    var bar = new ProgressBar.Line(element, {
        strokeWidth: 4,
        easing: 'easeInOut',
        duration: 1400,
        color: '#F18F01',
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

}

function TrakScore(container_id, animatePercentage) {
    var element = document.getElementById(container_id);

    var bar = new ProgressBar.Line(element, {

        strokeWidth: 4,
        easing: 'easeInOut',
        duration: 1400,
        color: '#F18F01',
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


}