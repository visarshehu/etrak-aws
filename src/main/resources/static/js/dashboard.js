
function getTopClientsMale(){
	 var url = "/getSurveyData/M";
	  $.getJSON(url, function(data){
		  	document.getElementById("male1").innerHTML=  "<h4 style='color: black;'><b>"+data[0].client["name"]+" "+data[0].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[0].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("male2").innerHTML=  "<h4 style='color: black;'><b>"+data[1].client["name"]+" "+data[1].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[1].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("male3").innerHTML=  "<h4 style='color: black;'><b>"+data[2].client["name"]+" "+data[2].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[2].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("male4").innerHTML=  "<h4 style='color: black;'><b>"+data[3].client["name"]+" "+data[3].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[3].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("male5").innerHTML=  "<h4 style='color: black;'><b>"+data[4].client["name"]+" "+data[4].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[4].surveyDataResults["etrakScore"]+"</b></p>";

	  });
	
}


function getTopClientsFemale(){
	 var url = "/getSurveyData/F";
	  $.getJSON(url, function(data){
		  	document.getElementById("female1").innerHTML=  "<h4 style='color: black;'><b>"+data[0].client["name"]+" "+data[0].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[0].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("female2").innerHTML=  "<h4 style='color: black;'><b>"+data[1].client["name"]+" "+data[1].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[1].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("female3").innerHTML=  "<h4 style='color: black;'><b>"+data[2].client["name"]+" "+data[2].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[2].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("female4").innerHTML=  "<h4 style='color: black;'><b>"+data[3].client["name"]+" "+data[3].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[3].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("female5").innerHTML=  "<h4 style='color: black;'><b>"+data[4].client["name"]+" "+data[4].client["lastName"]+"</b></h4><p style='font-size: 11px;'>TRAKscore: <b>"+data[4].surveyDataResults["etrakScore"]+"</b></p>";

	  });
	
}


