package in.nit.hcma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import in.nit.hcma.entities.Specialization;
import in.nit.hcma.exception.SpecializationNotFoundException;
import in.nit.hcma.services.SpecializationService;
import in.nit.hcma.views.SpecializationExport;

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
									Model model,
									RedirectAttributes attributes)
	
	{
		specialization=specializationService.saveSpecialization(specialization);
		String message="Data Saved successfully :"+specialization.getId();
		attributes.addAttribute("message",message);
		return "redirect:all";
	}
	
	@GetMapping("/all")
	public String getAllSpecialization(
									   Model model,
									   @RequestParam (value="message",required = false) String message) {
			
		List<Specialization> specializations=specializationService.getAllSpecialization();
		model.addAttribute("specializations", specializations);
		model.addAttribute("message", message);
		return "SpecializationData";
		
	}
	
	@GetMapping("/delete")
	public String deleteSpecialization(@RequestParam Long id,
									   RedirectAttributes attributes)
	{
		try {
			specializationService.deleteSpecialization(id);
			String message=" Specialization '"+id+"' deleted successfully";
			attributes.addAttribute("message", message);
			
		}
		catch (SpecializationNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			
			
		}
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String editSpecialization(@RequestParam Long id,
			Model model,
			RedirectAttributes attributes
			) 
	{
		String page = null;
		try {
			Specialization spec = specializationService.getSpecialization(id);
			model.addAttribute("specialization", spec);
			page = "EditSpecialization";
		} catch (SpecializationNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}
	
	
	@PostMapping("/update")
	public String updateSpecialization(@ModelAttribute Specialization specialization,
										Model model,
										RedirectAttributes attributes)
	
	{
		specialization=specializationService.saveSpecialization(specialization);
		String message=" Specialization '"+specialization.getId()+"' updated successfully";
		attributes.addAttribute("message", message);
		return "redirect:all";
	}
	
	@GetMapping("/checkCode")
	@ResponseBody
	public String validateSpecCode(
			@RequestParam String code
			) 
	{
		String message = "";
		if(specializationService.isSpecCodeExist(code)) {
			message = code + ", already exist";
		} 
		
		return message; //this is not viewName(it is message)
	}
	
	@GetMapping("/excel")
	public ModelAndView excelExport() {
		ModelAndView m=new ModelAndView();
		m.setView(new SpecializationExport());
		List<Specialization> specializations=specializationService.getAllSpecialization();
		m.addObject("specializations", specializations);
		
		return m;
		
	}

}
