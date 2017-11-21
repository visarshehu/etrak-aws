package com.inspire11.etrak.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.inspire11.etrak.model.Client;
import com.inspire11.etrak.model.LookUpTables;
import com.inspire11.etrak.model.SurveyComparison;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.model.SurveyDataResults;
import com.inspire11.etrak.model.View;
import com.inspire11.etrak.repository.SurveyDataRepository;
import com.inspire11.etrak.repository.SurveyDataResultsRepository;
import com.inspire11.etrak.service.CalculateStatisticsService;
import com.inspire11.etrak.service.ClientService;
import com.inspire11.etrak.service.LookUpService;
import com.inspire11.etrak.service.SurveyComparisonService;
import com.inspire11.etrak.service.SurveyService;

@RestController
public class ClientRestController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LookUpService lookupService;
	
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private CalculateStatisticsService statisticsSurvey;
	
	@Autowired
	private SurveyComparisonService comparisonService;
	
	@Autowired
	private SurveyDataResultsRepository surveydataRepo;
	

	@JsonView(View.ClientsWithSurvey.class)
	@RequestMapping(path="clients", method=RequestMethod.GET)
	public List<Client> getAllClients(){
		return clientService.getAllClients();
	}
	
	@JsonView(View.ClientsWithSurvey.class)
    @RequestMapping(value = "clients/{id}", method = RequestMethod.GET)
	public Client getClientById(@PathVariable("id") long id){
		
    	return clientService.getClientById(id);
	}
    
    @JsonView(View.SurveyWithClients.class)
    @RequestMapping(value = "survey/{id}", method = RequestMethod.GET)
   	public SurveyData getSurveyById(@PathVariable("id") long id, final HttpServletResponse response){
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    	return surveyService.getSurveyById(id);
   			
   	}
    
    @RequestMapping(value = "surveytop", method = RequestMethod.GET)
   	public List<SurveyDataResults> getSurveyTop(final HttpServletResponse response){
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    	return surveydataRepo.findTop5ByOrderByEtrakScoreDesc();
   			
   	}
    
    /*@RequestMapping(value = "surveyInfo/{gender}", method = RequestMethod.GET)
   	public List<SurveyData> getSurveyInfo(@PathVariable("gender") char gender,final HttpServletResponse response){
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    	return surveyService.findTopClients(gender);
  
   			
   	}*/
    
    @RequestMapping(value = "comparisonResults/{id}", method = RequestMethod.GET)
   	public SurveyComparison getComparisonResultById(@PathVariable("id") long id, final HttpServletResponse response){
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    	return comparisonService.getSurveyById(id);
   	}
       
    @RequestMapping(value = "scores/{name}", method = RequestMethod.GET)
  	public LookUpTables getLookUp(@PathVariable("name") String name){
  		return lookupService.findByName(name);
  	}
    
    @JsonView(View.ClientsWithSurvey.class)
    @RequestMapping(value="getClient",method=RequestMethod.GET)
    public @ResponseBody List<Client> getClient(@RequestParam("query") String query) {
    	return clientService.findByNameContainsOrLastNameContainsAllIgnoreCase(query,query);
    	
    }
    
    @RequestMapping(value="getDashboard/{gender}",method=RequestMethod.GET)
    public @ResponseBody List<Client> getTopClients(@PathVariable("gender") char gender) {
    	return clientService.findTop5ByGenderOrderBySurvey_SurveyDataResults_EtrakScoreDesc(gender);
    	
    }
    
    @JsonView(View.SurveyWithClients.class)
    @RequestMapping(value="getSurveyData/{gender}",method=RequestMethod.GET)
    public @ResponseBody List<SurveyData> getTopSurveys(@PathVariable("gender") char gender) {
    	List<SurveyData> survey=surveyService.findByClient_GenderOrderBySurveyDataResults_EtrakScoreDesc(gender);
    	return survey;
    	
    }
    
    @JsonView(View.SurveyWithClients.class)
    @RequestMapping(value="getAllSurveys",method=RequestMethod.GET)
    public @ResponseBody List<SurveyData> getSurveys(){
    	return surveyService.findAll();
    }
    
    @JsonView(View.SurveyWithClients.class)
    @RequestMapping(value="getActivityFeed",method=RequestMethod.GET)
    public @ResponseBody List<SurveyData> getLatestActivity() {
    	return surveyService.findTop5ByOrderBySubmittedDateDesc();
    	
    }
    
    
    @RequestMapping(value="SurveyNumbers", method=RequestMethod.GET)
    public @ResponseBody long getNumberSurveys() {
    	return statisticsSurvey.CalculateStatistics();
    }
    
    @RequestMapping(value="CalculateImprovement", method=RequestMethod.GET)
    public @ResponseBody Double getImprovementScore() {
    	return statisticsSurvey.CalculateImprovement();
    }

 
}
