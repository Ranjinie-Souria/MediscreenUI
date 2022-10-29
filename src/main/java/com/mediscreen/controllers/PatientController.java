package com.mediscreen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mediscreen.model.Patient;
import com.mediscreen.services.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	PatientService service;
	
	@GetMapping("/patients")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("/patients/list");
		List<Patient> listPatients = service.getPatients();
		mv.addObject("patients", listPatients);
		return mv;
	}
	
	@GetMapping("/patients/add")
	public ModelAndView createPatient(Patient patient) {
		return new ModelAndView("/patients/add");
	}
	
	@GetMapping("/patients/update/{id}")
	public ModelAndView updateEmployee(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("/patients/edit");
		Patient patient = service.getPatient(id);		
		mv.addObject("patient", patient);	
		return mv;		
	}
	
	@GetMapping("/patients/delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable int id) {
		service.deletePatient(id);
		return new ModelAndView("redirect:/patients");		
	}
	
	@PostMapping("/savePatient")
	public ModelAndView savePatient(@ModelAttribute Patient patient) {
		service.savePatient(patient);
		return new ModelAndView("redirect:/patients");	
	}

}