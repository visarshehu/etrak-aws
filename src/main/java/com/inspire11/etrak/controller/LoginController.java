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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.inspire11.etrak.model.Client;
import com.inspire11.etrak.model.SurveyData;
import com.inspire11.etrak.model.User;
import com.inspire11.etrak.service.CalculateService;
import com.inspire11.etrak.service.ClientService;
import com.inspire11.etrak.service.SurveyService;
import com.inspire11.etrak.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private SurveyService surveyService;

	@Autowired
	private CalculateService calculateService;

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

	@RequestMapping(value = "user/comparison", method = RequestMethod.GET)
	public ModelAndView comparison() {
		ModelAndView modelAndView = new ModelAndView();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
		modelAndView.addObject("userId", user.getId());
		modelAndView.setViewName("user/comparison");
		return modelAndView;
	}

	@RequestMapping(value = "user/clients", method = RequestMethod.GET)
	public ModelAndView allclients() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
		modelAndView.addObject("userId", user.getId());
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
		ModelAndView modelAndView = new ModelAndView();
		long clientId=survey_data.client.getId();
		SurveyData newSurvey = surveyService.saveSurvey(survey_data);
		Long surveyId = newSurvey.getId();
		calculateService.CalculateMovement(surveyId);
		calculateService.CalculatePower(surveyId);
		calculateService.CalculateStrength(surveyId);
		calculateService.CalculateEndurance(surveyId);
		modelAndView.addObject("successMessage", "Your client's data has been registered successfully!");
		/*modelAndView.addObject("survey", new SurveyData());
		modelAndView.setViewName("user/assessment");
		return modelAndView;*/
		return new ModelAndView("redirect:/user/clientStat?getId="+clientId);
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
		modelAndView.setViewName("user/assessment");
		return modelAndView;
	}

	
	@RequestMapping(value = { "/user/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView modelAndView = new ModelAndView();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
		modelAndView.addObject("userId", user.getId());
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
