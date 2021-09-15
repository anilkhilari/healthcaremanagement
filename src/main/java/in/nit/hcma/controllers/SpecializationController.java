package in.nit.hcma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.hcma.entities.Specialization;
import in.nit.hcma.services.SpecializationService;

@Controller
@RequestMapping("/specialization")
public class SpecializationController {
	
	@Autowired
	private SpecializationService specializationService;
	//@RequestMapping(value = "/show" , method = RequestMethod.GET)
	@GetMapping("/show")
	public String showSpecialization() {
		
		return "Specialization";
	}
	
	@PostMapping("/save")
	public String saveSpecialization(@ModelAttribute Specialization specialization,
						Model model)
	
	{
		specialization=specializationService.saveSpecialization(specialization);
		String data="Data Saved successfully :"+specialization.getId();
		model.addAttribute("data",data);
		List<Specialization> specializations=specializationService.getAllSpecialization();
		model.addAttribute("specializations", specializations);
		return "SpecializationData";
	}
	
	@GetMapping("/all")
	public String getAllSpecialization(Model model)
	{
		List<Specialization> specializations=specializationService.getAllSpecialization();
		model.addAttribute("specializations", specializations);
		return "SpecializationData";
	}
	
	@GetMapping("/delete")
	public String deleteSpecialization(@RequestParam Integer id,Model model)
	{
		specializationService.deleteSpecialization(id);
		String message=" Specialization '"+id+"' deleted successfully";
		model.addAttribute("message", message);
		List<Specialization> specializations=specializationService.getAllSpecialization();
		model.addAttribute("specializations", specializations);
		return "SpecializationData";
	}
	
	@GetMapping("/edit")
	public String editSpecialization(@RequestParam Integer id,
									Model model)
	{
		Specialization specialization=specializationService.getSpecialization(id);
		model.addAttribute("specialization", specialization);
		return "EditSpecialization";
	}
	
	@PostMapping("/update")
	public String updateSpecialization(@ModelAttribute Specialization specialization,
						Model model)
	
	{
		specialization=specializationService.saveSpecialization(specialization);
		String data="Data Saved successfully :"+specialization.getId();
		model.addAttribute("data",data);
		List<Specialization> specializations=specializationService.getAllSpecialization();
		model.addAttribute("specializations", specializations);
		return "SpecializationData";
	}

}
