package in.tp.swmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.tp.swmdb.service.GreetService;

@Controller
public class WelcomeController {
	
	@Autowired
	private GreetService greetService;
	
	@RequestMapping("/greet")
	public ModelAndView showGreetPage(@RequestParam(name="unm",required=false) String userName) {
		ModelAndView mv =new ModelAndView();
		mv.setViewName("greet");
		
		if(userName!=null) {
			mv.addObject("greetings",greetService.getGreeting() + userName);
		}
		
		return mv;
	}

}
