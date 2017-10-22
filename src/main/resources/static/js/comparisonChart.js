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
	compareCircle("container3", "container4", "MOVEMENT", firstSurvey.surveyDataResults.movement/10, secondSurvey.surveyDataResults.movement/10,movement);
	compareCirclePurple("container5", "container6", "STRENGTH",firstSurvey.surveyDataResults.strength/10, secondSurvey.surveyDataResults.strength/10,power);
	compareCircleGreen("container7", "container8", "POWER", firstSurvey.surveyDataResults.power/10, secondSurvey.surveyDataResults.power/10,strength);
	compareCircleYellow("container9", "container10", "ENDURANCE",firstSurvey.surveyDataResults.endurance/10, secondSurvey.surveyDataResults.endurance/10,endurance);
	
});


TrakScoreBlack("shoulderL", 0.5);
TrakScore("shoulderR", 0.5);
TrakScore("externalShoulderR", 0.7);
TrakScoreBlack("externalShoulderL", 1);
TrakScore("internalShoulderR", 1);
TrakScoreBlack("internalShoulderL", 1);
TrakScoreBlack("florL", 0.8);
TrakScore("florR", 0.5);
TrakScore("extFloor", 0.3);
TrakScoreBlack("intFloor", 0.2);
TrakScore("pistolSquatR", 0.5);
TrakScoreBlack("pistolSquatR1", 0.7);
TrakScore("pistolSquatL", 0.6);
TrakScoreBlack("pistolSquatL1", 0.8);
TrakScore("proneRH", 0.9);
TrakScoreBlack("proneRH1", 0.4);
TrakScore("proneLH", 0.9);
TrakScoreBlack("proneLH1", 0.9);
TrakScore("vSit", 0.9);
TrakScoreBlack("vSit1", 0.9);
TrakScore("lowerAbs", 0.9);
TrakScoreBlack("lowerAbs1", 0.9);
TrakScore("lowerRel", 0.9);
TrakScoreBlack("pushAbs1", 0.9);
TrakScore("pushAbs", 0.9);
TrakScoreBlack("pushRel1", 0.9);
TrakScore("pushRel", 0.9);
TrakScoreBlack("pullAbs1", 0.9);
TrakScore("pullAbs", 0.9);
TrakScoreBlack("lowerRel1", 0.9);
TrakScore("pullRel", 0.9);
TrakScoreBlack("pullRel1", 0.9);
TrakScore("10sRel", 0.9);
TrakScoreBlack("10sRel1", 0.9);
TrakScore("60sRel", 0.9);
TrakScoreBlack("60sRel1", 0.9);
TrakScore("vo2", 0.9);
TrakScoreBlack("vo21", 0.9);
TrakScore("4minRel", 0.9);
TrakScoreBlack("4minRel1", 0.9);

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
			value : animatePercentage * 10 + '/10',
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

	bar.animate(animatePercentage); // Number from 0.0 to 1.0

}

