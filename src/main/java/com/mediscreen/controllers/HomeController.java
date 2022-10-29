package com.mediscreen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mediscreen.services.PatientService;

@Controller
public class HomeController {
	
	@Autowired
	PatientService service;
	
	@GetMapping("/")
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

}
