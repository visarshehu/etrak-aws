$(document).ready(function() {
  function Search() {
    $(".basics").keyup(function(e) {
      this.query = e.target.value;
      this.delaySearch && clearTimeout(this.delaySearch);
      this.delaySearch = setTimeout(() => {
        
    	  var options = {
    				url: function(query) {
    					return "/getClient?query=" + query + "&format=json";
    				},

    				getValue:function(url){
    					return url.name+" "+url.lastName
    				}
    				
    			};
    	  
    	  $('.basics').easyAutocomplete(options);
    	
    	 
       // alert("searching for: " + this.query);
      }, 200);
    });
  }
 Search();
 

});

