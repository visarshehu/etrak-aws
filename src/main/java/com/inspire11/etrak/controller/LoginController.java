package com.inspire11.etrak.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.nio.file.Paths;
import com.inspire11.etrak.model.Client;
import com.inspire11.etrak.model.CompareInfo;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.model.SurveyInfoSession;
import com.inspire11.etrak.model.User;
import com.inspire11.etrak.service.CalculateComparison;
import com.inspire11.etrak.service.CalculateService;
import com.inspire11.etrak.service.CalculateStatisticsService;
import com.inspire11.etrak.service.ClientService;

import com.inspire11.etrak.service.SurveyService;
import com.inspire11.etrak.service.UserService;

@Controller
@SessionAttributes("surveyInfo")
public class LoginController {

	@Autowired
	private UserService userService;


	@Autowired
	private ClientService clientService;
	

	@Autowired
	private SurveyService surveyService;
	

	@Autowired
	private CalculateService calculateService;
	
	@Autowired
	private CalculateStatisticsService calculateStatistics;
	

	@Autowired
	private CalculateComparison calculateComparisonService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView modelAndView = new ModelAndView();
		if (logout != null) {
			modelAndView.addObject("msg", "You've been logged out successfully.");
		}
		modelAndView.setViewName("login");
		return modelAndView;
	}

	
	@RequestMapping(value = { "/", "/registration" }, method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "user/comparison", method = RequestMethod.GET, params = { "firstId", "secondId" })
	public ModelAndView comparison(@RequestParam(value = "firstId", required = true) String firstId,
	@RequestParam(value = "secondId", required = true) String secondId,@ModelAttribute("surveyInfo") SurveyInfoSession info,SessionStatus status) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("firstClient", firstId);
		modelAndView.addObject("secondClient", secondId);
		modelAndView.addObject("firstSurvey",info.getFirstSurvey());
		modelAndView.addObject("secondSurvey",info.getSecondSurvey());
		modelAndView.addObject("surveyId",info.getSurveyId());
		Client clientData = clientService.getClientById(Long.parseLong(firstId));
		modelAndView.addObject("first", clientData.getName() + " " + clientData.getLastName());
		Client clientData1 = clientService.getClientById(Long.parseLong(secondId));
		modelAndView.addObject("second", clientData1.getName() + " " + clientData1.getLastName());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
		modelAndView.addObject("userId", user.getId());
		modelAndView.setViewName("user/comparison");
		status.setComplete();
		return modelAndView;
		
	}

	@RequestMapping(value = "user/clients", method = RequestMethod.GET)
	public ModelAndView allclients() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
		modelAndView.addObject("userId", user.getId());
		modelAndView.addObject("client", new Client());
		modelAndView.setViewName("user/clients");
		return modelAndView;
	}

	@RequestMapping(value = "/user/clients", method = RequestMethod.POST)
	public ModelAndView addNewClient(@Valid Client client, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		clientService.saveClient(client);
		modelAndView.addObject("successMessage", "New client has been registered!");
		modelAndView.addObject("client", new Client());
		modelAndView.setViewName("user/clients");
		return modelAndView;

	}

	
	@RequestMapping(value = "/user/assessment", method = RequestMethod.POST)
	public ModelAndView createNewSurvey(@Valid SurveyData survey_data, BindingResult bindingResult) {
		
		long clientId = survey_data.getClient().getId();
		SurveyData newSurvey = surveyService.saveSurvey(survey_data);
		Long surveyId = newSurvey.getId();
		calculateService.CalculateMovement(surveyId);
		calculateService.CalculatePower(surveyId);
		calculateService.CalculateStrength(surveyId);
		calculateService.CalculateEndurance(surveyId);
		calculateService.CalculateNutrition(surveyId);
		
		return new ModelAndView("redirect:/user/clientStat?getId=" + clientId);
	}


	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		User usernameExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (usernameExists != null) {
			bindingResult.rejectValue("username", "error.user", "Username already in use!");
		}
		if (!user.getConfirmPassword().equals(user.getPassword())) {
			bindingResult.rejectValue("password", "error.user", "Passwords don't match!");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Your account has been registered successfully!");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	@RequestMapping(value = "/user/assessment/{clientId}")
	@ResponseBody
	public ModelAndView openSurvey(@PathVariable(value = "clientId") String clientId) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
		modelAndView.addObject("userId", user.getId());
		modelAndView.addObject("clientId", clientId);
		modelAndView.addObject("survey_data", new SurveyData());
		modelAndView.setViewName("user/assessment");
		return modelAndView;
	}

	@RequestMapping(value = { "/user/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		double activeScore=calculateStatistics.activeScore();
		int[] ageUnder=calculateStatistics.AverageAge();
		double improvementMale=calculateStatistics.CalculateImprovement('M');
		double improvementFemale=calculateStatistics.CalculateImprovement('F');
		double[] calculateActiveRatio=calculateStatistics.CalculateStatistics();
		double top10F=calculateStatistics.top10('F');
		double top10M=calculateStatistics.top10('M');
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
		modelAndView.addObject("userId", user.getId());
		modelAndView.addObject("activeScore",activeScore);
		modelAndView.addObject("improvementFemale",improvementFemale);
		modelAndView.setViewName("user/dashboard");
		return modelAndView;
	}

	@RequestMapping(value = "/user/clientStat", method = RequestMethod.POST, consumes = "multipart/form-data")
	public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		Long userId = user.getId();
		if (!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			Path p = Paths.get("upload-dir");
			File destination = new File(p.resolve(userId + ".jpg").toString());
			ImageIO.write(src, "jpg", destination);
			return "redirect:/user/clientStat";
		} else
			return "redirect:/user/clientStat";

	}

	
	@RequestMapping(value = "/user/comparison", method = RequestMethod.POST )
	public String compareClients(@Valid CompareInfo compare, BindingResult bindingResult, Model model) {
		
		long firstSurvey = compare.getFirstSurvey();
		long secondSurvey = compare.getSecondSurvey();
		
		SurveyData survey = surveyService.getSurveyById(firstSurvey);
		Long firstClient = survey.getClient().getId();
		SurveyData second = surveyService.getSurveyById(secondSurvey);
		Long secondClient = second.getClient().getId();
		calculateComparisonService.MovementComparison(firstSurvey, secondSurvey);
		calculateComparisonService.PowerComparison(firstSurvey, secondSurvey);
		calculateComparisonService.StrengthComparison(firstSurvey, secondSurvey);		
		calculateComparisonService.EveryComparison(firstSurvey, secondSurvey);
		calculateComparisonService.NutritionComparison(firstSurvey, secondSurvey);
		Long id=calculateComparisonService.EnduranceComparison(firstSurvey, secondSurvey);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("firstSurvey",firstSurvey);
		modelAndView.addObject("secondSurvey",secondSurvey);
		modelAndView.addObject("surveyId",id);
		if(!model.containsAttribute("surveyInfo")) {
			SurveyInfoSession surveyInfo=new SurveyInfoSession();
			surveyInfo.setFirstSurvey(String.valueOf(firstSurvey));
			surveyInfo.setSecondSurvey(String.valueOf(secondSurvey));
			surveyInfo.setSurveyId(String.valueOf(id));
			model.addAttribute("surveyInfo",surveyInfo);
		}

		return "redirect:/user/comparison?firstId=" + firstClient + "&secondId=" + secondClient;
	}

	@RequestMapping(value = "/user/clientStat", method = RequestMethod.GET, params = { "getId" })
	@ResponseBody
	public ModelAndView getClientStat(@RequestParam(value = "getId", required = true) String getId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		long clientId = 0;
		clientId = Long.parseLong(getId);
		Client client = clientService.getClientById(clientId);
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
		modelAndView.addObject("userId", user.getId());
		modelAndView.addObject("clientId", getId);
		modelAndView.addObject("id", client.getName() + " " + client.getLastName());
		modelAndView.setViewName("user/clientStat");
		return modelAndView;
	}
	
	
	

}
