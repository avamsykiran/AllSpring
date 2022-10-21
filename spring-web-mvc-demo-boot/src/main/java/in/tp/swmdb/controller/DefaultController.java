package in.tp.swmdb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	
	@Value("#{${app.title}}")
	private String appTitle;
	
	@GetMapping({"","/","/home"})
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home");
		
		mv.addObject("pageTitle","Home Page - Welcoem All");
		mv.addObject("developers",new String[] {"Vamsy","Venkat","Srini"});
		
		return mv;
	}
	
	@RequestMapping("/header")
	public String getHeaderPage() {
		return "header";
	}
	
	@RequestMapping("/footer")
	public String getFooterPage() {
		return "footer";
	}

	@GetMapping("/hello")
	public ModelAndView sayHello(
			@RequestParam(name="salut",required=false,defaultValue="Mr.") String salutation,
			@RequestParam(name="unm",required=false,defaultValue="Somebody") String userName) {
		
		return new ModelAndView("helloPage","msg","Hello! "+ salutation + userName);
	}
}