function getActivityFeed(){
	 var url = "/getActivityFeed";
	  $.getJSON(url, function(data){
		  	document.getElementById("firstName").innerHTML="<h4 style='color: black;'><b>"+data[0].client["name"]+" "+data[0].client["lastName"]+"</b></h4>";
		  	document.getElementById("firstScore").innerHTML="<p style='font-size: 11px;'>TRAKscore: <b>"+data[0].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("firstMovement").innerHTML="<p style='font-size: 11px;'>Movement: <b>"+data[0].surveyDataResults["movement"]+"</b></pp>";
		  	document.getElementById("firstPower").innerHTML="<p style='font-size: 11px;'>Power: <b>"+data[0].surveyDataResults["power"]+"</b></p>";
		  	document.getElementById("firstStrength").innerHTML="<p style='font-size: 11px;'>Sterngth: <b>"+data[0].surveyDataResults["strength"]+"</b></p>";
		  	document.getElementById("firstEndurance").innerHTML="<p style='font-size: 11px;'>Endurance: <b>"+data[0].surveyDataResults["endurance"]+"</b></p>";
		  	var date=new Date(data[0].submittedDate).toUTCString();
		  	document.getElementById("firstDate").innerHTML="<p style='font-size: 12px; font-family: Calibri; margin-top: 0px'>"+date+"</b></p>";
		  	
		  	document.getElementById("secondName").innerHTML="<h4 style='color: black;'><b>"+data[1].client["name"]+" "+data[1].client["lastName"]+"</b></h4>";
		  	document.getElementById("secondScore").innerHTML="<p style='font-size: 11px;'>TRAKscore: <b>"+data[1].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("secondMovement").innerHTML="<p style='font-size: 11px;'>Movement: <b>"+data[1].surveyDataResults["movement"]+"</b></pp>";
		  	document.getElementById("secondPower").innerHTML="<p style='font-size: 11px;'>Power: <b>"+data[1].surveyDataResults["power"]+"</b></p>";
		  	document.getElementById("secondStrength").innerHTML="<p style='font-size: 11px;'>Sterngth: <b>"+data[1].surveyDataResults["strength"]+"</b></p>";
		  	document.getElementById("secondEndurance").innerHTML="<p style='font-size: 11px;'>Endurance: <b>"+data[1].surveyDataResults["endurance"]+"</b></p>";
		  	var date=new Date(data[1].submittedDate).toUTCString();
		  	document.getElementById("secondDate").innerHTML="<p style='font-size: 12px; font-family: Calibri; margin-top: 0px'>"+date+"</b></p>";
		  	
		  	document.getElementById("thirdName").innerHTML="<h4 style='color: black;'><b>"+data[2].client["name"]+" "+data[2].client["lastName"]+"</b></h4>";
		  	document.getElementById("thirdScore").innerHTML="<p style='font-size: 11px;'>TRAKscore: <b>"+data[2].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("thirdMovement").innerHTML="<p style='font-size: 11px;'>Movement: <b>"+data[2].surveyDataResults["movement"]+"</b></pp>";
		  	document.getElementById("thirdPower").innerHTML="<p style='font-size: 11px;'>Power: <b>"+data[2].surveyDataResults["power"]+"</b></p>";
		  	document.getElementById("thirdStrength").innerHTML="<p style='font-size: 11px;'>Sterngth: <b>"+data[2].surveyDataResults["strength"]+"</b></p>";
		  	document.getElementById("thirdEndurance").innerHTML="<p style='font-size: 11px;'>Endurance: <b>"+data[2].surveyDataResults["endurance"]+"</b></p>";
		  	var date=new Date(data[2].submittedDate).toUTCString();
		  	document.getElementById("thirdDate").innerHTML="<p style='font-size: 12px; font-family: Calibri; margin-top: 0px'>"+date+"</b></p>";
		  	
		  	document.getElementById("fourthName").innerHTML="<h4 style='color: black;'><b>"+data[3].client["name"]+" "+data[3].client["lastName"]+"</b></h4>";
		  	document.getElementById("fourthScore").innerHTML="<p style='font-size: 11px;'>TRAKscore: <b>"+data[3].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("fourthMovement").innerHTML="<p style='font-size: 11px;'>Movement: <b>"+data[3].surveyDataResults["movement"]+"</b></pp>";
		  	document.getElementById("fourthPower").innerHTML="<p style='font-size: 11px;'>Power: <b>"+data[3].surveyDataResults["power"]+"</b></p>";
		  	document.getElementById("fourthStrength").innerHTML="<p style='font-size: 11px;'>Sterngth: <b>"+data[3].surveyDataResults["strength"]+"</b></p>";
		  	document.getElementById("fourthEndurance").innerHTML="<p style='font-size: 11px;'>Endurance: <b>"+data[3].surveyDataResults["endurance"]+"</b></p>";
		  	var date=new Date(data[3].submittedDate).toUTCString();
		  	document.getElementById("fourthDate").innerHTML="<p style='font-size: 12px; font-family: Calibri; margin-top: 0px'>"+date+"</b></p>";
		  	
		  	document.getElementById("fifthName").innerHTML="<h4 style='color: black;'><b>"+data[4].client["name"]+" "+data[4].client["lastName"]+"</b></h4>";
		  	document.getElementById("fifthScore").innerHTML="<p style='font-size: 11px;'>TRAKscore: <b>"+data[4].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("fifthMovement").innerHTML="<p style='font-size: 11px;'>Movement: <b>"+data[4].surveyDataResults["movement"]+"</b></pp>";
		  	document.getElementById("fifthPower").innerHTML="<p style='font-size: 11px;'>Power: <b>"+data[4].surveyDataResults["power"]+"</b></p>";
		  	document.getElementById("fifthStrength").innerHTML="<p style='font-size: 11px;'>Sterngth: <b>"+data[4].surveyDataResults["strength"]+"</b></p>";
		  	document.getElementById("fifthEndurance").innerHTML="<p style='font-size: 11px;'>Endurance: <b>"+data[4].surveyDataResults["endurance"]+"</b></p>";
		  	var date=new Date(data[4].submittedDate).toUTCString();
		  	document.getElementById("fifthDate").innerHTML="<p style='font-size: 12px; font-family: Calibri; margin-top: 0px'>"+date+"</b></p>";
		  	
		  	document.getElementById("sixthName").innerHTML="<h4 style='color: black;'><b>"+data[5].client["name"]+" "+data[5].client["lastName"]+"</b></h4>";
		  	document.getElementById("sixthScore").innerHTML="<p style='font-size: 11px;'>TRAKscore: <b>"+data[5].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("sixthMovement").innerHTML="<p style='font-size: 11px;'>Movement: <b>"+data[5].surveyDataResults["movement"]+"</b></pp>";
		  	document.getElementById("sixthPower").innerHTML="<p style='font-size: 11px;'>Power: <b>"+data[5].surveyDataResults["power"]+"</b></p>";
		  	document.getElementById("sixthStrength").innerHTML="<p style='font-size: 11px;'>Sterngth: <b>"+data[5].surveyDataResults["strength"]+"</b></p>";
		  	document.getElementById("sixthEndurance").innerHTML="<p style='font-size: 11px;'>Endurance: <b>"+data[5].surveyDataResults["endurance"]+"</b></p>";
		  	var date=new Date(data[5].submittedDate).toUTCString();
		  	document.getElementById("sixthDate").innerHTML="<p style='font-size: 12px; font-family: Calibri; margin-top: 0px'>"+date+"</b></p>";
		  	
		  	document.getElementById("seventhName").innerHTML="<h4 style='color: black;'><b>"+data[6].client["name"]+" "+data[6].client["lastName"]+"</b></h4>";
		  	document.getElementById("seventhScore").innerHTML="<p style='font-size: 11px;'>TRAKscore: <b>"+data[6].surveyDataResults["etrakScore"]+"</b></p>";
		  	document.getElementById("seventhMovement").innerHTML="<p style='font-size: 11px;'>Movement: <b>"+data[6].surveyDataResults["movement"]+"</b></pp>";
		  	document.getElementById("seventhPower").innerHTML="<p style='font-size: 11px;'>Power: <b>"+data[6].surveyDataResults["power"]+"</b></p>";
		  	document.getElementById("seventhStrength").innerHTML="<p style='font-size: 11px;'>Sterngth: <b>"+data[6].surveyDataResults["strength"]+"</b></p>";
		  	document.getElementById("seventhEndurance").innerHTML="<p style='font-size: 11px;'>Endurance: <b>"+data[6].surveyDataResults["endurance"]+"</b></p>";
		  	var date=new Date(data[6].submittedDate).toUTCString();
		  	document.getElementById("seventhDate").innerHTML="<p style='font-size: 12px; font-family: Calibri; margin-top: 0px'>"+date+"</b></p>";

	  });
	
}

getTopClientsMale();
getTopClientsFemale();
getActivityFeed();