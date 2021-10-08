package in.nit.hcma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.hcma.services.IPatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private IPatientService service;
	
	@GetMapping("/register")
	private String showPatientRegister() {
		
		return "PatientRegister";
	}

}
