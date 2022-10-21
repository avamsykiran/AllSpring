package in.tp.sbcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.tp.sbcrud.model.Department;
import in.tp.sbcrud.model.Employee;
import in.tp.sbcrud.service.EmployeeService;

@Controller
public class EmployeeController {

	public final static int SAVED=1;
	public final static int DELETED=2; 
	
	@Autowired
	private EmployeeService empService;
	
	@ModelAttribute
	public void populateCommonData(Model model) {
		model.addAttribute("depts",Department.values());
	}
	
	@GetMapping("/emps")
	public ModelAndView empListRequestHandler() {
		return new ModelAndView("empListPage","emps",empService.findAll());
	}
	
	@GetMapping("/newEmp")
	public ModelAndView newEmpRequestHandler() {
		return new ModelAndView("empFormPage","emp",new Employee());
	}
	
	@PostMapping("/newEmp")
	public ModelAndView saveEmpRequestHandler(
			@Valid @ModelAttribute("emp")Employee emp,BindingResult results) {
		
		ModelAndView mv;
		
		if(results.hasErrors()) {
			mv=new ModelAndView("empFormPage","emp",emp);
		}else {
			emp = empService.save(emp);
			long empId=emp.getEmpId();
			mv = new ModelAndView("redirect:/home?id="+empId+"&msgCode="+SAVED);
		}
		
		return mv;
	}
	
	@GetMapping("/searchEmp")
	public ModelAndView searchEmpRequestHandler() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
}
