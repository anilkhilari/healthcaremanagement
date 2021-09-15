package in.nit.hcma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.hcma.services.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/show")
	public String show() {
		
		return "Doctor";
	}
	

}
