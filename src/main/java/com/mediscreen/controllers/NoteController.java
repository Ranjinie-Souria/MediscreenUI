package com.mediscreen.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import com.mediscreen.services.NoteService;
import com.mediscreen.services.PatientService;

@Controller
public class NoteController {
	
	@Autowired
	NoteService nservice;
	
	@Autowired
	PatientService service;
	
	@GetMapping("/notes")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("/notes/list");
		List<Note> list = nservice.getNotes();
		mv.addObject("notes", list);
		return mv;
	}
	
	@GetMapping("/notes/add")
	public ModelAndView createPatient(Patient patient) {
		ModelAndView mv = new ModelAndView("/patients/add");
		Patient p = new Patient();
		mv.addObject("patient", p);
		return mv;
	}
	
	@GetMapping("/notes/update/{id}")
	public ModelAndView updateEmployee(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("/patients/edit");
		Patient patient = service.getPatient(id);		
		mv.addObject("patient", patient);	
		return mv;		
	}
	
	@GetMapping("/notes/delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable int id) {
		service.deletePatient(id);
		return new ModelAndView("redirect:/patients");		
	}
	
	@PostMapping("/saveNote")
	public ModelAndView savePatient(Integer patientId,String familyName,String firstName,Date birthdate,String gender,String address,String phone) {
		service.savePatient(new Patient(patientId,familyName,firstName,birthdate,gender,address,phone));
		return new ModelAndView("redirect:/patients");	
	}

}
