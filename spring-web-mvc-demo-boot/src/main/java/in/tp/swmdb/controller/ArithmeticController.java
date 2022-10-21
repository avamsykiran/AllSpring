package in.tp.swmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.tp.swmdb.model.ArithmeticModel;
import in.tp.swmdb.service.ArithmeticService;

@Controller
public class ArithmeticController {

	@Autowired
	private ArithmeticService arthService;
	
	@GetMapping("/arth")
	public String showInputPage() {
		return "arthInputPage";
	}
	
	@PostMapping("/arth")
	public ModelAndView showOutputPage(@ModelAttribute ArithmeticModel arthModel) {
		arthService.computeResults(arthModel);
		return new ModelAndView("arthOutputPage","arth",arthModel);
	}
}
