AnimateCircle("movement", 0.8,"MOVEMENT");
AnimateCircle("strength", 0.7,"STRENGTH");
AnimateCircle("power", 0.5,"POWER");
AnimateCircle("endurance", 0.3,"ENDURANCE");

function AnimateCircle(container_id, animatePercentage,type) {
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
            value: "<h4 style='padding-top:30px; color:black !important; '><b>"+type+"</b></h4>"+ "<h4 style='text-align:center; font-size:8em; margin-top:-25px'><b>"+(animatePercentage )*10+ "</b></h1>",
            className: 'progressbar__label'
        },
        // Set default step function for all animate calls
        step: function (state, circle) {
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

AnimateLine("linechart",0.8,"Mobility")
AnimateLine("lower",0.6,"Lower")
AnimateLine("absolute",0.4,"Absolute")
AnimateLine("absolute1",0.4,"Absolute")
AnimateLine("stability",0.8,"Stability")
AnimateLine("push",0.5,"Push")
AnimateLine("relative",0.5,"Relative")
AnimateLine("relative1",0.2,"Relative")
AnimateLine("pull",0.9,"Pull")
function AnimateLine(container_id, animatePercentage,type){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {
  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#F18F01',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '95%', height: '100%'},


        text: {
        // Initial value for text.
        // Default: null
        value: type+' &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp '+animatePercentage*10+'/10',

        // Class name for text element.
        // Default: 'progressbar-text'
        className: 'progressbar_linelabel',
          style: {
            // Text color.
            // Default: same as stroke color (options.color)
            color: '#f00',
            position: 'absolute',
            
            top: '-60%',
            padding: 0,
             }
         }


});
bar.path.style.strokeLinecap = 'round';

bar.animate(animatePercentage);  // Number from 0.0 to 1.0


}
     
TrakScore("shoulderL",0.5);
TrakScore("shoulderR",0.5);
TrakScore("externalShoulderR",0.7);
TrakScore("externalShoulderL",1);
TrakScore("internalShoulderR",1);
TrakScore("internalShoulderL",1);
TrakScore("trunkRotationR",0.6);
TrakScore("trunkRotationL",0.6);
TrakScore("hipBridgeR",1);
TrakScore("hipBridgeL",1);
TrakScore("plank",1);
TrakScore("plankL",1);
TrakScore("trunk",1);
TrakScore("deepSquat",0.5);

function TrakScore(container_id, animatePercentage){
var element = document.getElementById(container_id);

var bar = new ProgressBar.Line(element, {

  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 1400,
  color: '#F18F01',
  trailColor: '#eee',
  trailWidth: 3,
  svgStyle: {width: '85%', height: '7%'},


        text: {
        // Initial value for text.
        // Default: null
        value: animatePercentage*10+'/10',

        // Class name for text element.
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