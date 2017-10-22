$(document).ready(function() {
    function Search() {
        $("#basics").keyup(function(e) {
            this.query = e.target.value;
            this.delaySearch && clearTimeout(this.delaySearch);
            this.delaySearch = setTimeout(() => {

                var options = {
                    url: function(query) {
                        return "/getClient?query=" + query + "&format=json";
                    },

                    getValue: function(url) {
                        return url.name + " " + url.lastName
                    },

                    list: {

                        onClickEvent: function() {
                            var value = $("#basics").getSelectedItemData();
                                             
                           
                            value.survey.forEach(function(surveyData){
                            	  $('#sel1').append(new Option(new Date(surveyData.submittedDate).toDateString(), surveyData.id));
                            })


                        }
                    }

                };

                $('#basics').easyAutocomplete(options);

            }, 200);
        });
    }


    Search();


    function Search2() {
        $("#secondClient").keyup(function(e) {
            this.query = e.target.value;
            this.delaySearch && clearTimeout(this.delaySearch);
            this.delaySearch = setTimeout(() => {

                var options = {
                    url: function(query) {
                        return "/getClient?query=" + query + "&format=json";
                    },

                    getValue: function(url) {
                        return url.name + " " + url.lastName
                    },

                    list: {

                        onClickEvent: function() {
                            var value = $("#secondClient").getSelectedItemData();
                                             
                           
                            value.survey.forEach(function(surveyData){
                            	  $('#sel2').append(new Option(new Date(surveyData.submittedDate).toDateString(), surveyData.id));
                            })


                        }
                    }
                };

                $('#secondClient').easyAutocomplete(options);

            }, 200);
        });
    }


    Search2();


});