function TrakScoreBlack(container_id, animatePercentage) {
	var element = document.getElementById(container_id);

	var bar = new ProgressBar.Line(element, {

		strokeWidth : 4,
		easing : 'easeInOut',
		duration : 1400,
		color : '#434343',
		trailColor : '#eee',
		trailWidth : 3,
		svgStyle : {
			width : '85%',
			height : '7%'
		},

		text : {
			// Default: null
			value : animatePercentage * 10 + '/10',
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

	bar.animate(animatePercentage); // Number from 0.0 to 1.0

}

function compareCircle(container_id, container_id2, type, animatePercentage,
		animatesecondPercentage,percentageDifference) {
	var element = document.getElementById(container_id);
	var element2 = document.getElementById(container_id2);
	var startColor = '#FC5B3F';
	var endColor = '#F18F01';

	var increase = (((animatePercentage) * 10 - (animatesecondPercentage) * 10) / (animatesecondPercentage * 10));

	var bar = new ProgressBar.Circle(
			element,
			{

				color : '#15AF43',

				trailColor : '#eee',
				trailWidth : 4,
				duration : 1400,
				easing : 'easeInOut',
				strokeWidth : 3,
				text : {
					value : "<h4 style='padding-top:20px;padding-left:20px;color:black !important; 'text-align:center;'><b>"
							+ type
							+ "</b></h4>"
							+ "<h4 style='text-align:center;  font-size:50px; margin-top:2px;color:#15AF43'><b>"
							+ percentageDifference + " %</b></h1>",
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
			color : '#15AF43'

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

function compareCirclePurple(container_id, container_id2, type,
		animatePercentage, animatesecondPercentage,percentageDifference) {
	var element = document.getElementById(container_id);
	var element2 = document.getElementById(container_id2);
	var startColor = '#FC5B3F';
	var endColor = '#F18F01';

	var bar = new ProgressBar.Circle(
			element,
			{

				color : '#15AF43',
				trailColor : '#eee',
				trailWidth : 4,
				duration : 1400,
				easing : 'easeInOut',
				strokeWidth : 3,
				text : {
					value : "<h4 style='padding-top:17px;padding-left:15px;color:black !important; 'text-align:center;'><b>"
							+ type
							+ "</b></h4>"
							+ "<h4 style='text-align:center;  font-size:50px; margin-top:2px;color:#8A3B48'><b>"
							+ percentageDifference + " %</b></h1>",
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
			color : '#8A3B48'

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

function compareCircleGreen(container_id, container_id2, type,
		animatePercentage, animatesecondPercentage,percentageDifference) {
	var element = document.getElementById(container_id);
	var element2 = document.getElementById(container_id2);
	var startColor = '#FC5B3F';
	var endColor = '#F18F01';

	var bar = new ProgressBar.Circle(
			element,
			{

				color : '#15AF43',
				trailColor : '#eee',
				trailWidth : 4,
				duration : 1400,
				easing : 'easeInOut',
				strokeWidth : 3,
				text : {
					value : "<h4 style='padding-top:20px;padding-left:10px;color:black !important; 'text-align:center;'><b>"
							+ type
							+ "</b></h4>"
							+ "<h4 style='text-align:center;  font-size:50px; margin-top:2px;color:#15AF43'><b>"
							+ percentageDifference+ " %</b></h1>",
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
			color : '#15AF43'

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

function compareCircleYellow(container_id, container_id2, type,
		animatePercentage, animatesecondPercentage,percentageDifference) {
	var element = document.getElementById(container_id);
	var element2 = document.getElementById(container_id2);
	var startColor = '#FC5B3F';
	var endColor = '#F18F01';

	var bar = new ProgressBar.Circle(
			element,
			{

				color : '#15AF43',
				trailColor : '#eee',
				trailWidth : 4,
				duration : 1400,
				easing : 'easeInOut',
				strokeWidth : 3,
				text : {
					value : "<h4 style='padding-top:20px;padding-left:17px;color:black !important; 'text-align:center;'><b>"
							+ type
							+ "</b></h4>"
							+ "<h4 style='text-align:center;  font-size:50px; margin-top:2px;color:#FFD100'><b>"
							+ percentageDifference+ " %</b></h1>",
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
			color : '#FFD100'
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

AnimateLine1("mobility2", 0.5, "MOBILITY");
AnimateLine1("stability2", 0.8, "STABILITY");
AnimateLine1("absolutep2", 0.4, "ABSOLUTE");
AnimateLine1("relativep2", 0.5, "RELATIVE");
AnimateLine1("lower2", 0.5, "ABSOLUTE");
AnimateLine1("push2", 0.5, "RELATIVE");
AnimateLine1("absolutee2", 0.4, "ABSOLUTE");
AnimateLine1("relativee2", 0.2, "RELATIVE");

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

AnimateLine4("mobility1", 0.7, "MOBILITY");

AnimateLine4("stability1", 0.5, "STABILITY");

AnimateLine4("lower1", 0.6, "ABSOLUTE");

AnimateLine4("push1", 0.5, "RELATIVE");

AnimateLine4("absolutep1", 0.4, "ABSOLUTE");

AnimateLine4("relativep1", 0.5, "RELATIVE");

AnimateLine4("absolutee1", 0.4, "ABSOLUTE");

AnimateLine4("relativee1", 0.2, "RELATIVE");

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