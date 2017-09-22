

AnimateLineP("absolutepower",0.9)
AnimateLineP("poweroutput",0.7)
AnimateLineP("peakpower",0.5)
AnimateLineP("powerratio1",0.3)
AnimateLineP("powerratio6",0.1)
AnimateLineP("vo2max",0.3)
AnimateLineP("4poweroutput",0.5)
AnimateLineP("4powerratio",0.7)

function AnimateLineP(container_id, animatePercentage){
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


