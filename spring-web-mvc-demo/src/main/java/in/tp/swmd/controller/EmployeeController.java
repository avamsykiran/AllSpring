package in.tp.swmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.tp.swmd.model.Employee;
import in.tp.swmd.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@ModelAttribute
	public void populateCommonModels(Model model) {
		model.addAttribute("designations", new String[] {
				"Assosiate","Jr.Assosiate","Sr.Assosiate","Manager","Archetect"
		});
	}
	
	@GetMapping
	public ModelAndView showEmpInput() {
		return new ModelAndView("empInputPage","emp",new Employee());
	} 
	
	@PostMapping
	public ModelAndView showEmpOutput(@ModelAttribute("emp") Employee emp) {
		empService.computeAllowences(emp);
		return new ModelAndView("empOutputPage","emp",emp);
	}
}