
TrakScoreBlack("shoulderL",0.5);
TrakScore("shoulderR",0.5);
TrakScore("externalShoulderR",0.7);
TrakScoreBlack("externalShoulderL",1);
TrakScoreYellow("internalShoulderR",1);
TrakScoreBlack("internalShoulderL",1);
TrakScoreGreen("trunkRotationR",0.6);
TrakScoreBlack("trunkRotationL",0.6);
TrakScoreGreen("hipBridgeR",1);
TrakScoreBlack("hipBridgeL",1);
TrakScoreGreen("plank",1);
TrakScoreBlack("plankL",1);
TrakScoreGreen("trunk",1);
TrakScoreBlack("boraL",0.6);
TrakScoreBlack("florL",0.8);
TrakScoreGreen("florR",0.5);
TrakScoreGreen("extFloor",0.3);
TrakScoreBlack("intFloor",0.2);


function TrakScore(container_id, animatePercentage){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {

  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#8A3B48',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '85%', height: '7%'},


        text: {
        // Default: null
        value: animatePercentage*10+'/10',
        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
            left:'85%',
            top: '20%',
            padding: 0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0


}


function TrakScoreBlack(container_id, animatePercentage){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {

  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#434343',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '85%', height: '7%'},


        text: {
        // Default: null
        value: animatePercentage*10+'/10',
        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
            left:'85%',
            top: '20%',
            padding: 0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0


}


function TrakScoreYellow(container_id, animatePercentage){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {

  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#FFD100',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '85%', height: '7%'},


        text: {
        // Default: null
        value: animatePercentage*10+'/10',
        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
            left:'85%',
            top: '20%',
            padding: 0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0


}


function TrakScoreGreen(container_id, animatePercentage){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {

  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#15AF43',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '85%', height: '7%'},


        text: {
        // Default: null
        value: animatePercentage*10+'/10',
        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
            left:'85%',
            top: '20%',
            padding: 0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0


}


compareCircle("container3","container4","MOVEMENT",0.8,0.3,"Improvement");
compareCirclePurple("container5","container6","STRENGTH",0.7,0.5,"Decent");
compareCircleGreen("container7","container8","POWER",0.6,0.6,"Improvement");
compareCircleYellow("container9","container10","ENDURANCE",0.3,0.3,"Decent");
function compareCircle(container_id,container_id2,type,animatePercentage,animatesecondPercentage,improvement){
  var element = document.getElementById(container_id);
  var element2 = document.getElementById(container_id2);
       var startColor = '#FC5B3F';
    var endColor = '#F18F01';

  var increase=(((animatePercentage)*10-(animatesecondPercentage)*10 )/ (animatesecondPercentage*10));
   

  var bar = new ProgressBar.Circle(element, {
 
  color: '#15AF43',
	  
  trailColor: '#eee',
        trailWidth: 4,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        text: {
            value: "<h4 style='padding-top:20px;padding-left:25px;color:black !important; 'text-align:center;'><b>"+type+"</b></h4>"+ "<h4 style='text-align:center;  font-size:50px; margin-top:2px;color:#15AF43'><b>"+12+ " %</b></h1><h1 style='color:black !important; text-align:center; font-size:24px'>"+improvement+"</h1>",
            className: 'progressbar__label'
        },
        // Set default step function for all animate calls
         step: function (state, bar) {
            bar.path.setAttribute('stroke', state.color);
        }
       
});
var bar2 = new ProgressBar.Circle(element2, {

  color: '#434343',
  trailColor: '#eee',
        trailWidth: 4,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        // Set default step function for all animate calls
           step: function (state, bar2) {
            bar2.path.setAttribute('stroke', state.color);
        }
       
       
});

 bar.animate(animatePercentage, {
        from: {
            color: startColor
        },
        to: {
            color: '#15AF43'
            	
        }
    });

    bar.path.style.strokeLinecap = 'round';


 bar2.animate(animatesecondPercentage, {
        from: {
            color: startColor
        },
        to: {
            color: '#434343'
        }
    });

    bar2.path.style.strokeLinecap = 'round';
}



function compareCirclePurple(container_id,container_id2,type,animatePercentage,animatesecondPercentage,improvement){
  var element = document.getElementById(container_id);
  var element2 = document.getElementById(container_id2);
       var startColor = '#FC5B3F';
    var endColor = '#F18F01';
   

  var bar = new ProgressBar.Circle(element, {
 
  color:'#15AF43',
  trailColor: '#eee',
        trailWidth: 4,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        text: {
            value: "<h4 style='padding-top:17px;padding-left:25px;color:black !important; 'text-align:center;'><b>"+type+"</b></h4>"+ "<h4 style='text-align:center;  font-size:50px; margin-top:2px;color:#8A3B48'><b>"+3+ " %</b></h1><h1 style='color:black !important; text-align:center; font-size:24px'>"+improvement+"</h1>",
        className: 'progressbar__label'
        },
        // Set default step function for all animate calls
         step: function (state, bar) {
            bar.path.setAttribute('stroke', state.color);
        }
       
});
var bar2 = new ProgressBar.Circle(element2, {

  color: '#434343',
	  
  trailColor: '#eee',
        trailWidth: 4,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        // Set default step function for all animate calls
           step: function (state, bar2) {
            bar2.path.setAttribute('stroke', state.color);
        }
       
       
});

 bar.animate(animatePercentage, {
        from: {
            color: startColor
        },
        to: {
            color: '#8A3B48'
            	
        }
    });

    bar.path.style.strokeLinecap = 'round';


 bar2.animate(animatesecondPercentage, {
        from: {
            color: startColor
        },
        to: {
            color: '#434343'
        }
    });

    bar2.path.style.strokeLinecap = 'round';
}


function compareCircleGreen(container_id,container_id2,type,animatePercentage,animatesecondPercentage,improvement){
  var element = document.getElementById(container_id);
  var element2 = document.getElementById(container_id2);
   var startColor = '#FC5B3F';
   var endColor = '#F18F01';
   

  var bar = new ProgressBar.Circle(element, {
 
  color: '#15AF43',
  trailColor: '#eee',
        trailWidth: 4,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        text: {
            value: "<h4 style='padding-top:20px;padding-left:40px;color:black !important; 'text-align:center;'><b>"+type+"</b></h4>"+ "<h4 style='text-align:center;  font-size:50px; margin-top:2px;color:#15AF43'><b>"+6+ " %</b></h1><h1 style='color:black !important; text-align:center; font-size:24px'>"+improvement+"</h1>",
            className: 'progressbar__label'
        },
        // Set default step function for all animate calls
         step: function (state, bar) {
            bar.path.setAttribute('stroke', state.color);
        }
       
});
var bar2 = new ProgressBar.Circle(element2, {

  color: '#434343',
  trailColor: '#eee',
        trailWidth: 4,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        // Set default step function for all animate calls
           step: function (state, bar2) {
            bar2.path.setAttribute('stroke', state.color);
        }
       
       
});

 bar.animate(animatePercentage, {
        from: {
            color: startColor
        },
        to: {
            color: '#15AF43'
            	
        }
    });

    bar.path.style.strokeLinecap = 'round';


 bar2.animate(animatesecondPercentage, {
        from: {
            color: startColor
        },
        to: {
            color: '#434343'
        }
    });

    bar2.path.style.strokeLinecap = 'round';
}



function compareCircleYellow(container_id,container_id2,type,animatePercentage,animatesecondPercentage,improvement){
  var element = document.getElementById(container_id);
  var element2 = document.getElementById(container_id2);
       var startColor = '#FC5B3F';
    var endColor = '#F18F01';
   

  var bar = new ProgressBar.Circle(element, {
 
  color: '#15AF43',
  trailColor: '#eee',
        trailWidth: 4,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        text: {
            value: "<h4 style='padding-top:20px;padding-left:17px;color:black !important; 'text-align:center;'><b>"+type+"</b></h4>"+ "<h4 style='text-align:center;  font-size:50px; margin-top:2px;color:#FFD100'><b>"+0+ " %</b></h1><h1 style='color:black !important; text-align:center; font-size:24px'>"+improvement+"</h1>",
            className: 'progressbar__label'
        },
        // Set default step function for all animate calls
         step: function (state, bar) {
            bar.path.setAttribute('stroke', state.color);
        }
       
});
var bar2 = new ProgressBar.Circle(element2, {

  color: '#434343',
	  
  trailColor: '#eee',
        trailWidth: 4,
        duration: 1400,
        easing: 'easeInOut',
        strokeWidth: 3,
        // Set default step function for all animate calls
           step: function (state, bar2) {
            bar2.path.setAttribute('stroke', state.color);
        }
       
       
});

 bar.animate(animatePercentage, {
        from: {
            color: startColor
        },
        to: {
            color: '#FFD100'
        }
    });

    bar.path.style.strokeLinecap = 'round';


 bar2.animate(animatesecondPercentage, {
        from: {
            color: startColor
        },
        to: {
            color: '#434343'
            	
            	
        }
    });

    bar2.path.style.strokeLinecap = 'round';
}

AnimateLine1("mobility2", 0.5,"MOBILITY");

AnimateLine1("stability2", 0.8,"STABILITY");

AnimateLine1("pull2", 0.9,"PULL");

AnimateLine1("absolutep2", 0.4,"ABSOLUTE");

AnimateLine1("relativep2", 0.5,"RELATIVE");






function AnimateLine1(container_id, animatePercentage,type){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {
  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#15AF43',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '95%', height: '100%'},


        text: {
        // Initial value for text.
        // Default: null
        value:"<p style='float:left;font-size:10px'>"+ type+"</p><p style='padding-left:70px; font-size:10px'>"+animatePercentage*10+"/10</p>",

        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
         
            top: '-60%',
            padding: 0,
            margin:0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0

}

AnimateLine2("lower2", 0.5,"LOWER");

function AnimateLine2(container_id, animatePercentage,type){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {
  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#972F3D',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '95%', height: '100%'},


        text: {
        // Initial value for text.
        // Default: null
        value:"<p style='float:left;font-size:10px'>"+ type+"</p><p style='padding-left:70px; font-size:10px'>"+animatePercentage*10+"/10</p>",

        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
         
            top: '-60%',
            padding: 0,
            margin:0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0

}

AnimateLine3("push2", 0.5,"PUSH");
AnimateLine3("absolutee2", 0.4,"ABSOLUTE");
AnimateLine3("relativee2", 0.2,"RELATIVE");



function AnimateLine3(container_id, animatePercentage,type){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {
  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#F3C804',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '95%', height: '100%'},


        text: {
        // Initial value for text.
        // Default: null
        value:"<p style='float:left;font-size:10px'>"+ type+"</p><p style='padding-left:70px; font-size:10px'>"+animatePercentage*10+"/10</p>",

        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
         
            top: '-60%',
            padding: 0,
            margin:0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0

}

AnimateLine4("mobility1", 0.7,"MOBILITY");

AnimateLine4("stability1", 0.5,"STABILITY");

AnimateLine4("lower1", 0.6,"LOWER");

AnimateLine4("push1", 0.5,"PUSH");

AnimateLine4("pull1", 0.9,"PULL");

AnimateLine4("absolutep1", 0.4,"ABSOLUTE");

AnimateLine4("relativep1", 0.5,"RELATIVE");

AnimateLine4("absolutee1", 0.4,"ABSOLUTE");

AnimateLine4("relativee1", 0.2,"RELATIVE");

function AnimateLine4(container_id, animatePercentage,type){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {
  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#434343',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '95%', height: '100%'},


        text: {
        // Initial value for text.
        // Default: null
        value:"<p style='float:left;font-size:10px'>"+ type+"</p><p style='padding-left:70px; font-size:10px'>"+animatePercentage*10+"/10</p>",

        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
         
            top: '-60%',
            padding: 0,
            margin:0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0

}